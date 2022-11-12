package com.example.kinocms.enums;

public enum FilmType {
    D2("2d"),
    D3("3d"),
    IMAX("imax");

    private final String typeFilm;
    FilmType(String typeFilm) {
        this.typeFilm = typeFilm;
    }

    @Override
    public String toString() {
        return typeFilm;
    }
}
