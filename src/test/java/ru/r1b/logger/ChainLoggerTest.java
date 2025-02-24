package ru.r1b.logger;

import ru.r1b.logger.formatter.LeveledLog;
import ru.r1b.logger.logger.ChainLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChainLoggerTest extends LoggerTest {
    @Override
    Logger getLogger() {

        return new ChainLogger(
                (ArrayList<Channel>) Collections.singletonList(channelMock),
                LogLevel.INFO,
                (ArrayList<Formatter>) Collections.singletonList((Formatter) new LeveledLog(LogLevel.INFO))

        );
    }
}
