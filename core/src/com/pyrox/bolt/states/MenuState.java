package com.pyrox.bolt.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pyrox.bolt.bolt;

/**
 * Created by pyrox on 11/6/16.
 */
public class MenuState extends State {
    private Texture background;
    private Texture title;
    private Texture playbtn;
    private BitmapFont font;
    private SpriteBatch sb;

    private Texture pyrox;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, bolt.WIDTH / 2, bolt.HEIGHT / 2);
        background = new Texture("background.png");
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);
        sb = new SpriteBatch();
        playbtn = new Texture("playbtn.png");


    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));

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
        sb.draw(playbtn,cam.position.x - playbtn.getWidth() / 2,cam.position.y  );
        sb.draw(title, cam.position.x - title.getWidth() / 2,(cam.position.y) * 3 / 2);
        sb.draw(pyrox,cam.position.x - pyrox.getWidth() / 2,cam.position.y / 6);
        font.draw(sb,"Hello",0,30);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        title.dispose();
        playbtn.dispose();
    }
}
