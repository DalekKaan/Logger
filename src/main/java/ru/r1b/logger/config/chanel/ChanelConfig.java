package ru.r1b.logger.config.chanel;

public final class ChanelConfig implements Config {
    private final String type;

    public ChanelConfig(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
