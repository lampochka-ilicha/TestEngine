package com.avisha_neu.scene;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class Scene {
    private final Camera camera;

    public Scene() {
        this.camera = new Camera();
    }

    public Camera getCamera() {
        return camera;
    }

    public void clear(GL2 gl) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    }

    public void draw(GL2 gl){
        camera.setView(gl);
        camera.move();
        drawCube(gl);
    }

    private void drawCube(GL2 gl) {
        gl.glColor3f(1, 0, 0);

        double a = 1.0/2;

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(a, a, a);
        gl.glVertex3d(a, -a, a);
        gl.glVertex3d(-a, -a, a);
        gl.glVertex3d(-a, a, a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(-a, a, a);
        gl.glVertex3d(-a, a, -a);
        gl.glVertex3d(-a, -a, -a);
        gl.glVertex3d(-a, -a, a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(-a, -a, a);
        gl.glVertex3d(-a, -a, -a);
        gl.glVertex3d(a, -a, -a);
        gl.glVertex3d(a, -a, a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(a, a, a);
        gl.glVertex3d(a, -a, a);
        gl.glVertex3d(a, -a, -a);
        gl.glVertex3d(a, a, -a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(-a, a, -a);
        gl.glVertex3d(a, a, -a);
        gl.glVertex3d(a, -a, -a);
        gl.glVertex3d(-a, -a, -a);
        gl.glEnd();

        gl.glColor3f(1, 0, 1);

        a = 5.0/2;

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(a, a, a);
        gl.glVertex3d(a, -a, a);
        gl.glVertex3d(-a, -a, a);
        gl.glVertex3d(-a, a, a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(-a, a, a);
        gl.glVertex3d(-a, a, -a);
        gl.glVertex3d(-a, -a, -a);
        gl.glVertex3d(-a, -a, a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(-a, -a, a);
        gl.glVertex3d(-a, -a, -a);
        gl.glVertex3d(a, -a, -a);
        gl.glVertex3d(a, -a, a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(a, a, a);
        gl.glVertex3d(a, -a, a);
        gl.glVertex3d(a, -a, -a);
        gl.glVertex3d(a, a, -a);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex3d(-a, a, -a);
        gl.glVertex3d(a, a, -a);
        gl.glVertex3d(a, -a, -a);
        gl.glVertex3d(-a, -a, -a);
        gl.glEnd();

    }
}
