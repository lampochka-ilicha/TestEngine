package com.avisha_neu.math;

/**
 * Created by Tatyana.Kalnitskaya on 13.02.15.
 */
public class Vector {
    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getNorm() {
        return x*x + y*y + z*z;
    }

    public Vector getConjugated() {
        return new Vector (-x, -y, -z);
    }

    public Vector multiply(double multiplier) {
        return new Vector(x*multiplier,
                y*multiplier,
                z*multiplier);
    }

    public Vector multiply(Vector multiplier) {
        return new Vector(y*multiplier.z - z*multiplier.y,
                z*multiplier.x - x*multiplier.z,
                x*multiplier.y - y*multiplier.x);
    }

    public double multiplyScalar(Vector multiplier) {
        return x*multiplier.x +
                y*multiplier.y +
                z*multiplier.z;
    }

    public Vector add(Vector item) {
        return new Vector(x + item.x,
                y + item.y,
                z + item.z);
    }


}
