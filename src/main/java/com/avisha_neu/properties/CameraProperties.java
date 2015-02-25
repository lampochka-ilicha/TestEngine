package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesRepository;
import com.avisha_neu.utils.Property;

/**
 * Created by Tatyana.Kalnitskaya on 21.02.15.
 */
@PropertiesRepository("/properties/camera.properties")
public class CameraProperties {

    @Property("velocity")
    private static double velocity;

    @Property("rotate.velocity")
    private static double rotationVelocity;

    @Property("visual.angle")
    private static double viewAngle;

    public static double getVelocity() {
        return velocity;
    }

    public static double getRotationVelocity() {
        return rotationVelocity;
    }

    public static double getViewAngle() {
        return viewAngle;
    }
}
