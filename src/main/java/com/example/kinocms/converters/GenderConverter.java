package com.example.kinocms.converters;


import com.example.kinocms.enums.Gender;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;

public class GenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(@NotNull String gender) {
        try {
            return Gender.valueOf(gender.toUpperCase());
        } catch(Exception e) {
            return null;
        }
    }
}
