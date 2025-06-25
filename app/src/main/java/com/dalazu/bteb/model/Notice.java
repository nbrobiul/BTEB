package com.dalazu.bteb.model;

import java.io.Serializable;

public class Notice implements Serializable {

    private String title, description, date, pdfurl;

    public Notice(String title, String description, String date, String pdfurl) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.pdfurl = pdfurl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }
}
