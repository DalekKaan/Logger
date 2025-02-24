package ru.r1b.logger;

import ru.r1b.logger.channel.FileChannel;
import ru.r1b.logger.channel.StdErrChannel;
import ru.r1b.logger.channel.StdOutChannel;
import ru.r1b.logger.config.ChanelConfig;
import ru.r1b.logger.config.FormatterConfig;
import ru.r1b.logger.config.LoggerConfig;
import ru.r1b.logger.formatter.DateTimeLog;
import ru.r1b.logger.formatter.LeveledLog;
import ru.r1b.logger.logger.ChainLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class LoggerFactory {

    public static Logger make(LoggerConfig loggerConfig) {
        ArrayList<Channel> channels = new ArrayList<>();
        ArrayList<Formatter> formatters = new ArrayList<>();
        loggerConfig.channels().forEach(channelConfig -> {
            channels.add(makeChanel(channelConfig));
        });
        loggerConfig.formatters().forEach(formatterConfig -> {
            formatters.add(makeFormatter(formatterConfig));
        });
        return new ChainLogger(channels, LogLevel.valueOf(loggerConfig.level()), formatters);
    }

    private static Channel makeChanel(ChanelConfig chanelConfig) {
        return switch (chanelConfig.type()) {
            case Channel.STDOUT -> new StdOutChannel(chanelConfig);
            case Channel.STDERR -> new StdErrChannel(chanelConfig);
            case Channel.FILE -> new FileChannel(chanelConfig); // todo
            default -> null;
        };
    }

    private static Formatter makeFormatter(FormatterConfig formatterConfig) {
        return switch (formatterConfig.type()) {
            case "date" -> new DateTimeLog(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            case "level" -> new LeveledLog(LogLevel.valueOf(formatterConfig.getLevel())); // todo
            default -> null;
        };
    }
}
