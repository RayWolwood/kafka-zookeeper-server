package com.server.kafka.utils;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class ConfigLoader {
    public static Properties getConfig(String filename) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();

        try (InputStream resourceStream = loader.getResourceAsStream(filename)) {
            properties.load(resourceStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
