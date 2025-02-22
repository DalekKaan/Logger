package ru.r1b.logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
abstract class LoggerTest {

    @Mock
    Channel channelMock;
    Logger logger;
    ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

    @Before
    public void setUp() {
        logger = getLogger();
    }


    @Test
    public void log() {

        String message = "Test";

        logger.log(message, Logger.LEVEL_INFO);

        Mockito.verify(channelMock).write(argument.capture());

        assertEquals("[" + Logger.LEVEL_INFO + "] " + message, argument.getValue());

    }

    abstract Logger getLogger();
}