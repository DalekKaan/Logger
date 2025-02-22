package ru.r1b.logger;

import ru.r1b.logger.channel.StdOutChannel;
import ru.r1b.logger.config.LoggerConfig;
import ru.r1b.logger.formatter.LeveledLog;
import ru.r1b.logger.logger.ChainLogger;

public class ChainLoggerTest extends LoggerTest {
    @Override
    Logger getLogger() {

        return new ChainLogger(
                new StdOutChannel(new LoggerConfig()),
                1,
                new LeveledLog(1)
        );
    }
}
