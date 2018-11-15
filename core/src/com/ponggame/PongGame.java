package com.ponggame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ponggame.accessors.CameraAccessor;
import com.ponggame.accessors.PaddleAccessor;
import com.ponggame.accessors.TableAccessor;
import com.ponggame.objects.Paddle;
import com.ponggame.screens.LoadingScreen;
import com.ponggame.screens.PongBoard;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class PongGame extends Game {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    public static final int WIDTH = 800, HEIGHT = 480;
    public SpriteBatch batch;
    public Screen mainMenu;
    public PongBoard pongBoard;
    public boolean musicOn = true;
    public String winningPlayer = "Player 1";
    public int player1Score = 0;
    public int player2Score = 0;
    public Music musicToPlay;
    public boolean musicCurrentlyPlaying = false;
    public TweenManager tweenManager;
    public AssetManager assetManager;
    public Label.LabelStyle titleStyle;
    public Texture ballImage;
    public Texture smallParticleImage;
    public Texture mediumParticleImage;
    public Texture largeParticleImage;
    public Texture netImage;
    public BitmapFont scoreFont;

    //==============================================================================================
    // Class Instance Methods
    //==============================================================================================

    @Override
    public void create() {
        setupTweenManager();
        assetManager = new AssetManager();

        batch = new SpriteBatch();
        this.setScreen(new LoadingScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void setupTweenManager() {
        tweenManager = new TweenManager();
        Tween.registerAccessor(Camera.class, new CameraAccessor());
        Tween.registerAccessor(Table.class, new TableAccessor());
        Tween.registerAccessor(Paddle.class, new PaddleAccessor());
    }
}
