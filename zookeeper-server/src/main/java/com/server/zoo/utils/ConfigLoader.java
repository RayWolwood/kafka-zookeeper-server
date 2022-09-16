package com.server.zoo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigLoader {
    public static Properties getConfig(String filename) throws ConfigurationException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();

        try (InputStream resourceStream = loader.getResourceAsStream(filename)) {
            properties.load(resourceStream);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ConfigurationException(ex.getMessage());
        }
        return properties;
    }
}
