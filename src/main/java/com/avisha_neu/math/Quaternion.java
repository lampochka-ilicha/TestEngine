package com.avisha_neu.math;

/**
 * Created by Tatyana.Kalnitskaya on 11.02.15.
 */
public class Quaternion {
    private double phi;
    private Vector v;

    private Quaternion(Vector v, double phi) {
        this.v = v;
        this.phi = phi;
    }

    public static Quaternion create(Vector v, double phi) {
        return new Quaternion(v, phi).normalize();
    }

    public static Quaternion rawCreate(Vector v, double phi){
        v = v.multiply(Math.sin(phi/2.0));
        phi = Math.cos(phi/2.0);
        return new Quaternion(v, phi).normalize();
    }

    public static Quaternion fromVector (Vector v) {
        return new Quaternion(v, 0);
    }

    public Quaternion normalize() {
        double modulus = Math.sqrt(getNorm());
        v = v.multiply(1.0/modulus);
        phi = phi*(1.0/modulus);
        return this;
    }


    public Vector toVector() {
        return v;
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
