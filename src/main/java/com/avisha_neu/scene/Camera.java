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


    public void rotate(int translation) {
       double angle = translation*CameraProperties.getRotateVelocity();
       direction = Manipulator.rotateVector(up, angle, direction);
    }

    public void stepToTheLeft() {
        position = Manipulator.translateVector(direction.multiply(up), - CameraProperties.getVelocity(), position);
    }

    public void stepToTheRight() {
        position = Manipulator.translateVector(direction.multiply(up), CameraProperties.getVelocity(), position);
    }

    public void stepForward() {
        position = Manipulator.translateVector(direction, CameraProperties.getVelocity(), position);
    }

    public void stepBack() {
        position = Manipulator.translateVector(direction, -CameraProperties.getVelocity(), position);
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
