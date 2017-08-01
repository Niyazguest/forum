package ru.niyaz.forumserver.dto.news.attachments;

/**
 * Created by Нияз on 24.02.2017.
 */
public class VideoAttachmentDTO extends AttachmentDTO {
    private String coverPhotoURL;
    private String videoURL;
    private String ownerId;
    private String videoId;
    private String title;
    private String accessKey;

    public VideoAttachmentDTO(String coverPhotoURL, String videoURL, String ownerId, String videoId, String title, String accessKey) {
        super("video");
        this.coverPhotoURL = coverPhotoURL;
        this.videoURL = videoURL;
        this.ownerId = ownerId;
        this.videoId = videoId;
        this.title = title;
        this.accessKey = accessKey;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
