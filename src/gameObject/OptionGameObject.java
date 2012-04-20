package gameObject;

import game.TopDownGameEngine;

import java.awt.Graphics2D;
import java.util.ArrayList;


import state.State;

import com.golden.gamedev.GameObject;

public abstract class OptionGameObject extends GameObject{
	protected State myState;
	private int option;
	private ArrayList<String> options;
	
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
		innerStateUpdate(elapsedTime);
	}
	
	public State getCurrentState() {
		return myState;
	}
	
	public int getOptionNumber(){
		return options.size();
	}
	
	public void addOption(String newOption){
		options.add(newOption);
	}
	
	public void setOptionLayout(Graphics2D g,int X_pos, int Y_pos, int interval){
		int y = Y_pos;
		for(String s: options){
			fontManager.getFont("FPS Font").drawString(g, s, X_pos, y);
			y = y + interval;
		}
		
	}
	
	public void optionArrowUp(int bsInput,int key,int optionNum){
		if(bsInput == key){
			option--;
			if (option < 0)
				option = optionNum;
		}
	}
	
	public void optionArrowDown(int bsInput, int key, int optionNum){
		if(bsInput == key){
			option++;
			if (option >optionNum)
				option = 0;
		}
	}
	
	public void setFinish(int bsInput, int key){
		if(bsInput == key){
			finish();
		}
	}
	public void setState(State s){
		myState = s;
	}
	
	public int getOption(){
		return option;
	}
	
	public abstract void initResources();

	public abstract void render(Graphics2D arg0);

	public abstract void innerStateUpdate(long elapsedTime);

	public abstract void setOptionList();

}