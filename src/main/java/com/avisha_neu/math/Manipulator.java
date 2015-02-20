package com.avisha_neu.math;

public class Manipulator {

    public static Vector rotateVector(Vector axis, double angle, Vector vector){
        Quaternion q = new Quaternion(axis, angle, true);
        Quaternion q1 = q.getInverse();
        return q.multiply(Quaternion.fromVector(vector)).multiply(q1).toVector();



    }
}
