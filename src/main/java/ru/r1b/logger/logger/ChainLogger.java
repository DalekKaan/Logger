package ru.r1b.logger.logger;

import ru.r1b.logger.Channel;
import ru.r1b.logger.Formatter;
import ru.r1b.logger.Logger;
import ru.r1b.logger.formatter.DateTimeLog;

import java.time.format.DateTimeFormatter;

public class ChainLogger implements Logger {
    public static final int LEVEL_DEBUG = 10;
    public static final int LEVEL_INFO = 20;
    public static final int LEVEL_ERROR = 30;

    Channel channel;
    int level = LEVEL_INFO;
    ChainLogger next;
    Formatter formatter;

    public int getLevel() {
        return level;
    }

    public ChainLogger(Channel channel) {
        this.channel = channel;
        this.formatter = new DateTimeLog(DateTimeFormatter.ISO_DATE_TIME);
    }

    public ChainLogger(Channel channel, int level, Formatter formatter) {
        this.channel = channel;
        this.level = level;
        this.formatter = formatter;
    }

    public ChainLogger(Channel channel, int level, ChainLogger next, Formatter formatter) {
        this.channel = channel;
        this.level = level;
        this.next = next;
        this.formatter = formatter;
    }

    @Override
    public void log(String message, int level) {
        if (this.level <= level) {
            channel.write(formatter.format(message));
        }
        if (next != null) {
            next.log(message, level);
        }
    }
}
