package com.avisha_neu;

import com.avisha_neu.properties.CameraProperties;
import com.avisha_neu.properties.WindowProperties;
import com.avisha_neu.scene.Scene;

import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
class JoglEventListener implements GLEventListener, KeyListener, MouseMotionListener {
    private GLCanvas canvas;
    private final Scene scene;
    private final int middleX = (WindowProperties.getWidth() / 2);
    private final int middleY = (WindowProperties.getHeight() / 2);

    public JoglEventListener(GLCanvas canvas, Scene scene) {
        this.canvas = canvas;
        this.scene = scene;
    }

    @Override
    public void init(javax.media.opengl.GLAutoDrawable glAutoDrawable) {
        setCursorToTheCenter();
        canvas.requestFocusInWindow();
    }

    @Override
    public void dispose(javax.media.opengl.GLAutoDrawable glAutoDrawable) {
    }

    private void setCursorToTheCenter() {
        try {
            Robot rob = new Robot();
            rob.mouseMove(middleX, middleY);
        } catch (AWTException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void display(javax.media.opengl.GLAutoDrawable glAutoDrawable) {
        scene.clear(glAutoDrawable.getGL().getGL2());
        scene.draw(glAutoDrawable.getGL().getGL2());
    }

    @Override
    public void reshape(javax.media.opengl.GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            scene.getCamera().setMovingToTheLeft(true);
        }
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            scene.getCamera().setMovingToTheRight(true);
        }
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            scene.getCamera().setMovingForward(true);
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            scene.getCamera().setMovingBack(true);
        }
        if (code == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            scene.getCamera().setMovingToTheLeft(false);
        }
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            scene.getCamera().setMovingToTheRight(false);
        }
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            scene.getCamera().setMovingForward(false);
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            scene.getCamera().setMovingBack(false);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double xTranslation = (e.getXOnScreen() - middleX) * CameraProperties.getRotationVelocity();
        double yTranslation = (e.getYOnScreen() - middleY) * CameraProperties.getRotationVelocity();
        if (!(xTranslation == 0 && yTranslation == 0)) {
            scene.getCamera().rotate(xTranslation, yTranslation);
            setCursorToTheCenter();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }



    @Override
    public void keyTyped(KeyEvent e) {
    }
}