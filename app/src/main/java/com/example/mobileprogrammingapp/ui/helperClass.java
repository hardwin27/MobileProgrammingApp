package com.example.mobileprogrammingapp.ui;

public class helperClass {

    int image;
    String title, desc, url;

    public helperClass(int image, String title, String desc, String url) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

}

