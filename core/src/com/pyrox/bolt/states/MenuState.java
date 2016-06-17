package com.pyrox.bolt.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pyrox.bolt.bolt;

/**
 * Created by pyrox on 11/6/16.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playbtn;
    private BitmapFont font_title,font_tag;
    private SpriteBatch sb;
    private GlyphLayout glyphtitle,glyphtag;
    private String title,tag;
    private float title_width,tag_width;


    private Texture pyrox;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, bolt.WIDTH / 2, bolt.HEIGHT / 2);
        background = new Texture("background.png");
        font_title = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);
        font_tag = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);
        sb = new SpriteBatch();
        playbtn = new Texture("playbtn.png");
        glyphtitle = new GlyphLayout();
        glyphtag = new GlyphLayout();
        title = new String("BOLT");
        tag = new String("TEAM PYROX INC.");
        glyphtitle.setText(font_title,title);
        font_title.getData().setScale(2f);
        glyphtag.setText(font_tag,tag);
        tag_width = glyphtag.width;
        title_width = glyphtitle.width;
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
        font_title.draw(sb,title, cam.position.x - title_width /2 ,(cam.position.y) * 3 / 2);
        font_tag.draw(sb,tag,cam.position.x - tag_width / 2,cam.position.y / 6);
        sb.draw(playbtn,cam.position.x - playbtn.getWidth() / 2,cam.position.y  );
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
    }
}
