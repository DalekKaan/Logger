package ru.r1b.logger;

public interface Logger {
    public static final int LEVEL_DEBUG = 10;
    public static final int LEVEL_INFO = 20;
    public static final int LEVEL_ERROR = 30;
    public void log(String message, int level);
}
