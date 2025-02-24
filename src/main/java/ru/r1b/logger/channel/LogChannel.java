package ru.r1b.logger.channel;

import ru.r1b.logger.Channel;
import ru.r1b.logger.config.ChanelConfig;

public abstract class LogChannel implements Channel {
    ChanelConfig config;

    public LogChannel(ChanelConfig config) {
        this.config = config;
    }
}
