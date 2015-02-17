package com.avisha_neu.scene;

import com.avisha_neu.math.Vector;
import com.avisha_neu.properties.HumanProperties;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class Human {
    private Camera camera;
    private HumanProperties properties;

    public Human() {
        this.camera = new Camera();
        this.properties = new HumanProperties();
    }

    public void stepToTheLeft() {
        Vector leftTravel = new Vector(-properties.getVelocity(), 0, 0);
        camera.translate(leftTravel);
    }

    public void stepToTheRight() {
        Vector rightTravel = new Vector(properties.getVelocity(), 0, 0);
        camera.translate(rightTravel);
    }

    public void stepForward() {
        Vector forwardTravel = new Vector(0, 0, -properties.getVelocity());
        camera.translate(forwardTravel);
    }

    public void stepBack() {
        Vector backTravel = new Vector(0, 0, properties.getVelocity());
        camera.translate(backTravel);
    }

}
