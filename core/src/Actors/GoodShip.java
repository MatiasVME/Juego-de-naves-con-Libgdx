package Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class GoodShip extends Actor implements Disposable {
	private final float MOVEMENT = 2f;
	
	private Texture ttGoodShip;
	private TextureRegion trGoodShip;
	private float x;
	private float limitLeft, limitRight;
	
	public GoodShip(float limitLeft, float limitRight) {
		ttGoodShip = new Texture("goodship.png");
		trGoodShip = new TextureRegion(ttGoodShip);
		setSize(64, 64);
		this.limitLeft = limitLeft;
		this.limitRight = limitRight;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(trGoodShip, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		this.x = getX();
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void dispose() {
		ttGoodShip.dispose();		
	}
	
	// Keyboard movement
	
	public void moveRight() {
		if (this.x <= this.limitRight) {
			this.x += 10;
			this.setX(x);
		}
	}
	
	public void moveLeft() {		
		if (this.x >= this.limitLeft) {
			this.x -= 10;
			this.setX(x);
		}
	}
	
	// Accelerometer movement
	
	public void accMoveRight (float accelerometer) {
		if (this.x <= this.limitRight) {
			this.x -= this.MOVEMENT * accelerometer;
			this.setX(x);
		}	
	}
	
	public void accMoveLeft (float accelerometer) {
		if (this.x >= this.limitLeft) {
			this.x -= this.MOVEMENT * accelerometer;
			this.setX(x);
		}
	}
}
