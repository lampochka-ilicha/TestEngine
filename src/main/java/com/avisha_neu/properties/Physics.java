package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesConfigurator;
import com.avisha_neu.utils.Property;

/**
 * Created by Tatyana.Kalnitskaya on 13.02.15.
 */
public class Physics {
    public final static String propertyFile = "/properties/physics.properties";

    /**
     * bdfgsdfdsf
     */
    @Property("g")
    public static int g;

    @Property("v")
    public static double v;

    @Property("name")
    public static String name;

    @Property("active")
    public static boolean active;


    public static void init() {
        PropertiesConfigurator.fillClassStaticFields(propertyFile, Physics.class);
    }
}
