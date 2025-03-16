package ru.r1b.logger.channel;

import ru.r1b.logger.config.chanel.ChanelConfig;
import ru.r1b.logger.config.chanel.Config;
import ru.r1b.logger.config.chanel.FileChanelConfig;
import ru.r1b.logger.exception.ConfigurationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileChannel extends LogChannel {
    Writer writer;

    public static FileChannel make(FileChanelConfig config) {
        File logFile = new File(config.getFile());
        try {
            logFile.createNewFile();
            return new FileChannel(config, new FileWriter(logFile)) ;
        } catch (IOException e) {
            throw new ConfigurationException("Could not create log file", e);
        }
    }

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
