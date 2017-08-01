package ru.niyaz.forumserver.entity.news.attachment;

import javax.persistence.*;

/**
 * Created by Нияз on 05.02.2017.
 */

@Entity
@Table(name = "photo_attachment")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class PhotoAttachment extends Attachment {

    @Column(name = "file_75")
    private String photo75File;

    @Column(name = "file_130")
    private String photo130File;

    @Column(name = "file_604")
    private String photo604File;

    @Column(name = "file_807")
    private String photo807File;

    @Column(name = "width_original")
    private Integer widthOriginal;

    @Column(name = "height_original")
    private Integer heightOriginal;

    public String getPhoto75File() {
        return photo75File;
    }

    public void setPhoto75File(String photo75File) {
        this.photo75File = photo75File;
    }

    public String getPhoto130File() {
        return photo130File;
    }

    public void setPhoto130File(String photo130File) {
        this.photo130File = photo130File;
    }

    public String getPhoto604File() {
        return photo604File;
    }

    public void setPhoto604File(String photo604File) {
        this.photo604File = photo604File;
    }

    public String getPhoto807File() {
        return photo807File;
    }

    public void setPhoto807File(String photo807File) {
        this.photo807File = photo807File;
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
