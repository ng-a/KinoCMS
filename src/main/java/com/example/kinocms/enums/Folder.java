package com.example.kinocms.enums;

public enum Folder {
    IMAGE("image"),


    BANNERS("banners"),
    FILMS("films"),
    NEWS("news"),
    SHARES("shares");



    String folder;

    Folder(String folder) {
        this.folder = folder;
    }


    @Override
    public String toString() {
        return folder;
    }
}
