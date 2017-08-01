package ru.niyaz.forumserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.niyaz.forumserver.dto.news.NewsRequestDTO;
import ru.niyaz.forumserver.dto.news.NewsResponseDTO;
import ru.niyaz.forumserver.service.news.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.List;

/**
 * Created by Нияз on 28.01.2017.
 */

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ResponseEntity<List<NewsResponseDTO>> loadNews(@RequestParam(value = "from") Long from,
                                                          @RequestParam(value = "to") Long to,
                                                          HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<NewsResponseDTO> newsResponseDTOList = newsService.get(Instant.ofEpochSecond(from), Instant.ofEpochSecond(to));
        return ResponseEntity.
                ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(newsResponseDTOList);
    }
}
