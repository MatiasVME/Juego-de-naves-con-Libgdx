package com.mygdx.game;

import Screens.MainScreen;
import Screens.MenuScreen;
import Screens.NaveScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {

	private MainScreen mainScreen;
	private MenuScreen menuScreen;

	@Override
	public void create () {
		//menuScreen = new MenuScreen(this);
		mainScreen = new NaveScreen(this);
		
		setScreen(mainScreen);
	}
}
