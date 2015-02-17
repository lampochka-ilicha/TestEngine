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

    @Property("visual.angle")
    private double viewAngle;

    @Property("visual.distance")
    private double viewDistance;


    public double getVelocity() {
        return velocity;
    }

    public double getViewAngle() {
        return viewAngle;
    }

    public double getViewDistance() {
        return viewDistance;
    }

    public void initProperties() {
        PropertiesConfigurator.fillClassStaticFields(propertyFile, HumanProperties.class);
    }
}
