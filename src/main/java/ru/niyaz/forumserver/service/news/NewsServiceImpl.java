package ru.niyaz.forumserver.service.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.niyaz.forumserver.dto.news.NewsResponseDTO;
import ru.niyaz.forumserver.entity.news.News;
import ru.niyaz.forumserver.factory.*;
import ru.niyaz.forumserver.model.news.NewsObject;
import ru.niyaz.forumserver.repository.news.NewsRepository;

import javax.enterprise.inject.New;
import java.time.Instant;
import java.util.List;

/**
 * Created by Нияз on 28.01.2017.
 */

@Service
public class NewsServiceImpl implements NewsService {

    private NewsFactory newsFactory;
    private NewsDTOFactory newsDTOFactory;
    private NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(AttachmentSaveService attachmentSaveService, NewsRepository newsRepository) {
        this.newsFactory = new NewsFactoryImpl(new AttachmentFactoryImpl(attachmentSaveService));
        this.newsDTOFactory = new NewsDTOFactoryImpl(new AttachmentDTOFactoryImpl());
        this.newsRepository = newsRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<NewsResponseDTO> get(Instant from, Instant to) throws Exception {
        List<News> newsList = newsRepository.getNews(from, to);
        return newsDTOFactory.get(newsList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveNews(List<NewsObject> newsObjects) throws Exception {
        List<News> newsList = newsFactory.get(newsObjects);
        newsRepository.saveNews(newsList);
    }
}
