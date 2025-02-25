package ru.r1b.logger;

import ru.r1b.logger.formatter.LeveledLog;
import ru.r1b.logger.logger.ChainLogger;

public class ChainLoggerTest extends LoggerTest {
    @Override
    Logger getLogger() {

        return new ChainLogger(
                channelMock,
                LogLevel.INFO,
                new LeveledLog(LogLevel.INFO)
        );
    }
}
