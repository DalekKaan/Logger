package ru.r1b.logger;

import java.util.LinkedList;

public interface Config {
    public String getLevel();
    public String getChannel();
    public LinkedList<String> getFormatters();
}
