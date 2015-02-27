package com.avisha_neu.math;

public class Manipulator {

    /**
     * Returns new Vector
     *
     * @param axis1   first rotation axis.
     * @param axis2   second rotation axis.
     * @param angle1  first rotation angle (on axis1), in radians.     *
     * @param angle2  second rotation angle (on axis2), in radians.
     * @param vector a Vector to be rotated.
     * @return rotated Vector.
     */
    public static Vector rotateVectorOnTwoAxes(Vector axis1, Vector axis2, double angle1, double angle2, Vector vector) {
        Vector omega1 = axis1.multiply(angle1);
        Vector omega2 = axis2.multiply(angle2);
        Vector omegaResult = omega1.add(omega2);
        Vector resultAxis = omegaResult.normalize();
        double resultAngle = omegaResult.getModule();
        return rotateVector(resultAxis, resultAngle, vector);
    }

    /**
     * Returns new Vector
     *
     * @param axis   rotation axis.
     * @param angle  rotation angle, in radians.
     * @param vector a Vector to be rotated.
     * @return rotated Vector.
     */
    private static Vector rotateVector(Vector axis, double angle, Vector vector) {
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
