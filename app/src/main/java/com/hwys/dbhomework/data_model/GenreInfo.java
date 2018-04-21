package com.hwys.dbhomework.data_model;

public class GenreInfo {
    private  int id;
    private String genre;

    public GenreInfo() {
    }

    public GenreInfo(String genre) {
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
