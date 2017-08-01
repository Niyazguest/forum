package ru.niyaz.forumserver.model.news;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Нияз on 04.02.2017.
 */

public class VideoAttachment implements Attachment {

    private String coverPhotoURL;
    private String videoURL;
    private String ownerId;
    private String videoId;
    private String title;
    private String accessKey;

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

    @JsonProperty("video")
    public void setVideo(Map<String, String> video) {
        this.coverPhotoURL = video.get("photo_320");
        this.videoURL = video.get("player");
        this.ownerId = video.get("owner_id");
        this.videoId = video.get("id");
        this.title = video.get("title");
        this.accessKey = video.get("access_key");
    }
}
