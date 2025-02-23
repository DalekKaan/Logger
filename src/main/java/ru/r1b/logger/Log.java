package ru.r1b.logger;

import ru.r1b.logger.channel.FileChannel;
import ru.r1b.logger.channel.StdErrChannel;
import ru.r1b.logger.channel.StdOutChannel;
import ru.r1b.logger.config.FileLoggerConfig;
import ru.r1b.logger.formatter.DateTimeLog;
import ru.r1b.logger.formatter.LeveledLog;
import ru.r1b.logger.logger.ChainLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Objects;

public class Log {
    LinkedList<Logger> loggers = new LinkedList<>();

    public Log(LinkedList<Config> configs) {
        configs.stream()
                .map(this::makeLogger)
                .filter(Objects::nonNull)
                .forEach(logger -> loggers.add(logger));
    }

    private Logger makeLogger(Config config) {
        Channel channel = makeChanel(config);
        if (channel == null) {
            return null;
        }

        return new ChainLogger(
                channel,
                LogLevel.valueOf(config.getLevel()),
                makeFormatter(config)
        );
    }

    private Channel makeChanel(Config config) {
        switch (config.getChannel()) {
            case Channel.STDOUT: return new StdOutChannel(config);
            case Channel.STDERR: return new StdErrChannel(config);
            case Channel.FILE:
                if (config instanceof FileLoggerConfig) {
                    FileLoggerConfig _config = (FileLoggerConfig) config;
                    try {
                        return new FileChannel(
                                config,
                                new BufferedWriter(new FileWriter(_config.getPath()))
                        );
                    } catch (IOException ignored) {}
                }
                break;
        }
        return null;
    }

    private Formatter makeFormatter(Config config) {
        Formatter formatter = null;
        Formatter prev;
        for (String format : config.getFormatters()) {
            prev = formatter;
            switch (format) {
                case "date": formatter = new DateTimeLog(DateTimeFormatter.ISO_LOCAL_DATE_TIME); break;
                case "level": formatter = new LeveledLog(LogLevel.valueOf(config.getLevel())); break;
            }
            if (formatter != null && prev != null) {
                formatter.setPrev(prev);
            }
        }
        return formatter;
    }
}
