package ru.r1b.logger.formatter;

import ru.r1b.logger.Formatter;

public abstract class FormattedLog implements Formatter {
    Formatter prev;

    public FormattedLog() {
    }

    public FormattedLog(Formatter prev) {
        this.prev = prev;
    }

    public void setPrev(Formatter prev) {
        this.prev = prev;
    }
}
