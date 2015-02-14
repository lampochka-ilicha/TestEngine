package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesConfigurator;
import com.avisha_neu.utils.Property;

/**
 * Created by Tatyana.Kalniskaya on 13.02.15.
 */
public class Physics {
    public final static String propertyFile = "/properties/physics.properties";

    @Property("g")
    public static int g;

    @Property("v")
    public static double v;

    @Property("name")
    public static String name;

    @Property("active")
    public static boolean active;


    public static void init() {
        PropertiesConfigurator.fillClassFields(propertyFile, Physics.class);
    }

}
