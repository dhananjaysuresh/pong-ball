package com.ponggame.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.ponggame.PongGame;

/**
 * This class draws the ball object.
 * <p/>
 * Created on 11/14/18.
 *
 * @author dhananjaysuresh
 */
public class Ball extends Rectangle {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    public Texture ballImage;
    public float xVel;
    public float yVel;
    private String name;

    //==============================================================================================
    // Constructor
    //==============================================================================================

    public Ball(PongGame game) {
        this.name = "ball";

        ballImage = game.ballImage;
        resetPosition();
        this.width = ballImage.getWidth();
        this.height = ballImage.getHeight();
        this.xVel = -200f;
        this.yVel = -200f;

    }

    //==============================================================================================
    // Class Methods
    //==============================================================================================

    public void resetVelocityX(int direction) {
        this.xVel = 200f * direction;
    }

    public float getCombinedVelocity(float delta) {
        double velSquared = Math.pow(xVel, 2) + Math.pow(yVel, 2);
        return (float) Math.sqrt(velSquared) * delta;
    }

    public void moveX(float deltaTime) {
        this.x += this.xVel * deltaTime;
    }

    public void moveY(float deltaTime) {
        this.y -= this.yVel * deltaTime;
    }

    public void dispose() {
        ballImage.dispose();
    }

    public float getTop() {
        return this.y + this.height;
    }

    public void setTop(float posY) {
        this.y = posY - this.height;
    }

    public void setBottom(float posY) {
        this.y = posY;
    }

    public float getRight() {
        return this.x + this.width;
    }

    public void setRight(float posX) {
        this.x = posX - this.width;
    }

    public void resetPosition() {
        this.x = PongGame.WIDTH / 2;
        this.y = PongGame.HEIGHT / 2;
    }

    public void reverseDirectionX() {
        this.xVel *= -1;
    }

    public void reverseDirectionY() {
        this.yVel *= -1;
    }

    public float getBottom() {
        return getY();
    }
}
