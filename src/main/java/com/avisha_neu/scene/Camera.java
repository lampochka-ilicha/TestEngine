package com.avisha_neu.scene;

import com.avisha_neu.math.Manipulator;
import com.avisha_neu.math.Vector;
import com.avisha_neu.properties.CameraProperties;
import com.avisha_neu.properties.WindowProperties;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class Camera {
    private Vector position = new Vector(0, 0, 5);
    private Vector direction = new Vector(0, 0, -5);
    private Vector up = new Vector(0, 1, 0);

    public  Camera () {}

    public void translate(Vector translation) {
        position = position.add(translation);
    }

    public void rotate(int translation) {
       double angle = translation*CameraProperties.getRotateVelocity();
       direction = Manipulator.rotateVector(up, angle, direction);
    }

    public void stepToTheLeft() {
        Vector leftTravel = direction.multiply(CameraProperties.getVelocity()); //new Vector(-CameraProperties.getVelocity(), 0, 0);
        translate(leftTravel);
    }

    public void stepToTheRight() {
        Vector rightTravel = new Vector(CameraProperties.getVelocity(), 0, 0);
        translate(rightTravel);
    }

    public void stepForward() {
        Vector forwardTravel = direction.multiply(CameraProperties.getVelocity());//new Vector(0, 0, -CameraProperties.getVelocity());
        translate(forwardTravel);
    }

    public void stepBack() {
        Vector backTravel = direction.multiply( - CameraProperties.getVelocity());
        translate(backTravel);
    }

    public void setView(GL2 gl) {
        setViewPerspective(gl);
        setViewPoint(gl);
    }

    private void setViewPerspective(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU glu = new GLU();
        glu.gluPerspective(CameraProperties.getViewAngle(),
                WindowProperties.getWidth() / WindowProperties.getHeight(),
                WindowProperties.getZNear(), WindowProperties.getZFar());
    }

    private void setViewPoint(GL2 gl) {
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        GLU glu = new GLU();
        glu.gluLookAt(position.getX(), position.getY(),
                position.getZ(),
                direction.getX() + position.getX(),
                direction.getY() + position.getY(),
                direction.getZ() + position.getZ(),
                up.getX(), up.getY(), up.getZ());
    }


}
