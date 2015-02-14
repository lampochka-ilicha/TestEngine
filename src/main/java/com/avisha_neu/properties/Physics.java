package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesConfigurator;
import com.avisha_neu.utils.Property;
import com.sun.xml.internal.ws.api.PropertySet;

import java.util.Properties;

/**
 * Created by Tatyana.Kalniskaya on 13.02.15.
 */
public class Physics {
    public final static String file = "/properties/physics.properties";

    @Property("g")
    public static int g;

    @Property("v")
    public static double v;

    @Property("name")
    public static String name;

    @Property("active")
    public static boolean active;


    public static void init() {
        Properties prop = PropertiesConfigurator.getPropertiesFromFile(Physics.file);
        PropertiesConfigurator.bindPropertiesToFields(prop, Physics.class);
    }

}
