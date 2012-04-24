package gameObject.api_GameObject;

import game.TopDownGameEngine;

import java.awt.Graphics2D;

import state.api.State;

import com.golden.gamedev.GameObject;

public abstract class TopDownGameObject extends GameObject {
	protected State myState;
	private int option;
	public boolean levelComplete = false;

	public TopDownGameObject(TopDownGameEngine parent) {
		super(parent);
	}

	public void setGameState(State gameState) {
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

	public void optionArrowUp(int bsInput, int key, int optionNum) {
		if (bsInput == key) {
			option--;
			if (option < 0)
				option = optionNum;
		}
	}

	public void optionArrowDown(int bsInput, int key, int optionNum) {
		if (bsInput == key) {
			option++;
			if (option > optionNum)
				option = 0;
		}
	}

	public void setFinish(int bsInput, int key) {
		if (bsInput == key) {
			finish();
		}
	}

	public int getOption() {
		return option;
	}
}
