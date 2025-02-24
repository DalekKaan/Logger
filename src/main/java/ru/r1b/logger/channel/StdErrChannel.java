package ru.r1b.logger.channel;

import ru.r1b.logger.config.ChanelConfig;

public class StdErrChannel extends LogChannel {

    public StdErrChannel(ChanelConfig config) {
        super(config);
    }

    @Override
    public void write(String message) {
        System.err.println(message);
    }
}
