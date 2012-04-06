package element;


import game.TopDownTimer;

import java.awt.image.BufferedImage;


import demo.DemoGameEngine;
import demo.DemoPlayField;


public abstract class Enemy extends Element{
	
	protected int healthPoint;
	public boolean show = false;
	public TopDownTimer refireRate = new TopDownTimer(800);
	
	public SpawnBehavior mySpawnBehavior;
	

	public Enemy(BufferedImage image){
		super(image);
	}
	
	public Enemy(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
	}
	
	public abstract void attack(long elapsedTime);
	
	public void setHP(int healthPoint){
		this.healthPoint = healthPoint;
	}
	
	public int getHP(){
		return healthPoint;
	}
	
	public void setRefireRate(int rate) {
		refireRate = new TopDownTimer(rate);
	}
	
//	public abstract void death();
	
	
	/**
	 * @author Gang Song
	 * @Description set Spawning behavior
	 */
	public void setSpawnBehavior(SpawnBehavior SB){
		//mySpawnBehavior=new SpawnByLocation();
		mySpawnBehavior=SB;
	}
	
	public void spawn(int k){
		double[] templocation=mySpawnBehavior.spawn(k);
		
		this.setX(templocation[0]*(DemoGameEngine.WIDTH- this.getWidth()));
		this.setY(templocation[1]*(playfield.getBackground().getHeight()- DemoGameEngine.HEIGHT));
		
		//this.playfield.getTileBackground().getWidth()
	}
	
	
	public void death(BufferedImage i){
		this.setImage(i);
	}
	
	public abstract void refresh(long elapsedTime);
	
}
