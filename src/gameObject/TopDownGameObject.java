package gameObject;

import java.awt.Graphics2D;

import state.State;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

public abstract class TopDownGameObject extends GameObject {
	protected State myState;
	public boolean levelComplete = false;
    public boolean gameOver = false;
	
	public TopDownGameObject(GameEngine parent) {
		super(parent);
	}
	
	public void setGameState(State gameState){
		myState = gameState;
	}

	public abstract void initResources();

	public abstract void render(Graphics2D g);

	public void update(long elapsedTime) {
		myState.update(elapsedTime);
		innerStateUpdate(elapsedTime);
	}

	public abstract void innerStateUpdate(long elapsedTime);

	public State getCurrentState() {
		return myState;
	}
}
