package ru.niyaz.forumserver.scheduler.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.niyaz.forumserver.model.news.NewsObject;
import ru.niyaz.forumserver.service.common.VkApiService;
import ru.niyaz.forumserver.service.news.NewsService;

import java.time.Instant;
import java.util.List;

/**
 * Created by Нияз on 01.02.2017.
 */

@Service
public class DownloadNewsTask {

    @Autowired
    private VkApiService vkApiService;

    @Autowired
    private NewsService newsService;

    @Scheduled(fixedDelay = 300000) // 300000
    public void downloadTask() {
        try {
            List<NewsObject> newsObjects = vkApiService.getNews(Instant.now(), Instant.now());
            newsService.saveNews(newsObjects);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
