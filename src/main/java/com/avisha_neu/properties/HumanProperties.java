package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesConfigurator;
import com.avisha_neu.utils.Property;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class HumanProperties {
    public final static String propertyFile = "/properties/human.properties";

    public HumanProperties() {
        initProperties();
    }

    @Property("velocity")
    private double velocity;

    public double getVelocity() {
        return velocity;
    }

    public void initProperties() {
        PropertiesConfigurator.fillClassStaticFields(propertyFile, HumanProperties.class);
    }
}
