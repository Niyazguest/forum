package ru.niyaz.forumserver.factory;

import ru.niyaz.forumserver.entity.news.attachment.Attachment;
import ru.niyaz.forumserver.model.news.LinkAttachment;
import ru.niyaz.forumserver.model.news.PhotoAttachment;
import ru.niyaz.forumserver.model.news.VideoAttachment;

import java.util.List;

/**
 * Created by Нияз on 04.02.2017.
 */
public interface AttachmentFactory {
     Attachment get(PhotoAttachment attachment);
     Attachment get(VideoAttachment attachment);
     Attachment get(LinkAttachment attachment);
     List<Attachment> get(List<ru.niyaz.forumserver.model.news.Attachment> attachments);
}
