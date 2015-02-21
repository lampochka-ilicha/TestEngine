package com.avisha_neu.math;

public class Manipulator {

    /**
     * Returns new Vector
     *
     * @param axis   rotation axis.
     * @param angle  rotation angle, in radians.
     * @param vector a Vector to be rotated.
     * @return rotated Vector.
     */
    public static Vector rotateVector(Vector axis, double angle, Vector vector) {
        Quaternion q = Quaternion.rawCreate(axis, angle);
        Quaternion q1 = q.getInverse();
        Quaternion mutating = Quaternion.fromVector(vector);
        return q.multiply(mutating).multiply(q1).toVector();
    }

    /**
     * Returns new Vector
     *
     * @param direction   direction of translation.
     * @param translation translation (absolute)
     * @param vector a Vector to be translated.
     * @return translated Vector.
     */
    public static Vector translateVector(Vector direction, double translation, Vector vector) {
        return vector.add(direction.normalize().multiply(translation));
    }


}
