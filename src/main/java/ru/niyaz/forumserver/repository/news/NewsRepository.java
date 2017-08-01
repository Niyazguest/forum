package ru.niyaz.forumserver.repository.news;

import ru.niyaz.forumserver.entity.news.News;

import java.time.Instant;
import java.util.List;

/**
 * Created by Нияз on 01.02.2017.
 */
public interface NewsRepository {
    void saveNews(List<News> news) throws Exception;
    List<News> getNews(Instant from, Instant to) throws Exception;
}
