package gameObject.api_GameObject;


import game.TopDownGameEngine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import state.api_State.State;

import com.golden.gamedev.GameObject;

import configuration.GameParameters;
import configuration.Key;
import configuration.KeyAnnotation;
import configuration.SystemKeyPressedObserver;

public abstract class OptionGameObject extends GameObject {
	protected State myState;
	public int option;
	public ArrayList<String> options;
	
	public OptionGameObject(TopDownGameEngine parent) {
		super(parent);
		options = new ArrayList<String>();
		setOptionList();
	}

	public void setGameState(State gameState) {
		myState = gameState;
	}

	public void update(long elapsedTime) {
		myState.update(elapsedTime);
		setFinish(bsInput.getKeyPressed(), KeyEvent.VK_ESCAPE);
	}

	public State getCurrentState() {
		return myState;
	}

	public int getOptionNumber() {
		return options.size();
	}

	public void addOption(String newOption) {
		options.add(newOption);
	}

	public void setOptionLayout(Graphics2D g, int X_pos, int Y_pos, int interval) {
		int y = Y_pos;
		for (String s : options) {
			fontManager.getFont("FPS Font").drawString(g, s, X_pos, y);
			y = y + interval;
		}

	}

	@KeyAnnotation(action = GameParameters.SystemUp)
	public void optionArrowUp(long elapsedTime) {
		option--;
		if (option < 0)
			option = options.size() - 1;
	}

	@KeyAnnotation(action = GameParameters.SystemDown)
	public void optionArrowDown(long elapsedTime) {
		option++;
		if (option > options.size() - 1)
			option = 0;
	}

	public void setFinish(int bsInput, int key) {
		if (bsInput == key) {
			finish();
		}
	}

	public void setState(State s) {
		myState = s;
	}

	public int getOption() {
		return option;
	}

	public abstract void initResources();

	public abstract void render(Graphics2D arg0);

	public abstract void setOptionList();

}
