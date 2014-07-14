package Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class Logo extends Actor implements Disposable {

	private TextureRegion logo;
	
	public Logo() {
		logo = new TextureRegion(new Texture("minilogo.png"));
		setSize(64, 64);
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(logo, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
}
