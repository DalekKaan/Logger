package ru.r1b.logger.channel;

import ru.r1b.logger.Channel;
import ru.r1b.logger.Config;
import ru.r1b.logger.Formatter;

import java.io.IOException;
import java.io.Writer;

public class FileChannel extends LogChannel {
    Writer writer;

    public FileChannel(Config config, Writer writer) {
        super(config);
        this.writer = writer;
    }

    @Override
    public void write(String message) {
        try {
            writer.write(message);
        } catch (IOException ignored) {

        }
    }
}
