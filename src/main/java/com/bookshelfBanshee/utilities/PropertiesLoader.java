package com.bookshelfBanshee.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * This interface contains a default method that can be used anywhere a Properties
 * object is needed to be loaded.
 * @author Eric Knapp
 *
 */
public interface PropertiesLoader{

    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance if
     * the file path was not found.
     */
    default Properties loadProperties(String propertiesFilePath){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            PropertyLogger.logger.error(ioException);
        } catch (Exception exception) {
            PropertyLogger.logger.error(exception);
        }
        return properties;
    }
}

final class PropertyLogger {
    static final Logger logger = LogManager.getLogger(PropertiesLoader.class);
}