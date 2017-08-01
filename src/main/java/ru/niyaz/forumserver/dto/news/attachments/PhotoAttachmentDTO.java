package ru.niyaz.forumserver.dto.news.attachments;

/**
 * Created by Нияз on 24.02.2017.
 */
public class PhotoAttachmentDTO extends AttachmentDTO {
    private String photo75URL;
    private String photo130URL;
    private String photo604URL;
    private String photo807URL;
    private Integer widthOriginal;
    private Integer heightOriginal;

    public PhotoAttachmentDTO(String photo75URL, String photo130URL, String photo604URL, String photo807URL, Integer widthOriginal, Integer heightOriginal) {
        super("photo");
        this.photo75URL = photo75URL;
        this.photo130URL = photo130URL;
        this.photo604URL = photo604URL;
        this.photo807URL = photo807URL;
        this.widthOriginal = widthOriginal;
        this.heightOriginal = heightOriginal;
    }

    public String getPhoto75URL() {
        return photo75URL;
    }

    public void setPhoto75URL(String photo75URL) {
        this.photo75URL = photo75URL;
    }

    public String getPhoto130URL() {
        return photo130URL;
    }

    public void setPhoto130URL(String photo130URL) {
        this.photo130URL = photo130URL;
    }

    public String getPhoto604URL() {
        return photo604URL;
    }

    public void setPhoto604URL(String photo604URL) {
        this.photo604URL = photo604URL;
    }

    public String getPhoto807URL() {
        return photo807URL;
    }

    public void setPhoto807URL(String photo807URL) {
        this.photo807URL = photo807URL;
    }

    public Integer getWidthOriginal() {
        return widthOriginal;
    }

    public void setWidthOriginal(Integer widthOriginal) {
        this.widthOriginal = widthOriginal;
    }

    public Integer getHeightOriginal() {
        return heightOriginal;
    }

    public void setHeightOriginal(Integer heightOriginal) {
        this.heightOriginal = heightOriginal;
    }
}
