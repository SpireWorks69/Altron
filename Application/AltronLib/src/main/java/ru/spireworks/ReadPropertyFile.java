package ru.spireworks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class ReadPropertyFile {
    private static final String FILE_NOT_FOUND_ERROR = "File not found!";

    public static String getProperty(final String filePath, String propertyName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();

        try(InputStream stream = loader.getResourceAsStream(filePath)) {
            if (stream != null) {
                properties.load(stream);
            } else {
                throw new IOException(FILE_NOT_FOUND_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(propertyName);
    }
}