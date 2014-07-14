package Screens;

import Actors.Background;
import Actors.Bullet;
import Actors.Enemy;
import Actors.GoodShip;
import Imputs.GoodShipInput;
import Imputs.ScreenInput;
import Imputs.VirtualController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.MainGame;

public class NaveScreen extends MainScreen {

	// Constant
	//
	
	private final int TOTAL_ENEMIES = 4;
	private final float SEPARATOR = 10f;
	private final float SHIP_SIZE = 64f;
	
	// Variables
	//
	
	private Stage stage;
	private Background bg;
	private GoodShip goodShip;
	private Bullet bullet;
	private Array <Enemy> enemies;
	// Inputs
	private GoodShipInput goodShipInput;
	private ScreenInput screenInput;
	private VirtualController controller;
	
	public NaveScreen(MainGame game) {
		super(game);
		
		// Initialize objects
		//
		
		stage = new Stage(new FillViewport(SCREEN_WIDTH, SCREEN_HEIGHT));
		bg = new Background();
		// Create and define the limit of goodShip
		goodShip = new GoodShip(10, SCREEN_WIDTH - (SHIP_SIZE + SEPARATOR));
		bullet = new Bullet ();
		// Create enemies
		enemies = new Array <Enemy> ();
		
		// Create an define the limit of enemies
		for (int i = 0; i < this.TOTAL_ENEMIES; i++) {
			Enemy e = new Enemy((SHIP_SIZE + SEPARATOR) * i, 
					(SCREEN_WIDTH / TOTAL_ENEMIES) + (SHIP_SIZE + SEPARATOR) * (i + 1));
			this.enemies.add(e);
		}
		
		// Images position on screen
		bg.setPosition(0,0);
		goodShip.setPosition(SCREEN_WIDTH / 2 - SHIP_SIZE / 2, 
				SHIP_SIZE + SEPARATOR);
		
		float enemyX;
		
		for (int i = 0; i < this.TOTAL_ENEMIES; i++) {
			enemyX = (SHIP_SIZE + SEPARATOR) * (i + 1);
			this.enemies.get(i).setX(enemyX);
			this.enemies.get(i).setPosition(enemyX, 
					SCREEN_HEIGHT - (SHIP_SIZE * 2f + SEPARATOR));
		}
		
		// Inputs
		controller = new VirtualController();
		goodShipInput = new GoodShipInput(controller);
		screenInput = new ScreenInput(controller);
		Gdx.input.setInputProcessor(goodShipInput);
		Gdx.input.setInputProcessor(screenInput);
		
		// Add actors
		//
		
		stage.addActor(bg);
		stage.addActor(goodShip);
		stage.addActor(bullet);
		// Add enemies actors
		for (int i = 0; i < this.TOTAL_ENEMIES; i++) {
			stage.addActor(this.enemies.get(i));
		}
	}
	
	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Movement and shoots
		
		if (controller.moveRight) {
			goodShip.moveRight();
		}
		
		else if (controller.moveLeft) {
			goodShip.moveLeft();
		}
		
		else if (controller.shoot && !bullet.isOnScreen()) {
			bullet.shootUp(goodShip.getX() + (SHIP_SIZE / 4), 
					goodShip.getY() + SHIP_SIZE / 2, 
					SCREEN_HEIGHT - (SHIP_SIZE + SEPARATOR * 3));
		}
		
		// Mobile version
		
		float ax = Gdx.input.getAccelerometerX();
		
		if (ax > 0) {
			goodShip.accMoveLeft(ax);
		}
		
		else if (ax < 0) {
			goodShip.accMoveRight(ax);
		}
		
		// Shoot bullet
		
		if (bullet.isOnScreen()) {
			bullet.setVisible(true);
			bullet.update();
			bullet.setPosition(bullet.getX(), bullet.getY());
		}
		
		else {
			bullet.setVisible(false);
		}
		
		// Move the enemies and detects collisions
		
		for (int i = 0; i < TOTAL_ENEMIES; i++) {
			this.enemies.get(i).update();
			this.enemies.get(i).setX(this.enemies.get(i).getX());
			
			if (Intersector.overlaps(this.enemies.get(i).getBB(), bullet.getBB())) {
				this.enemies.get(i).setVisible(false);
				bullet.restart();
				bullet.setPosition(1, 1);
			}
		}

		stage.draw();
		stage.act();
	}
	
	@Override
	public void resize(int width, int height) {
	}
}
