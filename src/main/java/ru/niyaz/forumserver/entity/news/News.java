package ru.niyaz.forumserver.entity.news;

import ru.niyaz.forumserver.entity.news.attachment.Attachment;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by Нияз on 01.02.2017.
 */

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(generator = "news_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "news_seq", sequenceName = "news_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "news_id")
    private Long newsId;

    private String title;
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "news", orphanRemoval = true)
    private List<Attachment> attachments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
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

    public Instant getDate() {
        return Instant.ofEpochMilli(date.getTime());
    }

    public void setDate(Instant date) {
        this.date = new Date(date.toEpochMilli());
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
