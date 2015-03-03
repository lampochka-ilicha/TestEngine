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
    private final Vector up = new Vector(0, 1, 0);

    private boolean movingToTheLeft;
    private boolean movingToTheRight;
    private boolean movingForward;
    private boolean movingBack;


    public Camera() {
    }

    public boolean isMovingToTheLeft() {
        return movingToTheLeft;
    }

    public void setMovingToTheLeft(boolean movingToTheLeft) {
        this.movingToTheLeft = movingToTheLeft;
    }

    public boolean isMovingToTheRight() {
        return movingToTheRight;
    }

    public void setMovingToTheRight(boolean movingToTheRight) {
        this.movingToTheRight = movingToTheRight;
    }

    public boolean isMovingForward() {
        return movingForward;
    }

    public void setMovingForward(boolean movingForward) {
        this.movingForward = movingForward;
    }

    public boolean isMovingBack() {
        return movingBack;
    }

    public void setMovingBack(boolean movingBack) {
        this.movingBack = movingBack;
    }

    private Vector getDirectionXZUnit() {
        return new Vector(direction.getX(), 0, direction.getZ()).normalize();
    }

    public void rotate(double leftRightTranslation, double upDownTranslation) {
        double angleLeftRight = leftRightTranslation * CameraProperties.getRotationVelocity();
        double angleUpDown = upDownTranslation * CameraProperties.getRotationVelocity();
        Vector axeLeftRight = up;
        Vector directionXZ = getDirectionXZUnit();
        Vector axeUpDown = directionXZ.multiply(up);
        direction = Manipulator.rotateVectorOnTwoAxes(axeUpDown, axeLeftRight, angleUpDown, angleLeftRight, direction);
    }

    public void move() {
        Vector directionXZ = getDirectionXZUnit();
        Vector newPosition = position;
        if (movingBack) {
            newPosition = Manipulator.translateVector(directionXZ, -CameraProperties.getVelocity(), newPosition);
        }
        if (movingForward) {
            newPosition = Manipulator.translateVector(directionXZ, CameraProperties.getVelocity(), newPosition);
        }
        if (movingToTheRight) {
            newPosition = Manipulator.translateVector(directionXZ.multiply(up), CameraProperties.getVelocity(), newPosition);
        }
        if (movingToTheLeft) {
            newPosition = Manipulator.translateVector(directionXZ.multiply(up), -CameraProperties.getVelocity(), newPosition);
        }
        position = newPosition;
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
