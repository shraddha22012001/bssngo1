package com.example.badlavsevasamitingo.Module;

public class Products {
    private String pname,description,date,image,pid,time;
    public Products() {

    }
    public Products(String pname, String description, String date, String image, String pid, String time) {
        this.pname = pname;
        this.description = description;

        this.date = date;
        this.image = image;
        this.pid = pid;
        this.time = time;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
