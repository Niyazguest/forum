package ru.niyaz.forumserver.dto.news;

import ru.niyaz.forumserver.dto.news.attachments.AttachmentDTO;

import java.io.Serializable;
import java.time.Instant;

/**
 * Created by Нияз on 28.01.2017.
 */
public class NewsResponseDTO implements Serializable {
    private String title;
    private String body;
    private Instant date;
    private AttachmentDTO[] attachments;

    public NewsResponseDTO(String title, String body, Instant date, AttachmentDTO[] attachments) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.attachments = attachments;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Instant getDate() {
        return date;
    }

    public AttachmentDTO[] getAttachments() {
        return attachments;
    }
}
