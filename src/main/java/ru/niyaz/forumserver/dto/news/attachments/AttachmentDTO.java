package ru.niyaz.forumserver.dto.news.attachments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.NoClass;

/**
 * Created by Нияз on 24.02.2017.
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = NoClass.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhotoAttachmentDTO.class, name = "photo"),
        @JsonSubTypes.Type(value = VideoAttachmentDTO.class, name = "video"),
        @JsonSubTypes.Type(value = LinkAttachmentDTO.class, name = "link")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AttachmentDTO {
    private String type;

    public AttachmentDTO(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
