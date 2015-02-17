package com.avisha_neu.scene;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

/**
 * Created by tatyana.kalnitskaya on 17.02.15.
 */
public class Scene {
    private Human human;

    public Scene() {
        this.human = new Human();
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public void draw(GL2 gl){


    }

}
