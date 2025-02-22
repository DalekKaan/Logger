package ru.r1b.logger.formatter;

import ru.r1b.logger.Formatter;

public class LeveledLog extends FormattedLog {
    int level;

    public LeveledLog(int level) {
        this.level = level;
    }

    public LeveledLog(int level, Formatter prev) {
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
