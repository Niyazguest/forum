package ru.niyaz.forumserver.entity.news.attachment;

import ru.niyaz.forumserver.entity.news.News;
import ru.niyaz.forumserver.enums.news.AttachmentType;

import javax.persistence.*;

/**
 * Created by Нияз on 04.02.2017.
 */

@Entity
@Table(name = "attachment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Attachment {

    @Id
    @GeneratedValue(generator = "attachment_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "attachment_seq", sequenceName = "attachment_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
