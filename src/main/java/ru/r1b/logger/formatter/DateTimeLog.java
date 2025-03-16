package ru.r1b.logger.formatter;

import ru.r1b.logger.Formatter;
import ru.r1b.logger.config.formatter.DateTimeFormatterConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeLog extends FormattedLog {
    public static DateTimeLog make(DateTimeFormatterConfig config) {
        return new DateTimeLog(DateTimeFormatter.ofPattern(config.getFormat()));
    }

    private final DateTimeFormatter dtf;

    public DateTimeLog(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }

    public DateTimeLog(DateTimeFormatter dtf, Formatter prev) {
        super(prev);
        this.dtf = dtf;
    }

    @Override
    public String format(String message) {
        if (prev != null) {
            message = prev.format(message);
        }
        LocalDateTime now = LocalDateTime.now();
        return "[" + dtf.format(now) + "] " + message;
    }
}
