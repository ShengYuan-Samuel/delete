package com.ninstarscf.delete;

/**
 * @author Samuel
 * @time 2018/9/28 13:26
 * @describe
 */
public class QQPointBean {
    private int photo;
    private String name;
    private String context;
    private String time;
    private int number;

    public QQPointBean(int photo, String name, String context, String time, int number) {
        this.photo = photo;
        this.name = name;
        this.context = context;
        this.time = time;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public QQPointBean(int photo, String name, String context, String time) {
        this.photo = photo;
        this.name = name;
        this.context = context;
        this.time = time;
    }

    public int getPhoto () {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
