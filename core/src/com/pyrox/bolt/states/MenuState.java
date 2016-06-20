package com.pyrox.bolt.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pyrox.bolt.bolt;

/**
 * Created by pyrox on 11/6/16.
 */
public class MenuState extends State {
    private Texture background;
    private BitmapFont font_title,font_tag;
    private SpriteBatch sb;
    private GlyphLayout glyphtitle,glyphtag,glyphplay;
    private String title,tag,play;
    private float title_width,tag_width,play_width;
    private Stage stage;
    private TextButton button;
    private TextButton.TextButtonStyle textButtonStyle;
    private Skin skin;
    private TextureAtlas buttonAtlas;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, bolt.WIDTH / 2, bolt.HEIGHT / 2);
        background = new Texture("background.png");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.pack"));
        skin.addRegions(buttonAtlas);
        font_title = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"),false );
        font_tag = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);
        sb = new SpriteBatch();
        font_title.getData().setScale(3f,3f);
        glyphtitle = new GlyphLayout();
        glyphtag = new GlyphLayout();
        glyphplay = new GlyphLayout();
        title = new String("BOLT");
        tag = new String("TEAM PYROX INC.");
        play = new String("Play");
        glyphtitle.setText(font_title,title);
        glyphplay.setText(font_tag,play);
        glyphtag.setText(font_tag,tag);
        tag_width = glyphtag.width;
        title_width = glyphtitle.width;
        play_width = glyphplay.width;

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font_tag;
        textButtonStyle.up = skin.getDrawable("buttons");
        textButtonStyle.down = skin.getDrawable("buttons");
        textButtonStyle.checked = skin.getDrawable("buttons");
        button = new TextButton("Play", textButtonStyle);
        stage.addActor(button);
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
        stage.draw();
        sb.draw(background,0,0);
        font_title.draw(sb,title, cam.position.x - title_width / 2, (cam.position.y  * 7) / 4);
        font_tag.draw(sb,tag,cam.position.x - tag_width / 2,cam.position.y / 6);
        font_tag.draw(sb,play,cam.position.x - play_width / 2,cam.position.y);
        sb.end();
    }
    @Override
    public void dispose() {
        background.dispose();
        font_tag.dispose();
        font_title.dispose();
        sb.dispose();


    }


}
