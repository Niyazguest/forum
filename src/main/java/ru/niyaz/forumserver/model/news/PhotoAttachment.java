package ru.niyaz.forumserver.model.news;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


/**
 * Created by Нияз on 04.02.2017.
 */

public class PhotoAttachment implements Attachment {
    private String photo75URL;
    private String photo130URL;
    private String photo604URL;
    private String photo807URL;
    private Integer widthOriginal;
    private Integer heightOriginal;

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

    @JsonProperty("photo")
    public void setPhoto(Map<String, String> photo) {
        this.photo75URL = photo.get("photo_75");
        this.photo130URL = photo.get("photo_130");
        this.photo604URL = photo.get("photo_604");
        this.photo807URL = photo.get("photo_807");

        try {
            this.widthOriginal = Integer.parseInt(photo.get("width"));
            this.heightOriginal = Integer.parseInt(photo.get("height"));
        } catch (Exception ex) {
            this.widthOriginal = null;
            this.heightOriginal = null;
        }
    }
}
