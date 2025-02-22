package ru.r1b.logger;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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


    @Test
    public void log() {
        String message = "test";
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        getLogger().log(message, Logger.LEVEL_INFO);

        Mockito.verify(channelMock).write(argument.capture());
        assertEquals("[" + Logger.LEVEL_INFO + "] " + message, argument.getValue());

    }

    abstract Logger getLogger();
}