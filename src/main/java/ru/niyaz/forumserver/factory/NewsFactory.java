package ru.niyaz.forumserver.factory;

import ru.niyaz.forumserver.entity.news.News;
import ru.niyaz.forumserver.model.news.NewsObject;

import java.util.List;

/**
 * Created by Нияз on 04.02.2017.
 */
public interface NewsFactory {
    News get(NewsObject newsObject);
    List<News> get(List<NewsObject> newsObjects);
}
