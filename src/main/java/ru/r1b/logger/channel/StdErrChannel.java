package ru.r1b.logger.channel;

import ru.r1b.logger.Channel;
import ru.r1b.logger.Config;
import ru.r1b.logger.Formatter;

public class StdErrChannel extends LogChannel {

    public StdErrChannel(Config config) {
        super(config);
    }

    @Override
    public void write(String message) {
        System.err.println(message);
    }
}
