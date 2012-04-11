package gameObject;

/**
 * @author Jiawei Shi
 */

import java.awt.Graphics2D;

import background.TopDownImageBackground;

import com.golden.gamedev.GameEngine;

public abstract class TopDownMenuObject extends TopDownGameObject {
	protected int option;
	protected TopDownImageBackground mainMenuTitle;

	public TopDownMenuObject(GameEngine parent) {
		super(parent);
	}
	
	public void initResources(){
		setImageBackground();
	}
	
	public void render(Graphics2D g){
		mainMenuTitle.render(g);
		renderOptions(g);
		setOptionArrow(g);
	}
	
	public void optionArrowUp(int key,int optionNum){
		if(bsInput.getKeyPressed() == key){
			option--;
			if (option < 0)
				option = optionNum;
		}
	}
	
	public void optionArrowDown(int key, int optionNum){
		if(bsInput.getKeyPressed() == key){
			option++;
			if (option >optionNum)
				option = 0;
		}
	}
	
	public void setFinish(int key){
		if(bsInput.getKeyPressed() == key){
			finish();
		}
	}
	
	public int getOption(){
		return option;
	}
	

	public abstract void setImageBackground();
	
	public abstract void renderOptions(Graphics2D g);
	
	public abstract void setOptionArrow(Graphics2D g);
}
