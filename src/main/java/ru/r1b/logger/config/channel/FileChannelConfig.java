package ru.r1b.logger.config.channel;

public final class FileChannelConfig implements Config {
    private final ChannelConfig base;
    private final String file;

    public FileChannelConfig(ChannelConfig base, String file) {
        this.base = base;
        this.file = file;
    }

    @Override
    public String getType() {
        return base.getType();
    }

    public String getFile() {
        return file;
    }

}
