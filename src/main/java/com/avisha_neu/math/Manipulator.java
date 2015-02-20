package com.avisha_neu.math;

public class Manipulator {

    /**
     * Returns an Image object that can then be painted on the screen.
     * <p>
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     *
     * @param  axis  an absolute URL giving the base location of the image
     * @param  angle the location of the image, relative to the url argument
     * @return      the image at the specified URL
     * @see
     */
       public static Vector rotateVector(Vector axis, double angle, Vector vector){
        Quaternion q = Quaternion.rawCreate(axis, angle);
        Quaternion q1 = q.getInverse();
        return q.multiply(Quaternion.fromVector(vector)).multiply(q1).toVector();
    }
}
