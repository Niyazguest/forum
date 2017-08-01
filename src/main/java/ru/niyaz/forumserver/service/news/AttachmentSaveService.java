package ru.niyaz.forumserver.service.news;

import ru.niyaz.forumserver.enums.news.AttachmentType;

import java.io.File;

/**
 * Created by Нияз on 05.02.2017.
 */
public interface AttachmentSaveService {
    File save(String url, AttachmentType attachmentType);
}
