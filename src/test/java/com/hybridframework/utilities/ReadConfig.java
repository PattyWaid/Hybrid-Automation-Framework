package com.hybridframework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig(){
        File src = new File(System.getProperty("user.dir") + "\\Configurations\\config.properties" );

        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getStackTrace());
        }
    }

    public String readProperties(String data){
        String value = properties.getProperty(data);
        return value;
    }
}
