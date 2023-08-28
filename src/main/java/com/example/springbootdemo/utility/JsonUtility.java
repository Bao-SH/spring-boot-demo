package com.example.springbootdemo.utility;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtility {
  private static final String PATH_PREFIX = "classpath:";

  public static String getResourceAsString(String filePath) throws IOException {
    var resourceLoader = new DefaultResourceLoader();
    var resource = resourceLoader.getResource(PATH_PREFIX.concat(filePath));
    var inputStream = resource.getInputStream();
    return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
  }

  public static <T> T getResource(final String filePath,
                                  final Class<T> targetClass)
      throws IOException {
    var resourceAsString = getResourceAsString(filePath);
    var objectMapper = new ObjectMapper();
    return objectMapper.readValue(resourceAsString, targetClass);
  }
}
