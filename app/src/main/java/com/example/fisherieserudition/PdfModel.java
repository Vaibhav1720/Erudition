package com.example.fisherieserudition;


import android.net.Uri;

public class PdfModel {

     private String text;
     private int image;


    public PdfModel(int image, String text) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
