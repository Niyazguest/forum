package ru.niyaz.forumserver.service.news;

import ru.niyaz.forumserver.dto.news.NewsResponseDTO;
import ru.niyaz.forumserver.model.news.NewsObject;

import java.time.Instant;
import java.util.List;

/**
 * Created by Нияз on 28.01.2017.
 */
public interface NewsService {
    List<NewsResponseDTO> get(Instant from, Instant to) throws Exception;
    void saveNews(List<NewsObject> newsObjects) throws Exception ;
}
