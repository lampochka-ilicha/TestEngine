package com.avisha_neu;

import com.avisha_neu.properties.PhysicsProperties;
import com.avisha_neu.properties.WindowProperties;
import com.avisha_neu.scene.Scene;
import com.jogamp.opengl.util.Animator;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Tatyana.Kalnitskaya on 11.02.15.
 */

public class Main {
    public static void main(String[] args) {
        PhysicsProperties.init();

        System.out.println(PhysicsProperties.g);
        System.out.println(PhysicsProperties.active);
        System.out.println(PhysicsProperties.name);

        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        WindowProperties windowProperties = new WindowProperties();
        Scene scene = new Scene(windowProperties);
        JoglEventListener listener = new JoglEventListener(canvas, scene);
        canvas.addGLEventListener(listener);
        canvas.addKeyListener(listener);
        Animator animator = new Animator(canvas);
        animator.start();
        Frame frame = new Frame("Window Test");
        frame.setSize(600, 300);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });




    }
//
//    @Override
//    public void display(GLAutoDrawable drawable) {
//        render(drawable);
//    }
//
//
//    public void init(GLAutoDrawable drawable) {
//    }
//
//    public void dispose(GLAutoDrawable drawable) {}
//
//    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//        drawCube(drawable);
//    }
//
//    private void render(GLAutoDrawable drawable) {
//        drawCube(drawable);
////        GL2 gl = drawable.getGL().getGL2();
////        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
////
////        gl.glBegin(GL.GL_TRIANGLES);
////        gl.glColor3f(1, 0, 0);
////        gl.glVertex2d(-1, -1);
////        gl.glColor3f(0, 1, 0);
////        gl.glVertex2d(0, 1);
////        gl.glColor3f(0, 0, 1);
////        gl.glVertex2d(1, -1);
////        gl.glEnd();
//    }
//
//    private void drawCube(GLAutoDrawable drawable) {
//        GL2 gl2 = drawable.getGL().getGL2();
//        GL gl = drawable.getGL();
//        GLU glu = new GLU();
//
//        gl2.glMatrixMode(GL2.GL_PROJECTION);
//        gl2.glLoadIdentity();
//        glu.gluPerspective(60.0, 600/300.0, 1, 50);
//        gl2.glMatrixMode(GL2.GL_MODELVIEW);
//        gl2.glLoadIdentity();
//        glu.gluLookAt(Camera.position.getX(), Camera.position.getY(),
//                Camera.position.getZ(),
//                Camera.direction.getX() + Camera.position.getX(),
//                Camera.direction.getY() + Camera.position.getY(), Camera.direction.getZ() - 5
//                + Camera.position.getZ(), 0.0,1.0,0.0);
//        gl2.glClear(GL.GL_COLOR_BUFFER_BIT);
//        gl2.glColor3f(1, 0, 0);
//
//        double a = 1.0/2;
//
//        gl2.glBegin(GL.GL_LINE_LOOP);
//        gl2.glVertex3d(a, a, a);
//        gl2.glVertex3d(a, -a, a);
//        gl2.glVertex3d(-a, -a, a);
//        gl2.glVertex3d(-a, a, a);
//        gl2.glEnd();
//
//        gl2.glBegin(GL.GL_LINE_LOOP);
//        gl2.glVertex3d(-a, a, a);
//        gl2.glVertex3d(-a, a, -a);
//        gl2.glVertex3d(-a, -a, -a);
//        gl2.glVertex3d(-a, -a, a);
//        gl2.glEnd();
//
//        gl2.glBegin(GL.GL_LINE_LOOP);
//        gl2.glVertex3d(-a, -a, a);
//        gl2.glVertex3d(-a, -a, -a);
//        gl2.glVertex3d(a, -a, -a);
//        gl2.glVertex3d(a, -a, a);
//        gl2.glEnd();
//
//        gl2.glBegin(GL.GL_LINE_LOOP);
//        gl2.glVertex3d(a, a, a);
//        gl2.glVertex3d(a, -a, a);
//        gl2.glVertex3d(a, -a, -a);
//        gl2.glVertex3d(a, a, -a);
//        gl2.glEnd();
//
//        gl2.glBegin(GL.GL_LINE_LOOP);
//        gl2.glVertex3d(-a, a, -a);
//        gl2.glVertex3d(a, a, -a);
//        gl2.glVertex3d(a, -a, -a);
//        gl2.glVertex3d(-a, -a, -a);
//        gl2.glEnd();
//
//
//       // gl.glColor3f(0, 1, 0);
//        //gl.glVertex2d(0, 1);
//        //gl.glColor3f(0, 0, 1);
//        //gl.glVertex2d(1, -1);
//
//    }
}
