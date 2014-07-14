package Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class Bullet extends Actor implements Disposable {
	
	private float MOVEMENT = 6f;
	
	private Texture ttBullet;
	private TextureRegion trBullet;
	
	private float x, y;
	private float limit;
	private boolean onScreen;
	
	private Rectangle bb;

	public Bullet () {
		ttBullet = new Texture("bullet_up.png");
		trBullet = new TextureRegion(ttBullet);
		bb = new Rectangle();
		this.onScreen = false;
	}
	
	@Override
	public void dispose() {
		ttBullet.dispose();
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		bb.set(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(trBullet, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	public void shootUp (float originX, float originY, float limit) {
		this.setSize(32, 32);
		this.x = originX;
		this.y = originY;
		this.limit = limit;
		this.setX(this.x);
		this.setY(this.y);
		this.onScreen = true;
	}
	
	public void update() {		
		if (this.limit >= this.y && this.onScreen) {
			this.y += MOVEMENT;
			this.setY(y);
		}
		
		else {
			this.onScreen = false;
		}
	}
	
	public void restart() {
		this.onScreen = false;
		//this.setVisible(false);
		this.setX(0);
		this.setY(0);
	}
	
	public boolean isOnScreen() {
		return this.onScreen;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public Rectangle getBB() {
		return this.bb;
	}
}
