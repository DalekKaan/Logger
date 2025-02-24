package ru.r1b.logger.channel;

import ru.r1b.logger.config.ChanelConfig;

public class StdOutChannel extends LogChannel {

    public StdOutChannel(ChanelConfig config) {
        super(config);
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
