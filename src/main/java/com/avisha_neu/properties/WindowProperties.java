package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesRepository;
import com.avisha_neu.utils.Property;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
@PropertiesRepository("/properties/window.properties")
public class WindowProperties {

    @Property("width")
    private static int width;

    @Property("height")
    private static int height;

    @Property("z.near")
    private static double zNear;

    @Property("z.far")
    private static double zFar;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static double getZFar() {
        return zFar;
    }

    public static double getZNear() {
        return zNear;
    }

}
