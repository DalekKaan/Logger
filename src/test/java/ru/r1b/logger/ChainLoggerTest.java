package ru.r1b.logger;

import ru.r1b.logger.formatter.LeveledLog;
import ru.r1b.logger.logger.ChainLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChainLoggerTest extends LoggerTest {

    @Override
    Logger getLogger() {

        ArrayList<Channel> channels = new ArrayList<>();
        channels.add(channelMock);

        ArrayList<Formatter> formatters = new ArrayList<>();
        formatters.add((Formatter) new LeveledLog(LogLevel.INFO));

        return new ChainLogger(
                channels,
                LogLevel.INFO,
                formatters
        );
    }
}
