package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesConfigurator;
import com.avisha_neu.utils.Property;

/**
 * Created by Tatyana.Kalnitskaya on 21.02.15.
 */

public class CameraProperties {
    public final static String propertyFile = "/properties/camera.properties";

    @Property("velocity")
    private static double velocity;

    @Property("rotate.velocity")
    private static double rotateVelocity;

    @Property("visual.angle")
    private static double viewAngle;

    public static double getVelocity() {
        return velocity;
    }

    public static double getRotateVelocity() {
        return rotateVelocity;
    }

    public static double getViewAngle() {
        return viewAngle;
    }

    public static void initProperties() {
        PropertiesConfigurator.fillClassStaticFields(propertyFile, CameraProperties.class);
    }
}
