package com.ponggame.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.ponggame.PongGame;

/**
 * TODO: Header
 * <p/>
 * Created on 11/14/18.
 *
 * @author dhananjaysuresh
 */
public class Paddle extends Rectangle {
    public Texture paddleImage;
    public String name;
    public Boolean tweening = false;

    public Boolean getTweening() {
        return tweening;
    }

    public void setTweening(Boolean tweening) {
        this.tweening = tweening;
    }

    public Paddle(String name, int x) {
        this.name = name;
        Pixmap paddlePixmap = new Pixmap(10, 100, Pixmap.Format.RGBA8888);
        paddlePixmap.setColor(Color.WHITE);
        paddlePixmap.fill();
        this.paddleImage = new Texture(paddlePixmap);
        this.width = paddleImage.getWidth();
        this.height = paddleImage.getHeight();
        this.x = x;
        this.y = (PongGame.HEIGHT / 2) - (this.height / 2);
    }

    public void dispose() {
        paddleImage.dispose();
    }

    public void setCenterY(float posY) {
        this.y = posY - (this.height / 2);
    }

    public float getTop() {
        return this.y + this.height;
    }

    public void setTop(float posY) {
        this.y = posY - this.height;
    }

    public float getCenterY() {
        return y + (height / 2);
    }

}