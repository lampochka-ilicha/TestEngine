package com.avisha_neu;

import com.avisha_neu.math.Vector;

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
    // keep pointer to associated canvas so we can refresh the screen (equivalent to glutPostRedisplay())
    private GLCanvas canvas;

    // constructor
    public JoglEventListener(GLCanvas canvas) {
        this.canvas = canvas;
    }

    public void init(javax.media.opengl.GLAutoDrawable glAutoDrawable){
       // glAutoDrawable.addKeyListener(this);

    }


    public void dispose(javax.media.opengl.GLAutoDrawable glAutoDrawable){}

    public void display(javax.media.opengl.GLAutoDrawable glAutoDrawable){drawCube(glAutoDrawable);}

    public void reshape(javax.media.opengl.GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3){}

    private void drawCube(GLAutoDrawable drawable) {
        GL2 gl2 = drawable.getGL().getGL2();
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();
        glu.gluPerspective(60.0, 600/300.0, 1, 50);
        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glLoadIdentity();
        glu.gluLookAt(Camera.position.getX(), Camera.position.getY(),
                Camera.position.getZ(),
                Camera.direction.getX() + Camera.position.getX(),
                Camera.direction.getY() + Camera.position.getY(), Camera.direction.getZ() - 5
                + Camera.position.getZ(), 0.0,1.0,0.0);
        gl2.glClear(GL.GL_COLOR_BUFFER_BIT);
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


        // gl.glColor3f(0, 1, 0);
        //gl.glVertex2d(0, 1);
        //gl.glColor3f(0, 0, 1);
        //gl.glVertex2d(1, -1);

    }

    public void keyTyped(KeyEvent e){
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     */
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        double v = 0.2;
        if (code == KeyEvent.VK_LEFT){
            Vector left = new Vector (-v, 0, 0);
            Camera.position = Camera.position.add(left);
        }
        if (code == KeyEvent.VK_RIGHT){
            Vector right = new Vector (v, 0, 0);
            Camera.position = Camera.position.add(right);
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     */
    public void keyReleased(KeyEvent e){

    }

    // ...
    // event handler functions
    // ...
}