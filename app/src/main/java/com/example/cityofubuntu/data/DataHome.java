package com.example.cityofubuntu.data;

public class DataHome {

    String nomrayon;
    String nameImageRayon;
    String imageArticle;
    int idrayon;

    public DataHome( int idrayon, String nomrayon, String nameImageRayon) {
        this.nomrayon = nomrayon;
        this.nameImageRayon = nameImageRayon;
        this.idrayon = idrayon;
    }

    public String getNomrayon() {
        return nomrayon;
    }

    public  String getImageArticle() {
        return imageArticle;
    }

    public  String getLibelerArticle() {
        return nomrayon;
    }

    public String getNameImageUSer() {
        return nameImageRayon;
    }

    public int getIdrayon() {
        return idrayon;
    }
}
