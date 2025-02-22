package ru.r1b.logger.channel;

import ru.r1b.logger.Channel;
import ru.r1b.logger.Config;

public abstract class LogChannel implements Channel {
    Config config;

    public LogChannel(Config config) {
        this.config = config;
    }
}
