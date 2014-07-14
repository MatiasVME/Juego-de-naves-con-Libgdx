package Imputs;

import com.badlogic.gdx.InputAdapter;

public class ScreenInput extends InputAdapter {
	private VirtualController controller;
	
	public ScreenInput(VirtualController controller) {
		this.controller = controller;
	}
	
	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {		
		if (!controller.shoot) {
			controller.shoot = true;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		controller.shoot = false;
		return true;
	}	
}
