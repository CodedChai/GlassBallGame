package com.me.GBG;

import com.badlogic.gdx.math.Vector2;

public class Block {
	public static final int WIDTH = 16;
	public static final int HEIGHT = 32;
	private Vector2 position = new Vector2();

	public Block(Vector2 position) {
		this.position = position;
	}

	public Vector2 getPosition() {
		return position;
	}
	
/*	public Rectangle getBounds(){
		return bounds;
	}*/
}