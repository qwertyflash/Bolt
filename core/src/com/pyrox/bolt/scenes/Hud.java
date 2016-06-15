package com.pyrox.bolt.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pyrox.bolt.bolt;

/**
 * Created by pyrox on 14/6/16.
 */
public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Integer score;
    Label scoreLabel;
    Label nameLabel;


    public Hud (SpriteBatch sb){


        score = 0;
        viewport = new FitViewport(bolt.WIDTH,bolt.HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,sb);
        Table table = new Table();
        table.bottom();
        table.setFillParent(true);
        scoreLabel = new Label(String.format("%06d", score),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        nameLabel = new Label("SCORE",new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(nameLabel).expandX().padBottom(10);
        table.add(scoreLabel).expandX().padBottom(10);

        stage.addActor(table);


    }


}
