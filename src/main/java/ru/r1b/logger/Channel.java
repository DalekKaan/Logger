package ru.r1b.logger;

public interface Channel {
    public static final String STDOUT = "stdout";
    public static final String STDERR = "stderr";
    public static final String FILE = "file";
    public void write(String message);
}
