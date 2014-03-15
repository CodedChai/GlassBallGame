package com.me.GBG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Circle {
	public static final int WIDTH = 16;
	public static final int HEIGHT = 16;
	public static final Vector2 MAXVELOCITY = new Vector2(0, 500);
	public static final Vector2 MINVELOCITY = new Vector2(0, 20);
	public static final Vector2 ACCELERATION = new Vector2(0, 40);
	public static final Vector2 DECELERATION = new Vector2(0, -120);

	private Vector2 position = new Vector2();
	private Vector2 velocity = new Vector2();
	private Rectangle bounds;
	private Boolean decelerating;

	public Circle(Vector2 position) {
		this.position = position;
		this.velocity.set(0, 0);
		this.bounds = new Rectangle(position.x, position.y, WIDTH, HEIGHT);
		this.decelerating = false;
	}

	public void update(float deltaTime) {
		if (!decelerating) {
			if (velocity.y < MAXVELOCITY.y) {
				velocity.add(ACCELERATION.x * deltaTime, ACCELERATION.y * deltaTime);
			}
		}
		if (decelerating) {
			if (velocity.y > MINVELOCITY.y) {
				velocity.add(DECELERATION.x * deltaTime, DECELERATION.y * deltaTime);
			}
		}
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.set(position.x, position.y, WIDTH, HEIGHT);
		decelerating = false;
	}
	public void steerCircle (float deltaTime, float moveCircle) {
		velocity.x = moveCircle;
		update(deltaTime);
	}
	
	public void contactWall(){
		decelerating = true;
	}
	
	public void contactFinish(){
		decelerating = true;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void hitBlock() {
		   velocity.set(0, -20);
		}
	
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	
}