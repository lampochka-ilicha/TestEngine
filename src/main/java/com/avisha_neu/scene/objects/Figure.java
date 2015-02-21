package com.avisha_neu.scene.objects;

import com.avisha_neu.math.Matrix;
import com.avisha_neu.math.Vector;

/**
 * Created by Tatyana.Kalnitskaya on 16.02.15.
 */

public class Figure {
    private Vector center;
    private Matrix points;

    public Figure(Vector center) {
        this.center = center;
    }

    public Matrix getPoints() {
        return points;
    }
}
