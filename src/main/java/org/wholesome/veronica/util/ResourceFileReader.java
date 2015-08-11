package org.wholesome.veronica.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mark.Lacdao on 07/08/2015.
 */
public class ResourceFileReader {

    public ResourceFileReader() {
    }

    protected static String getFileContents(String filename) throws IOException {
        InputStream is = getInputStream(filename);
        return IOUtils.toString(is);
    }

    protected static InputStream getInputStream(String filename){
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
    }

    protected static Properties getProperties(String filename) throws IOException {
        InputStream inputStream = getInputStream(filename);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }
}
