package ru.r1b.logger;

public enum LogLevel {
    DEBUG(10, "DEBUG"),
    INFO(20, "INFO"),
    WARN(30, "WARN"),
    ERROR(40, "ERROR"),
    FATAL(50, "FATAL");

    private final int level;
    private final String title;

    LogLevel(int level, String title) {
        this.level = level;
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public String getTitle() {
        return title;
    }
}
