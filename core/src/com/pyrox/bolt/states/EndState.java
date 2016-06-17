package com.pyrox.bolt.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pyrox.bolt.bolt;

/**
 * Created by pyrox on 17/6/16.
 */
public class EndState extends State {

    private Texture background;
    private SpriteBatch sb;
    private BitmapFont font;

    protected EndState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, bolt.WIDTH /2,bolt.HEIGHT /2);
        background = new Texture("background.png");
        sb = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){

        }


    }

    @Override
    public void update(float dt) {
        handleInput();


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        font.dispose();

    }
}
