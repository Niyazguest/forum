package ru.niyaz.forumserver.dto.news.attachments;

/**
 * Created by Нияз on 24.02.2017.
 */
public class LinkAttachmentDTO extends AttachmentDTO {
    private String url;

    public LinkAttachmentDTO(String url) {
        super("link");
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
