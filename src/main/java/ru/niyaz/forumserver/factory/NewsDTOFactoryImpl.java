package ru.niyaz.forumserver.factory;

import ru.niyaz.forumserver.dto.news.NewsResponseDTO;
import ru.niyaz.forumserver.dto.news.attachments.AttachmentDTO;
import ru.niyaz.forumserver.entity.news.News;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Нияз on 24.02.2017.
 */
public class NewsDTOFactoryImpl implements NewsDTOFactory {

    private AttachmentDTOFactory attachmentDTOFactory;

    public NewsDTOFactoryImpl(AttachmentDTOFactory attachmentDTOFactory) {
        this.attachmentDTOFactory = attachmentDTOFactory;
    }

    @Override
    public NewsResponseDTO get(News news) {
        List<AttachmentDTO> attachmentDTOS = attachmentDTOFactory.get(news.getAttachments());
        NewsResponseDTO newsResponseDTO = new NewsResponseDTO(news.getTitle(), news.getText(),
                news.getDate(), attachmentDTOS.toArray(new AttachmentDTO[0]));
        return newsResponseDTO;
    }

    @Override
    public List<NewsResponseDTO> get(List<News> news) {
        return news.stream()
                .map(n -> get(n))
                .collect(Collectors.toList());
    }
}
