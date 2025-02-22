package ru.r1b.logger;

public class ChannelMock implements Channel {
    StringBuilder out = new StringBuilder();
    @Override
    public void write(String message) {
        out.append(message);
    }

    public StringBuilder getOut() {return out;}
    public void reset() {
        out = new StringBuilder();
    }
}
