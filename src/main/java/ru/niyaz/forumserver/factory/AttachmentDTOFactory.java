package ru.niyaz.forumserver.factory;

import ru.niyaz.forumserver.dto.news.attachments.AttachmentDTO;
import ru.niyaz.forumserver.entity.news.attachment.Attachment;
import ru.niyaz.forumserver.entity.news.attachment.LinkAttachment;
import ru.niyaz.forumserver.entity.news.attachment.PhotoAttachment;
import ru.niyaz.forumserver.entity.news.attachment.VideoAttachment;

import java.util.List;

/**
 * Created by Нияз on 24.02.2017.
 */
public interface AttachmentDTOFactory {
    AttachmentDTO get(PhotoAttachment pa);
    AttachmentDTO get(VideoAttachment va);
    AttachmentDTO get(LinkAttachment la);
    List<AttachmentDTO> get(List<Attachment> attachmentDTOS);
}
