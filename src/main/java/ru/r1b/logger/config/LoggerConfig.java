package ru.r1b.logger.config;

import ru.r1b.logger.Config;

import java.util.LinkedList;

public class LoggerConfig implements Config {
    String channel;
    String level;
    LinkedList<String> formatters;

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public String getChannel() {
        return channel;
    }

    @Override
    public LinkedList<String> getFormatters() {
        return formatters;
    }
}
