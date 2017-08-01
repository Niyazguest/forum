package ru.niyaz.forumserver.model.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.List;

/**
 * Created by Нияз on 02.02.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsObject {
    private Long id;
    private Instant date;
    private String title = "Breakpoint KZN VK";
    private String text;
    private List<Attachment> attachments;

    public NewsObject() {
    }

    public NewsObject(Long id, Number date, String title, String text, List<Attachment> attachments) {
        this.id = id;
        this.date = Instant.ofEpochSecond(date.longValue());
        this.title = title;
        this.text = text;
        this.attachments = attachments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Number date) {
        this.date = Instant.ofEpochSecond(date.longValue());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
