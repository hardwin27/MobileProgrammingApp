package com.example.mobileprogrammingapp.Object;

import java.util.ArrayList;

public class CourseObj {

    public String title;
    public String desc;
    public String url;

    public CourseObj(String title, String desc, String url) {
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static ArrayList<CourseObj> getAll() {
        ArrayList<CourseObj> result = new ArrayList<>();
        result.add(new CourseObj("Bilangan Cacah", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum", "AgwMO4W4EtI"));
        result.add(new CourseObj("Penjumlahan dan Pengurangan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum", "SZccx2b2Cs0"));
        result.add(new CourseObj("Pola Bilangan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum", "J5S80ulhGrk"));
        result.add(new CourseObj("Bangun Ruang dan Bangun Datar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum", "TPy8zfIVZ5w"));
        result.add(new CourseObj("Panjang dan Waktu", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum", "qKQ9Gi3ckcU"));
        return result;
    }
}
