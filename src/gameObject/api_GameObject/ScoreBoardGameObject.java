package gameObject.api_GameObject;

import java.awt.Graphics2D;
import java.util.ArrayList;

import state.api.State;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

public abstract class ScoreBoardGameObject extends GameObject{
	protected State myState;
	ArrayList<String> output;

	public ScoreBoardGameObject(GameEngine parent) {
		super(parent);
		output = new ArrayList<String>();
	}
	
	public void setGameState(State gameState) {
		myState = gameState;
	}
	
	public void addOutputContent(String s){
		output.add(s);
	}
	
	public void setOptionLayout(Graphics2D g,int X_pos, int Y_pos, int interval){
		for(String s: output){
			System.out.println(s);
		}
		
		int y = Y_pos;
		for(String s: output){
			fontManager.getFont("FPS Font").drawString(g, s, X_pos, y);
			y = y + interval;
		}
		
		
	}

	public abstract void initResources();
		//setBackground();
		//setOutputContent();
	
	
	//public abstract void setBackground();

	public abstract void render(Graphics2D arg0);
	
	//public abstract void setOutputContent();

	public void update(long arg0) {
		myState.update(arg0);
	}

}
