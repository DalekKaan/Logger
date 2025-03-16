package ru.r1b.logger.config;

import ru.r1b.logger.config.channel.ChannelConfig;

import java.util.ArrayList;

public record LoggerConfig(
        String level,
        ArrayList<ChannelConfig> channels,
        ArrayList<FormatterConfig> formatters
) {
}
