package org.wholesome.veronica.util;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mark.Lacdao on 07/08/2015.
 */
public class ResourceFileReaderTest {

    private static final String INPUT_STREAM_FILE = "users.properties";
    private static final String ADMINS_KEY = "admins";

    @Test
    public void shouldGetInputStream(){
        InputStream is = ResourceFileReader.getInputStream(INPUT_STREAM_FILE);
        assertTrue(is != null);
    }

    @Test
    public void shouldReadProperties() throws IOException {
        Properties properties = ResourceFileReader.getProperties(INPUT_STREAM_FILE);
        String value = properties.getProperty(ADMINS_KEY);
        assertNotNull(value);
    }

}
