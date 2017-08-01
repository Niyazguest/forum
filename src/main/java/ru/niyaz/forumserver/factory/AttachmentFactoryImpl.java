package ru.niyaz.forumserver.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.niyaz.forumserver.entity.news.attachment.Attachment;
import ru.niyaz.forumserver.entity.news.attachment.LinkAttachment;
import ru.niyaz.forumserver.entity.news.attachment.PhotoAttachment;
import ru.niyaz.forumserver.entity.news.attachment.VideoAttachment;
import ru.niyaz.forumserver.enums.news.AttachmentType;
import ru.niyaz.forumserver.service.news.AttachmentSaveService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Нияз on 04.02.2017.
 */

public class AttachmentFactoryImpl implements AttachmentFactory {

    private AttachmentSaveService attachmentSaveService;

    public AttachmentFactoryImpl(AttachmentSaveService attachmentSaveService) {
        this.attachmentSaveService = attachmentSaveService;
    }

    @Override
    public Attachment get(ru.niyaz.forumserver.model.news.PhotoAttachment at) {
        PhotoAttachment attachment = new PhotoAttachment();
        attachment.setWidthOriginal(at.getWidthOriginal());
        attachment.setHeightOriginal(at.getHeightOriginal());
        File photo75 = attachmentSaveService.save(at.getPhoto75URL(), AttachmentType.PHOTO);
        File photo130 = attachmentSaveService.save(at.getPhoto130URL(), AttachmentType.PHOTO);
        File photo604 = attachmentSaveService.save(at.getPhoto604URL(), AttachmentType.PHOTO);
        File photo807 = attachmentSaveService.save(at.getPhoto807URL(), AttachmentType.PHOTO);
        attachment.setPhoto75File(photo75 != null ? photo75.getName() : null);
        attachment.setPhoto130File(photo130 != null ? photo130.getName() : null);
        attachment.setPhoto604File(photo604 != null ? photo604.getName() : null);
        attachment.setPhoto807File(photo807 != null ? photo807.getName() : null);
        return attachment;
    }

    @Override
    public Attachment get(ru.niyaz.forumserver.model.news.VideoAttachment at) {
        VideoAttachment attachment = new VideoAttachment();
        attachment.setTitle(at.getTitle());
        attachment.setCoverPhotoURL(at.getCoverPhotoURL());
        attachment.setVideoURL(at.getVideoURL());
        attachment.setOwnerId(at.getOwnerId());
        attachment.setVideoId(at.getVideoId());
        attachment.setAccessKey(at.getAccessKey());
        return attachment;
    }

    @Override
    public Attachment get(ru.niyaz.forumserver.model.news.LinkAttachment at) {
        LinkAttachment linkAttachment = new LinkAttachment();
        linkAttachment.setUrl(at.getUrl());
        return linkAttachment;
    }


    @Override
    public List<Attachment> get(List<ru.niyaz.forumserver.model.news.Attachment> attachments) {
        if (attachments != null) {
            return attachments.stream()
                    .map(at -> {
                        if (at instanceof ru.niyaz.forumserver.model.news.PhotoAttachment) {
                            return get((ru.niyaz.forumserver.model.news.PhotoAttachment) at);
                        } else if (at instanceof ru.niyaz.forumserver.model.news.VideoAttachment) {
                            return get((ru.niyaz.forumserver.model.news.VideoAttachment) at);
                        } else if (at instanceof ru.niyaz.forumserver.model.news.LinkAttachment) {
                            return get((ru.niyaz.forumserver.model.news.LinkAttachment) at);
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
