package com.avisha_neu;

import com.avisha_neu.scene.Scene;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class JoglEventListener implements GLEventListener, KeyListener {
    private GLCanvas canvas;
    private Scene scene;

    public JoglEventListener(GLCanvas canvas, Scene scene) {
        this.canvas = canvas;
        this.scene = scene;
    }
    public void init(javax.media.opengl.GLAutoDrawable glAutoDrawable){}


    public void dispose(javax.media.opengl.GLAutoDrawable glAutoDrawable){}

    public void display(javax.media.opengl.GLAutoDrawable glAutoDrawable){
       // scene.draw();
        drawCube(glAutoDrawable);

    }

    public void reshape(javax.media.opengl.GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3){}

    private void drawCube(GLAutoDrawable drawable) {
        GL2 gl2 = drawable.getGL().getGL2();
        GLU glu = new GLU();


       // gl2.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl2.glColor3f(1, 0, 0);

        double a = 1.0/2;

        gl2.glBegin(GL.GL_LINE_LOOP);
        gl2.glVertex3d(a, a, a);
        gl2.glVertex3d(a, -a, a);
        gl2.glVertex3d(-a, -a, a);
        gl2.glVertex3d(-a, a, a);
        gl2.glEnd();

        gl2.glBegin(GL.GL_LINE_LOOP);
        gl2.glVertex3d(-a, a, a);
        gl2.glVertex3d(-a, a, -a);
        gl2.glVertex3d(-a, -a, -a);
        gl2.glVertex3d(-a, -a, a);
        gl2.glEnd();

        gl2.glBegin(GL.GL_LINE_LOOP);
        gl2.glVertex3d(-a, -a, a);
        gl2.glVertex3d(-a, -a, -a);
        gl2.glVertex3d(a, -a, -a);
        gl2.glVertex3d(a, -a, a);
        gl2.glEnd();

        gl2.glBegin(GL.GL_LINE_LOOP);
        gl2.glVertex3d(a, a, a);
        gl2.glVertex3d(a, -a, a);
        gl2.glVertex3d(a, -a, -a);
        gl2.glVertex3d(a, a, -a);
        gl2.glEnd();

        gl2.glBegin(GL.GL_LINE_LOOP);
        gl2.glVertex3d(-a, a, -a);
        gl2.glVertex3d(a, a, -a);
        gl2.glVertex3d(a, -a, -a);
        gl2.glVertex3d(-a, -a, -a);
        gl2.glEnd();

    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT){
            scene.getHuman().stepToTheLeft();
        }
        if (code == KeyEvent.VK_RIGHT){
            scene.getHuman().stepToTheRight();
        }
        if (code == KeyEvent.VK_UP){
            scene.getHuman().stepForward();
        }
        if (code == KeyEvent.VK_DOWN){
            scene.getHuman().stepBack();
        }
    }

    public void keyReleased(KeyEvent e){}


    public void keyTyped(KeyEvent e){}
}