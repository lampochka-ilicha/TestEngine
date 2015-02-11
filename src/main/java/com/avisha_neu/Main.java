package com.avisha_neu;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Tatyana.Kalnitskaya on 11.02.15.
 */
public class Main implements GLEventListener {
    public static void main(String[] args) {

        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        canvas.addGLEventListener(new Main());
        Frame frame = new Frame("Window Test");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        render(drawable);
    }


    public void init(GLAutoDrawable drawable) {}

    public void dispose(GLAutoDrawable drawable) {}

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}

    private void render(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2d(-1, -1);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2d(0, 1);
        gl.glColor3f(0, 0, 1);
        gl.glVertex2d(1, -1);
        gl.glEnd();
    }
}
