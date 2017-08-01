package ru.niyaz.forumserver.entity.news.attachment;

import javax.persistence.*;

/**
 * Created by Нияз on 05.02.2017.
 */

@Entity
@Table(name = "link_attachment")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class LinkAttachment extends Attachment {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
