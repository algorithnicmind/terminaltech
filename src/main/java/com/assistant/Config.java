package com.assistant;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for loading and saving configuration settings.
 * Demonstrates Properties API and file I/O.
 */
public class Config {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties = new Properties();

    static {
        loadConfig();
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
        saveConfig();
    }

    private static void loadConfig() {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            // Default values if file doesn't exist
            properties.setProperty("history.size", "10");
            properties.setProperty("time.format", "HH:mm:ss");
            properties.setProperty("date.format", "yyyy-MM-dd");
        }
    }

    private static void saveConfig() {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            properties.store(fos, "Assistant Configuration");
        } catch (IOException e) {
            Logger.log("Failed to save config: " + e.getMessage());
        }
    }
}
