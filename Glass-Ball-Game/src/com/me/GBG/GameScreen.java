package com.me.GBG;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	private GlassBallGame game;
	private Circle circle;
	private Array<Block> blocks;
	private OrthographicCamera cam;
	private Texture circleTexture;
	private Texture wallTexture;
	private Texture progressIndicatorTextureRegion;
	private SpriteBatch spriteBatch;
    private SpriteBatch hudSpriteBatch;
	private Level level;
	private BitmapFont hudTimeFont;

	public GameScreen(GlassBallGame game) {
		// create an instance of the game
		this.game = game;
		// set-up/link textures
		circleTexture = new Texture(Gdx.files.internal("data/ball.png"));
		wallTexture = new Texture(Gdx.files.internal("data/wall.png"));
		// create the environment
		createLevel();
		// create a camera that will show the entire screen
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		// position the camera in the middle of the screen and 100 pixels below
		// the ball and no z-axis
		cam.position.set(WIDTH / 2, circle.getPosition().y - 100, 0);
		// handle all of the sprites
		spriteBatch = new SpriteBatch();
	}

	private void createLevel() {
		// create and add the circle to the level
		circle = new Circle(new Vector2((WIDTH / 2) - (Circle.WIDTH / 2), 0));
		// create an array that holds all of the wall objects
		blocks = new Array<Block>();
		// level generation algorithm soon but for now a bunch of blocks
		addBlock(new Vector2(0, 32));
		addBlock(new Vector2(16, 32));
		addBlock(new Vector2(224, -448));
	}

	private void addBlock(Vector2 position) {
		Block block = new Block(position);
		blocks.add(block);
	}

	public void render(float delta) {
		handleInput();
		// user input moves the ball/circle so update according to change in
		// time so its same on different devices
		circle.update(delta);
		// update the camera with the circle/ball
		cam.position.set(WIDTH / 2, circle.getPosition().y - 100, 0);
		// clear screen
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		// call cam.update to update the camera changes
		cam.update();
		// set projection and model view matrix after the update
		cam.apply(Gdx.gl10);
		// setProjectionMatrix before drawing sprites
		spriteBatch.setProjectionMatrix(cam.combined);
		spriteBatch.begin();
		for(Block wall: blocks){
			spriteBatch.draw(wallTexture, wall.getPosition().x, wall.getPosition().y, Block.WIDTH, Block.HEIGHT);
		}
		spriteBatch.draw(circleTexture, circle.getPosition().x, circle.getPosition().y, Circle.WIDTH, Circle.HEIGHT);
		spriteBatch.end();
	}
	
	private void handleInput(){
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			circle.setVelocity(new Vector2(0, -100));
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			circle.setVelocity(new Vector2(0, 100));
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			circle.setVelocity(new Vector2(-100, 0));
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			circle.setVelocity(new Vector2(100, 0));
		}
	    if   
	     (!(Gdx.input.isKeyPressed(Input.Keys.UP))&&!(Gdx.input.isKeyPressed(Input.Keys.DOWN))&&!(Gdx.input.isKeyPressed(Input.Keys.LEFT))&&!(Gdx.input.isKeyPressed(Input.Keys.RIGHT)))  
	     {  
	         circle.setVelocity(new Vector2(0, 0));  
	     } 
	}
	
/*	private void checkCollisions() {
		   int numBlocks = level.getBlocks().size;
		   for (int i = 0; i < numBlocks; i++) {
		      Block block = level.getBlocks().get(i);
      if (block.getBounds().overlaps(level.getCircle().getBounds())) {
	         level.getCircle().hitBlock();
		      }
		   }
		}*/

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
