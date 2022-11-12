package com.example.kinocms.converters;

import com.example.kinocms.enums.FilmType;
import com.example.kinocms.enums.Gender;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;

public class FilmTypeConverter implements Converter<String, FilmType> {
    @Override
    public FilmType convert(@NotNull String filmType) {
        try {
            return FilmType.valueOf(filmType.toUpperCase());
        } catch(Exception e) {
            return null;
        }
    }
}
