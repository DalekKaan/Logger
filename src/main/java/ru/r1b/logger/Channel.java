package ru.r1b.logger;

public interface Channel {
    String STDOUT = "stdout";
    String STDERR = "stderr";
    String FILE = "file";
    void write(String message);
}
