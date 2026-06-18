package com.example.appt;

public class ContentItem {
    private int imageResId;
    private String title;
    private String description;
    private String keyword;

    public ContentItem(int imageResId, String title, String description, String keyword) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.keyword = keyword;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getKeyword() {
        return keyword;
    }
}
