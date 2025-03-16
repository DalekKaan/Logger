package ru.r1b.logger.config;

import java.util.ArrayList;

public record LoggerConfig(
        String level,
        ArrayList<ru.r1b.logger.config.channel.Config> channels,
        ArrayList<ru.r1b.logger.config.formatter.Config> formatters
) {
}
