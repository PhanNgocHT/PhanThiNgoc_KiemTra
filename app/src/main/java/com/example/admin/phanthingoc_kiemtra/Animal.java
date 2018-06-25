package com.example.admin.phanthingoc_kiemtra;

/**
 * Created by admin on 6/29/2017.
 */

public class Animal {
    private int idImage;
    private String text;
    private String txtText;
    public Animal(int idImage, String text, String txtText) {
        this.idImage = idImage;
        this.text = text;
        this.txtText=txtText;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getText() {
        return text;
    }

    public String getTxtText() {
        return txtText;
    }
}
