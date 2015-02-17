package com.avisha_neu.properties;

import com.avisha_neu.utils.PropertiesConfigurator;
import com.avisha_neu.utils.Property;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class WindowProperties {
    public final static String propertyFile = "/properties/window.properties";

    public WindowProperties() {
        initProperties();
    }

    @Property("width")
    private double width;

    @Property("height")
    private double height;

    @Property("z.near")
    private double zNear;

    @Property("z.far")
    private double zFar;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getZFar() {
        return zFar;
    }

    public double getZNear() {
        return zNear;
    }

    public void initProperties() {
        PropertiesConfigurator.fillClassStaticFields(propertyFile, WindowProperties.class);
    }
}
