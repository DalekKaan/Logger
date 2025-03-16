package ru.r1b.logger.config.formatter;

public class LeveledFormatterConfig implements Config {
    FormatterConfig base;
    String level;

    public LeveledFormatterConfig(FormatterConfig base, String level) {
        this.base = base;
        this.level = level;
    }

    @Override
    public String getType() {
        return base.getType();
    }

    public String getLevel() {
        return level;
    }
}
