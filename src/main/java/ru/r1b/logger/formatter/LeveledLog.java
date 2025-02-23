package ru.r1b.logger.formatter;

import ru.r1b.logger.Formatter;
import ru.r1b.logger.LogLevel;

public class LeveledLog extends FormattedLog {
    LogLevel level;

    public LeveledLog(LogLevel level) {
        this.level = level;
    }

    public LeveledLog(LogLevel level, Formatter prev) {
        super(prev);
        this.level = level;
    }

    @Override
    public String format(String message) {
        if (prev != null) {
            message = prev.format(message);
        }
        return "[" + level + "] " + message;
    }
}
