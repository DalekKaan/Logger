package ru.r1b.logger;

public interface Formatter {
    public String format(String message);
    public void setPrev(Formatter prev);
}
