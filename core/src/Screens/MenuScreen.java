package Screens;

import Actors.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.MainGame;

public class MenuScreen extends MainScreen 
{
	private Stage stage;
	private Background bg;

	public MenuScreen(MainGame game) {
		super(game);
		
		stage = new Stage(new FillViewport(SCREEN_WIDTH, SCREEN_HEIGHT));
		bg = new Background();
	}
	
	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override
	public void resize(int width, int height) {

	}

}
