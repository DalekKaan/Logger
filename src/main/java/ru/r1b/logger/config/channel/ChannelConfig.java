package ru.r1b.logger.config.channel;

public final class ChannelConfig implements Config {
    private final String type;

    public ChannelConfig(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
