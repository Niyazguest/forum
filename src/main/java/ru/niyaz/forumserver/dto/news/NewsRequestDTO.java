package ru.niyaz.forumserver.dto.news;

import java.io.Serializable;
import java.time.Instant;

/**
 * Created by Нияз on 28.01.2017.
 */
public class NewsRequestDTO implements Serializable {
    private Instant from;
    private Instant to;

    public NewsRequestDTO(Instant from, Instant to) {
        this.from = from;
        this.to = to;
    }

    public Instant getFrom() {
        return from;
    }

    public Instant getTo() {
        return to;
    }
}
