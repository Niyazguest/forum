package ru.niyaz.forumserver.factory;

import ru.niyaz.forumserver.dto.news.NewsResponseDTO;
import ru.niyaz.forumserver.entity.news.News;

import java.util.List;

/**
 * Created by Нияз on 24.02.2017.
 */
public interface NewsDTOFactory {
    NewsResponseDTO get(News news);
    List<NewsResponseDTO> get(List<News> news);
}
