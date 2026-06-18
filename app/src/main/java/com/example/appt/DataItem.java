package com.example.appt;

public class DataItem {
    private String title;
    private String subtitle;
    private String keyword;

    public DataItem(String title, String subtitle, String keyword) {
        this.title = title;
        this.subtitle = subtitle;
        this.keyword = keyword;
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
}
