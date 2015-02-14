package com.avisha_neu.utils;

import com.avisha_neu.Main;
import com.avisha_neu.properties.Physics;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Tatyana.Kalniskaya on 14.02.15.
 */
public class PropertiesConfigurator {
    public static Properties getPropertiesFromFile(String filePath) {
        try {
            InputStream inputStream = Main.class.getResourceAsStream(filePath);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void bindPropertiesToFields(Properties properties, Class obj) {
        for(Field field  : obj.getDeclaredFields())
        {
            if (field.isAnnotationPresent(Property.class))
            {
                Property propertyAnnotation = field.getAnnotation(Property.class);
                String key = propertyAnnotation.value();
                String value = properties.getProperty(key);
                Class fieldType = field.getType();
                try {
                   if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {
                       field.set(null, Double.valueOf(value));
                   }
                   else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)){
                       field.set(null, Integer.valueOf(value));
                   }
                   else if (fieldType.equals(String.class)){
                       field.set(null, value);
                   }
                   else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)){
                       field.set(null, Boolean.valueOf(value));
                   }
                } catch (Exception e) {
                  System.out.print(e);
                }
            }
        }
    }
}
