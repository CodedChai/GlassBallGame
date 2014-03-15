package com.me.GBG;

import com.badlogic.gdx.math.Rectangle;

public class FinishLine {

	private Rectangle bounds;

	public FinishLine(int x, int y, int width, int height) {
		bounds = new Rectangle(x, y, width, height);
	}

	public Rectangle getBounds() {
		return bounds;
	}
}