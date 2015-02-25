package com.avisha_neu.utils;

import com.avisha_neu.Main;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Tatyana.Kalnitskaya on 14.02.15.
 */

public class PropertiesConfigurator {
    private static final String PROPERTIES_PACKAGE = "com.avisha_neu.properties";

    public static void initAllApplicationProperties() {
        Reflections reflections = new Reflections(PROPERTIES_PACKAGE);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(PropertiesRepository.class);

        for (Class<?> properties : annotated) {
            PropertiesRepository propertiesAnnotation = properties.getAnnotation(PropertiesRepository.class);
            String filePath = propertiesAnnotation.value();
            fillClassStaticFields(filePath, properties);
        }
    }

    public static void fillClassStaticFields(String filePath, Class class_) {
        Properties prop = getPropertiesFromFile(filePath);
        bindPropertiesToFields(prop, class_);
    }

    private static Properties getPropertiesFromFile(String filePath) {
        try {
            InputStream inputStream = Main.class.getResourceAsStream(filePath);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void bindPropertiesToFields(Properties properties, Class class_) {
        for (Field field : class_.getDeclaredFields()) {
            if (field.isAnnotationPresent(Property.class)) {
                Property propertyAnnotation = field.getAnnotation(Property.class);
                String key = propertyAnnotation.value();
                String value = properties.getProperty(key);
                Class fieldType = field.getType();
                try {
                    field.setAccessible(true);
                    field.set(null, castValueToFieldType(fieldType, value));
                } catch (IllegalAccessException e) {
                    System.out.print(e);
                }
            }
        }
    }

    private static Object castValueToFieldType(Class fieldType, String value) {
        if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {
            return Double.valueOf(value);
        } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
            return Integer.valueOf(value);
        } else if (fieldType.equals(String.class)) {
            return value;
        } else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
            return Boolean.valueOf(value);
        } else {
            return null;
        }
    }
}
