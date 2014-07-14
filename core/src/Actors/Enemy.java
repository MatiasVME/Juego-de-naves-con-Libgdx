package Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class Enemy extends Actor implements Disposable {
	private final float MOVEMENT = 2f;
	
	private Texture ttEnemy;
	private TextureRegion trEnemy;
	
	private float limitLeft, limitRight;
	private float x;
	private boolean leftMovement, rightMovement;
	private Rectangle bb;
	
	public Enemy(float limitLeft, float limitRight) {
		ttEnemy = new Texture("enemy.png");
		trEnemy = new TextureRegion(ttEnemy);
		setSize(64, 64);
		
		this.limitLeft = limitLeft;
		this.limitRight = limitRight;
		
		this.leftMovement = false;
		this.rightMovement = true;
		
		bb = new Rectangle();
	}
	
	@Override
	public void dispose() {
		ttEnemy.dispose();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(trEnemy, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		this.x = getX();
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		bb.set(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	public void update() {	
		if (this.rightMovement) {
			if (this.x <= this.limitRight) {
				this.x += MOVEMENT;
			}
			
			else {
				this.rightMovement = false;
				this.leftMovement = true;
			}
		}
		
		else if (this.leftMovement) {
			if (this.x >= this.limitLeft) {
				this.x -= MOVEMENT;
			}
			
			else {
				this.rightMovement = true;
				this.leftMovement = false;
			}
		}
	}
	
	public float getX() {
		return this.x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public Rectangle getBB () {
		return bb;
	}
}
