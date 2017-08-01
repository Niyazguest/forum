package ru.niyaz.forumserver.model.news;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.NoClass;

/**
 * Created by Нияз on 04.02.2017.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = NoClass.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhotoAttachment.class, name = "photo"),
        @JsonSubTypes.Type(value = VideoAttachment.class, name = "video"),
        @JsonSubTypes.Type(value = LinkAttachment.class, name = "link")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Attachment {
}
