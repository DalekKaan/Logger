package ru.r1b.logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

abstract class LoggerTest {

    ChannelMock channel = new ChannelMock();


    @AfterEach
    public void tearDown() {
        channel.reset();
    }

    @Test
    public void log() {
        getLogger().log("test", 1);
        assertEquals("[1] test", channel.getOut().toString());

    }

    abstract Logger getLogger();
}