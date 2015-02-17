package com.avisha_neu.scene;

import com.avisha_neu.math.Vector;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class Camera {
    private Vector position = new Vector(0.0, 0.0, 5.0);
    private  Vector direction = new Vector(0.0, 0.0, 0.0);

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
        direction = direction.add(translation);
    }

    public void lookAt(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU glu = new GLU();
        glu.gluPerspective(60.0, 600/300.0, 1, 50);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(position.getX(), position.getY(),
                position.getZ(),
                direction.getX() + position.getX(),
                direction.getY() + position.getY(),
                direction.getZ() - 5  + position.getZ(),
                0.0,1.0,0.0);
    }
}
