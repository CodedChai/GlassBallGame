package com.me.GBG;

import com.badlogic.gdx.Game;  
public class GlassBallGame extends Game {  
    GameScreen gameScreen;  
    @Override  
    public void create() {  
        gameScreen = new GameScreen(this);  
        setScreen(gameScreen);  
    }  
    public GlassBallGame(){
    	
    }
}  