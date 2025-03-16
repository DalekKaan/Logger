package ru.r1b.logger.channel;

import ru.r1b.logger.config.channel.Config;

public class StdOutChannel extends LogChannel {

    public StdOutChannel(Config config) {
        super(config);
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
