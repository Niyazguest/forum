package ru.niyaz.forumserver.entity.news.attachment;

import javax.persistence.*;

/**
 * Created by Нияз on 05.02.2017.
 */

@Entity
@Table(name = "video_attachment")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class VideoAttachment extends Attachment {

    private String title;

    @Column(name = "cover_photo_url")
    private String coverPhotoURL;

    @Column(name = "video_url")
    private String videoURL;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "video_id")
    private String videoId;

    @Column(name = "access_key")
    private String accessKey;

    private Long size;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverPhotoURL() {
        return coverPhotoURL;
    }

    public void setCoverPhotoURL(String coverPhotoURL) {
        this.coverPhotoURL = coverPhotoURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
