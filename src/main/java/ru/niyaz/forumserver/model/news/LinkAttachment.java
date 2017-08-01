package ru.niyaz.forumserver.model.news;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Нияз on 04.02.2017.
 */

public class LinkAttachment implements Attachment {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("link")
    public void setLink(Map<String, Object> link) {
        this.url = link.get("url").toString();
    }
}
