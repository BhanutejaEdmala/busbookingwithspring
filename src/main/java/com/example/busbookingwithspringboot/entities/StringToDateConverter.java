package com.example.busbookingwithspringboot.entities;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            // Handle parse exception, return null, or throw an exception as needed.
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd");
        }
    }
}
