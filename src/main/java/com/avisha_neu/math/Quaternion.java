package com.avisha_neu.math;

/**
 * Created by Tatyana.Kalnitskaya on 11.02.15.
 */
public class Quaternion {
    private double phi;
    private Vector v;

    public Quaternion(double x, double y, double z, double phi) {
        this.v.setX(x);
        this.v.setY(y);
        this.v.setZ(z);
        this.phi = phi;
    }

    public Quaternion(Vector v, double phi) {
        this.v = v;
        this.phi = phi;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public Vector getV() {
        return v;
    }

    public void setV(Vector v) {
        this.v = v;
    }


    public double getX() {
        return v.getX();
    }

    public void setX(double x) {
        this.v.setX(x);
    }


    public double getY() {
        return v.getY();
    }

    public void setY(double y) {
        this.v.setY(y);
    }

    public double getZ() {
        return v.getZ();
    }

    public void setZ(double z) {
        this.v.setZ(z);
    }

    public Vector toVector() {
        return v;
    }

    public static Quaternion fromVector (Vector v) {
        return new Quaternion(v, 0);
    }

    public Quaternion multiply(double multiplier) {
        return new Quaternion(v.multiply(multiplier),
                phi*multiplier);
    }

    public Quaternion multiply(Quaternion multiplier) {
        return new Quaternion(
                v.multiply(multiplier.v)
                        .add(multiplier.v.multiply(phi)
                                .add(v.multiply(multiplier.phi))),
                phi*multiplier.phi - v.multiplyScalar(multiplier.v));
    }

    public double getNorm(){
        return v.getNorm() + phi*phi;
    }

    public  Quaternion getConjugated() {
        return new Quaternion(v.getConjugated(), phi);
    }

    public  Quaternion getInverse() {
        return getConjugated().multiply(1.0/getNorm());
    }


}
