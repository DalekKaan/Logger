package ru.r1b.logger.logger;

import ru.r1b.logger.Channel;
import ru.r1b.logger.Formatter;
import ru.r1b.logger.LogLevel;
import ru.r1b.logger.Logger;
import ru.r1b.logger.formatter.DateTimeLog;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ChainLogger implements Logger {

    ArrayList<Channel> channels;
    LogLevel level = LogLevel.INFO;
    ChainLogger next;
    ArrayList<Formatter> formatters = new ArrayList<>();

    public LogLevel getLevel() {
        return level;
    }

    public ChainLogger(ArrayList<Channel> channels) {
        this.channels = channels;
        this.formatters.add(new DateTimeLog(DateTimeFormatter.ISO_DATE_TIME));
    }

    public ChainLogger(ArrayList<Channel> channels, LogLevel level, ArrayList<Formatter> formatters) {
        this.channels = channels;
        this.level = level;
        this.formatters = formatters;
    }

    public ChainLogger(ArrayList<Channel> channels, LogLevel level, ChainLogger next, ArrayList<Formatter> formatters) {
        this.channels = channels;
        this.level = level;
        this.next = next;
        this.formatters = formatters;
    }

    public void log(String message, LogLevel level) {
        if (this.level.getLevel() > level.getLevel()) {
            return;
        }
        // todo: deal with loops
        for (Formatter formatter : formatters) {
            message = formatter.format(message);
        }
        for (Channel c : channels) {
            c.write(message);
        }
        if (next != null) {
            next.log(message, level);
        }
    }
}
