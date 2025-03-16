package ru.r1b.logger.config.formatter;

public class DateTimeFormatterConfig implements Config {

    FormatterConfig base;
    String format;
    public DateTimeFormatterConfig(FormatterConfig base, String format) {
        this.base = base;
        this.format = format;
    }

    @Override
    public String getType() {
        return base.getType();
    }

    public String getFormat() {
        return format;
    }
}
