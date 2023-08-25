package com.example.springbootdemo.utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.DefaultResourceLoader;
public class JsonUtility {

    private static final String PATH_PREFIX = "classpath:";

    public static String getResourceAsString(String filePath) throws IOException {
        var resourceLoader = new DefaultResourceLoader();
        var resource = resourceLoader.getResource(PATH_PREFIX.concat(filePath));
        var inputStream = resource.getInputStream();
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    public static <T> T getResource(String filePath, Class<T> targetClass) throws IOException {
        var resourceAsString = getResourceAsString(filePath);
        var objectMapper = new ObjectMapper();
        return objectMapper.readValue(resourceAsString, targetClass);
    }
}
