package com.avisha_neu.physics;

import com.avisha_neu.math.Quaternion;
import com.avisha_neu.math.Vector;

/**
 * Created by Tatyana.Kalnitskaya on 16.02.15.
 */

public class Position {

    private Quaternion rotation;
    private Vector translation;

    public Quaternion getRotation() {
        return rotation;
    }

    public void setRotation(Quaternion rotation) {
        this.rotation = rotation;
    }

    public Vector getTranslation() {
        return translation;
    }

    public void setTranslation(Vector translation) {
        this.translation = translation;
    }
}
