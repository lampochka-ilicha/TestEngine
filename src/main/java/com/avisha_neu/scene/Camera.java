package com.avisha_neu.scene;

import com.avisha_neu.math.Vector;
import com.avisha_neu.properties.HumanProperties;
import com.avisha_neu.properties.WindowProperties;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class Camera {
    private Vector position = new Vector(0.0, 0.0, 5);
    private  Vector direction = new Vector(0.0, 0.0, 0.0);

    private HumanProperties humanProperties;
    private WindowProperties windowProperties;

    public  Camera () {
        this.humanProperties = new HumanProperties();
        this.windowProperties = new WindowProperties();
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public  Vector getDirection() {
        return direction;
    }

    public  void setDirection(Vector direction) {
        this.direction = direction;
    }

    public void translate(Vector translation) {
        position = position.add(translation);
    }

    public void stepToTheLeft() {
        Vector leftTravel = new Vector(-humanProperties.getVelocity(), 0, 0);
        translate(leftTravel);
    }

    public void stepToTheRight() {
        Vector rightTravel = new Vector(humanProperties.getVelocity(), 0, 0);
        translate(rightTravel);
    }

    public void stepForward() {
        Vector forwardTravel = new Vector(0, 0, -humanProperties.getVelocity());
        translate(forwardTravel);
    }

    public void stepBack() {
        Vector backTravel = new Vector(0, 0, humanProperties.getVelocity());
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
        glu.gluPerspective(humanProperties.getViewAngle(),
                windowProperties.getWidth() / windowProperties.getHeight(),
                windowProperties.getZNear(), windowProperties.getZFar());
    }

    private void setViewPoint(GL2 gl) {
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        GLU glu = new GLU();
        glu.gluLookAt(position.getX(), position.getY(),
                position.getZ(),
                direction.getX() + position.getX(),
                direction.getY() + position.getY(),
                direction.getZ() + position.getZ() - humanProperties.getViewDistance(),
                0.0,1.0,0.0);
    }


}
