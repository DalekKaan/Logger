package ru.r1b.logger.logger;

import ru.r1b.logger.Channel;
import ru.r1b.logger.Formatter;
import ru.r1b.logger.LogLevel;
import ru.r1b.logger.Logger;
import ru.r1b.logger.formatter.DateTimeLog;

import java.time.format.DateTimeFormatter;

public class ChainLogger implements Logger {

    Channel channel;
    LogLevel level = LogLevel.INFO;
    ChainLogger next;
    Formatter formatter;

    public LogLevel getLevel() {
        return level;
    }

    public ChainLogger(Channel channel) {
        this.channel = channel;
        this.formatter = new DateTimeLog(DateTimeFormatter.ISO_DATE_TIME);
    }

    public ChainLogger(Channel channel, LogLevel level, Formatter formatter) {
        this.channel = channel;
        this.level = level;
        this.formatter = formatter;
    }

    public ChainLogger(Channel channel, LogLevel level, ChainLogger next, Formatter formatter) {
        this.channel = channel;
        this.level = level;
        this.next = next;
        this.formatter = formatter;
    }

    public void log(String message, LogLevel level) {
        if (this.level.getLevel() <= level.getLevel()) {
            channel.write(formatter.format(message));
        }
        if (next != null) {
            next.log(message, level);
        }
    }
}
