package ru.niyaz.forumserver.factory;

import ru.niyaz.forumserver.dto.news.attachments.AttachmentDTO;
import ru.niyaz.forumserver.dto.news.attachments.LinkAttachmentDTO;
import ru.niyaz.forumserver.dto.news.attachments.PhotoAttachmentDTO;
import ru.niyaz.forumserver.dto.news.attachments.VideoAttachmentDTO;
import ru.niyaz.forumserver.entity.news.attachment.Attachment;
import ru.niyaz.forumserver.entity.news.attachment.LinkAttachment;
import ru.niyaz.forumserver.entity.news.attachment.PhotoAttachment;
import ru.niyaz.forumserver.entity.news.attachment.VideoAttachment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Нияз on 24.02.2017.
 */
public class AttachmentDTOFactoryImpl implements AttachmentDTOFactory {
    @Override
    public AttachmentDTO get(PhotoAttachment pa) {
        return new PhotoAttachmentDTO(pa.getPhoto75File(), pa.getPhoto130File(), pa.getPhoto604File(),
                pa.getPhoto807File(), pa.getWidthOriginal(), pa.getHeightOriginal());
    }

    @Override
    public AttachmentDTO get(VideoAttachment va) {
        return new VideoAttachmentDTO(va.getCoverPhotoURL(), va.getVideoURL(), va.getOwnerId(),
                va.getVideoId(), va.getTitle(), va.getAccessKey());
    }

    @Override
    public AttachmentDTO get(LinkAttachment la) {
        return new LinkAttachmentDTO(la.getUrl());
    }

    @Override
    public List<AttachmentDTO> get(List<Attachment> attachments) {
        if (attachments != null) {
            return attachments.stream()
                    .map(at -> {
                        if (at instanceof PhotoAttachment) {
                            return get((PhotoAttachment) at);
                        } else if (at instanceof VideoAttachment) {
                            return get((VideoAttachment) at);
                        } else if (at instanceof LinkAttachment) {
                            return get((LinkAttachment) at);
                        } else {
                            return null;
                        }
                    })
                    .filter(at -> at != null)
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
