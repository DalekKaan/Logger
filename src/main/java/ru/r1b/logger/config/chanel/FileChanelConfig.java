package ru.r1b.logger.config.chanel;

public final class FileChanelConfig implements Config {
    private final ChanelConfig base;
    private final String file;

    public FileChanelConfig(ChanelConfig base, String file) {
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
