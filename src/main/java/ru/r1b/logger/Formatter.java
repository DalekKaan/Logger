package ru.r1b.logger;

public interface Formatter {
    String format(String message);
    void setPrev(Formatter prev);
}
