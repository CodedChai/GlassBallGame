package com.me.GBG;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Level {
	private Circle circle;
	private Array<Block> blocks;
	private Random randomGenerator = new Random();
	private int levelHeight, levelWidth, pathWidth, pathOffset;
	private int[][] levelLayout;

	public Level(int levelHeight, int levelWidth, int pathWidth, int pathOffset) {
		blocks = new Array<Block>();
		generateLayout(levelHeight, levelWidth, pathWidth, pathOffset);
		translateLayout();
		circle = new Circle(new Vector2((GameScreen.WIDTH / 2)
				- (Circle.WIDTH / 2), 0));
	}

	private void generateLayout(int levelHeight, int levelWidth, int pathWidth,
			int pathOffset) {
		this.levelHeight = levelHeight;
		this.levelWidth = levelWidth;
		this.pathWidth = pathWidth;
		this.pathOffset = pathOffset;
		this.levelLayout = new int[levelHeight][levelWidth];
		for (int row = 0; row < levelLayout.length; row++) {
			for (int col = 0; col < levelLayout.length; col++) {
				if ((col < pathOffset) || (col >= pathOffset + pathWidth)) {
					levelLayout[row][col] = '0';
				}
			}
			int stepModifier = (randomGenerator.nextInt(3) - 1);
			if ((pathOffset + stepModifier >= 0)
					&& (pathOffset + stepModifier + pathWidth < levelWidth)) {
				pathOffset += stepModifier;
			}
		}
	}
	
	private void translateLayout() {
		for (int row = 0; row < levelLayout.length; row++){
			for (int col = 0; col < levelLayout[row].length; col++){
				if(levelLayout[row][col] == '0'){
					Block wall = new Block(new Vector2(col*Block.WIDTH, -row*Block.HEIGHT));
					blocks.add(wall);
				}
			}
		}
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public Array<Block> getBlocks() {
		return blocks;
	}

}
