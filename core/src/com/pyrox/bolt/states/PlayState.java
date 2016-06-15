package com.pyrox.bolt.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.pyrox.bolt.bolt;
import com.pyrox.bolt.sprites.Ball;
import com.pyrox.bolt.sprites.Tube;

/**
 * Created by pyrox on 15/6/16.
 */
public class PlayState extends State {
    private static final int TUBE_SPACING = 200;
    private static final int TUBE_COUNT = 2;
    private Array<Tube> tubes;
    private Ball ball;
    private Texture background;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        ball = new Ball(50,100);
        background = new Texture("background.png");

        tubes = new Array<Tube>();

        cam.setToOrtho(false, bolt.WIDTH /2,bolt.HEIGHT /2);


        for (int i = 1;i < TUBE_COUNT; i++ ){
            tubes.add(new Tube(i * (TUBE_SPACING)));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            ball.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        ball.update(dt);
        cam.position.x = ball.getPosition().x + 80;
        for (Tube tube : tubes){
            if (cam.position.x - cam.viewportWidth / 2 > tube.getPosHosTube().x + tube.getHosTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x );
                tube.reposition(tube.getPosBotTube().x + 150 );
                tube.reposition(tube.getPosHosTube().x + 300 );
            }
        }
        cam.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,cam.position.x - cam.viewportWidth / 2,0);
        sb.draw(ball.getBall(),ball.getPosition().x,ball.getPosition().y);
        for (Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
            sb.draw(tube.getHosTube(), tube.getPosHosTube().x, tube.getPosHosTube().y);
        }
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
