package com.pyrox.bolt.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pyrox.bolt.bolt;

/**
 * Created by pyrox on 17/6/16.
 */
public class EndState extends State {

    private Texture background;
    private SpriteBatch sb;
    private BitmapFont font,font_gameover;
    private String gameover,score;
    private GlyphLayout glyph_gameover,glyph_score;
    float gwidth,swidth;
    private int finalscore;
    private PlayState playState;

    protected EndState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, bolt.WIDTH /2,bolt.HEIGHT /2);
        background = new Texture("background.png");
        sb = new SpriteBatch();
        font_gameover = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);
        font_gameover.getData().setScale(2f,2f);
        glyph_gameover = new GlyphLayout();
        glyph_score = new GlyphLayout();
        gameover = new String("GAMEOVER");
        score = new String("Your Score Is");
        glyph_gameover.setText(font_gameover,gameover);
        glyph_score.setText(font,score);
        gwidth = glyph_gameover.width;
        swidth = glyph_score.width;
        finalscore = playState.points;

    }

    @Override
    protected void handleInput() {
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
        font_gameover.draw(sb,gameover,cam.position.x - gwidth / 2,(cam.position.y * 3 ) / 2);
        font.draw(sb,score,cam.position.x - swidth / 2, cam.position.y );
        font.draw(sb,Integer.toString(getFinalscore()),cam.position.x,(cam.position.y * 3) / 4);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        font.dispose();

    }

    public int getFinalscore() {
        return finalscore;
    }
}
