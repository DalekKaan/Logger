package ru.r1b.logger.config.formatter;

public final class FormatterConfig implements Config {
    private final String type;

    public FormatterConfig(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

}
