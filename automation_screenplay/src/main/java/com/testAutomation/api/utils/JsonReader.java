package com.testAutomation.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJson(String filePath, Class<T> clazz) {
        try {
            return objectMapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file: " + filePath, e);
        }
    }
}
