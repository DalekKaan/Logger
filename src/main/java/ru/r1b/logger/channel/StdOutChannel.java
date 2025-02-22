package ru.r1b.logger.channel;

import ru.r1b.logger.Channel;
import ru.r1b.logger.Config;
import ru.r1b.logger.Formatter;

public class StdOutChannel extends LogChannel {

    public StdOutChannel(Config config) {
        super(config);
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
