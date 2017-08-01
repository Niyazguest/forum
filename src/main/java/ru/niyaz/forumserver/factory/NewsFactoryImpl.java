package ru.niyaz.forumserver.factory;

import ru.niyaz.forumserver.entity.news.attachment.Attachment;
import ru.niyaz.forumserver.entity.news.News;
import ru.niyaz.forumserver.model.news.NewsObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Нияз on 04.02.2017.
 */
public class NewsFactoryImpl implements NewsFactory {

    private AttachmentFactory attachmentFactory;

    public NewsFactoryImpl(AttachmentFactory attachmentFactory) {
        this.attachmentFactory = attachmentFactory;
    }

    @Override
    public News get(NewsObject newsObject) {
        News news = new News();
        news.setNewsId(newsObject.getId());
        news.setDate(newsObject.getDate());
        news.setTitle(newsObject.getTitle());
        news.setText(newsObject.getText());

        List<Attachment> attachments = attachmentFactory.get(newsObject.getAttachments());
        news.setAttachments(attachments);
        return news;
    }

    @Override
    public List<News> get(List<NewsObject> newsObjects) {
        return newsObjects.stream()
                .map(newsObject -> get(newsObject))
                .collect(Collectors.toList());
    }
}
