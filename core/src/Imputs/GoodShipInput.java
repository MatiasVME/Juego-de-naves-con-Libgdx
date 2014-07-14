package Imputs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class GoodShipInput extends InputAdapter {

	private VirtualController controller;
	
	public GoodShipInput(VirtualController controller) {
		this.controller = controller;
	}	
	
	@Override
	public boolean keyDown(int keycode) {
		
		// Desktop version
		//
		
		switch (keycode) {
			case Input.Keys.LEFT:
			case Input.Keys.A:
				if (!controller.moveRight)
					controller.moveLeft = true;
				return true;
			case Input.Keys.RIGHT:
			case Input.Keys.D:
				if (!controller.moveLeft)
					controller.moveRight = true;
				return true;
			case Input.Keys.SPACE:
				if (!controller.shoot)
					controller.shoot = true;
				return true;
			default:
				return false;
		}
	}
	
	@Override
	public boolean keyUp(int keycode) {
		
		// Desktop version
		//
		
		switch (keycode) {
			case Input.Keys.LEFT:
			case Input.Keys.A:
				controller.moveLeft = false;
				return true;
			case Input.Keys.RIGHT:
			case Input.Keys.D:
				controller.moveRight = false;
				return true;
			case Input.Keys.SPACE:
				controller.shoot = false;
				return true;
			default:
				return false;
		}
	}
}
