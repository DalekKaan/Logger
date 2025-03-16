package ru.r1b.logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class LoggerTest {

    @Mock
    Channel channelMock;
    Logger logger;
    ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        logger = getLogger();
    }


    @Test
    public void log() {

        String message = "Test";

        logger.log(message, LogLevel.INFO);

        Mockito.verify(channelMock).write(argument.capture());

        assertEquals("[" + LogLevel.INFO.getTitle() + "] " + message, argument.getValue());

    }

    abstract Logger getLogger();
}