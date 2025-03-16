package ru.r1b.logger.config;

import ru.r1b.logger.config.chanel.ChanelConfig;

import java.util.ArrayList;

public record LoggerConfig(
        String level,
        ArrayList<ChanelConfig> channels,
        ArrayList<FormatterConfig> formatters
) {
}
