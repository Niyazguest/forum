package ru.niyaz.forumserver.service.common;

import ru.niyaz.forumserver.model.news.NewsObject;

import java.time.Instant;
import java.util.List;

/**
 * Created by Нияз on 02.02.2017.
 */
public interface VkApiService {
     List<NewsObject> getNews(Instant from, Instant to) throws Exception;
}
