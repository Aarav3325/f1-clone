package com.aarav.f1clone.domain.news;

public class NewsDataModel {
    String url, newsCoverImage, tagName, headlines;

    public NewsDataModel() {
    }

    public NewsDataModel(String url, String newsCoverImage, String tagName, String headlines) {
        this.url = url;
        this.newsCoverImage = newsCoverImage;
        this.tagName = tagName;
        this.headlines = headlines;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNewsCoverImage() {
        return newsCoverImage;
    }

    public void setNewsCoverImage(String newsCoverImage) {
        this.newsCoverImage = newsCoverImage;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getHeadlines() {
        return headlines;
    }

    public void setHeadlines(String headlines) {
        this.headlines = headlines;
    }
}
