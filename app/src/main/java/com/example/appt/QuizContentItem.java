package com.example.appt;

public class QuizContentItem {
    private String title;
    private String subtitle;
    private String keyword;
    private int imageResId;

    public QuizContentItem(String title, String subtitle, String keyword, int imageResId) {
        this.title = title;
        this.subtitle = subtitle;
        this.keyword = keyword;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getImageResId() {
        return imageResId;
    }
}
