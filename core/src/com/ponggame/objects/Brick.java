package com.ponggame.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.ponggame.PongGame;

/**
 * TODO: Header
 * <p/>
 * Created on 11/25/18.
 *
 * @author 6lor
 */
public class Brick extends Rectangle {
    public int originalY;
    public Texture brickImage;
    public String name;
    public Boolean tweening = false;

    public Boolean getTweening() {
        return tweening;
    }

    public void setTweening(Boolean tweening) {
        this.tweening = tweening;
    }

    public Brick(String name, int x, int y) {
        this.name = name;
        Pixmap brickPixmap = new Pixmap(10, 100, Pixmap.Format.RGBA8888);
        brickPixmap.setColor(Color.WHITE);
        brickPixmap.fill();
        this.brickImage = new Texture(brickPixmap);
        this.width = brickImage.getWidth();
        this.height = brickImage.getHeight();
        this.x = x;
        this.y = y;
        this.originalY = y;
    }

    public void dispose() {
        brickImage.dispose();
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

    public void setOriginalY() {
        this.setY(originalY);
    }

}