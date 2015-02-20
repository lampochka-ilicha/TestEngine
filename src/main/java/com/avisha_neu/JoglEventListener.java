package com.avisha_neu;

import com.avisha_neu.scene.Scene;

import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class JoglEventListener implements GLEventListener, KeyListener, MouseMotionListener {
    private GLCanvas canvas;
    private Scene scene;

    private int oldX = 0;

    public JoglEventListener(GLCanvas canvas, Scene scene) {
        this.canvas = canvas;
        this.scene = scene;
    }

    @Override
    public void init(javax.media.opengl.GLAutoDrawable glAutoDrawable){}

    @Override
    public void dispose(javax.media.opengl.GLAutoDrawable glAutoDrawable){}

    @Override
    public void display(javax.media.opengl.GLAutoDrawable glAutoDrawable){
        scene.clear(glAutoDrawable.getGL().getGL2());
        scene.draw(glAutoDrawable.getGL().getGL2());
    }

    @Override
    public void reshape(javax.media.opengl.GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3){}

    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT){
            scene.getCamera().stepToTheLeft();
        }
        if (code == KeyEvent.VK_RIGHT){
            scene.getCamera().stepToTheRight();
        }
        if (code == KeyEvent.VK_UP){
            scene.getCamera().stepForward();
        }
        if (code == KeyEvent.VK_DOWN){
            scene.getCamera().stepBack();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e){
        scene.getCamera().rotate(e.getX() - oldX);
        oldX = e.getX();
    }

    @Override
    public void mouseDragged(MouseEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyTyped(KeyEvent e){}
}