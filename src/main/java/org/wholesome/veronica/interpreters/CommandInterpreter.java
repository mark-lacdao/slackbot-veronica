package org.wholesome.veronica.interpreters;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.wholesome.veronica.util.ResourceFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by mark.lacdao on 31/07/2015.
 */
public class CommandInterpreter extends ResourceFileReader implements Interpreter {

    private static final Logger LOG = Logger.getLogger(CommandInterpreter.class);

    private static final String USERS_FILE = "users.properties";

    @Override
    public String interpret(String message) {

        return null; // TODO
    }

    @Override
    public String interpret(String message, String sender) {
        return null; // TODO
    }

    @SuppressWarnings("deprecation")


    protected List<String> getAdmins(){
        List<String> admins = new ArrayList<String>();
        Properties properties = null;
        try {
            properties = ResourceFileReader.getProperties(USERS_FILE);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            e.printStackTrace();
        }
        if(null == properties) return admins;
        admins.addAll(parseAdmins(properties.getProperty("admins")));
        return admins;
    }

    private List<String> parseAdmins(String propertiesValue){
        List<String> cleanedAdmins = new ArrayList<String>();
        String[] uncleanedAdmins = StringUtils.split(propertiesValue); // LOL uncleaned haha
        for (String uncleanedAdmin : uncleanedAdmins) {
            cleanedAdmins.add(uncleanedAdmin.trim());
        }
        return  cleanedAdmins;
    }

}
