package com.me.GBG;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Glass-Ball-Game";
		cfg.useGL20 = false;
		cfg.width = 640;
		cfg.height = 360;
		
		new LwjglApplication(new GlassBallGame(), cfg);
	}
}
