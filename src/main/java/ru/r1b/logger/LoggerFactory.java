package ru.r1b.logger;

import ru.r1b.logger.channel.FileChannel;
import ru.r1b.logger.channel.StdErrChannel;
import ru.r1b.logger.channel.StdOutChannel;
import ru.r1b.logger.config.formatter.DateTimeFormatterConfig;
import ru.r1b.logger.config.LoggerConfig;
import ru.r1b.logger.config.channel.FileChannelConfig;
import ru.r1b.logger.config.formatter.LeveledFormatterConfig;
import ru.r1b.logger.formatter.DateTimeLog;
import ru.r1b.logger.formatter.LeveledLog;
import ru.r1b.logger.logger.ChainLogger;

import java.util.ArrayList;

public class LoggerFactory {

    public static Logger make(LoggerConfig loggerConfig) {
        ArrayList<Channel> channels = new ArrayList<>();
        ArrayList<Formatter> formatters = new ArrayList<>();
        loggerConfig.channels().forEach(channelConfig -> {
            channels.add(makeChannel(channelConfig));
        });
        loggerConfig.formatters().forEach(formatterConfig -> {
            formatters.add(makeFormatter(formatterConfig));
        });
        return new ChainLogger(channels, LogLevel.valueOf(loggerConfig.level()), formatters);
    }

    private static Channel makeChannel(ru.r1b.logger.config.channel.Config channelConfig) {
        return switch (channelConfig.getType()) {
            case Channel.STDOUT -> new StdOutChannel(channelConfig);
            case Channel.STDERR -> new StdErrChannel(channelConfig);
            case Channel.FILE -> {
                if (!(channelConfig instanceof FileChannelConfig fileChannelConfig)) {
                    throw new IllegalArgumentException("channel config must be a FileChannel");
                }
                yield FileChannel.make(fileChannelConfig);
            }
            default -> null;
        };
    }

    private static Formatter makeFormatter(ru.r1b.logger.config.formatter.Config  formatterConfig) {
        return switch (formatterConfig.getType()) {
            case "date" -> {
                if (!(formatterConfig instanceof DateTimeFormatterConfig dateTimeFormatterConfig)) {
                    throw new IllegalArgumentException("formatter config must be a DateTimeFormatterConfig");
                }
                yield DateTimeLog.make(dateTimeFormatterConfig);
            }
            case "level" -> {
                if (!(formatterConfig instanceof LeveledFormatterConfig leveledFormatterConfig)) {
                    throw new IllegalArgumentException("formatter config must be a LeveledFormatterConfig");
                }
                yield new LeveledLog(LogLevel.valueOf(leveledFormatterConfig.getLevel()));
            }
            default -> null;
        };
    }
}
