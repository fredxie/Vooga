package element;

import game.TopDownTimer;

import java.awt.image.BufferedImage;

import spawn.SpawnBehavior;

import demo.DemoGameEngine;
import demo.DemoPlayField;

public abstract class Enemy extends Element {

	protected double healthPoint;
	public boolean show = false;

	public SpawnBehavior mySpawnBehavior;
	public int time = 800;
	public TopDownTimer refireRate = new TopDownTimer(time);

	public Enemy(BufferedImage image) {
		super(image);
	}

	public Enemy(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
	}

	public abstract void attack(long elapsedTime);

	public void setHP(double h) {
		this.healthPoint = h;
	}

	public double getHP() {
		return healthPoint;
	}

	public void setRefireRate(int rate) {
		refireRate = new TopDownTimer(rate);
	}

	/**
	 * @author Gang Song
	 * @Description set Spawning behavior
	 */
	public void setSpawnBehavior(SpawnBehavior SB){
		//mySpawnBehavior=new SpawnByLocation();
		mySpawnBehavior=SB;
	}

	public void spawn(){
		double[] templocation=mySpawnBehavior.spawn();

		this.setX(templocation[0]*(DemoGameEngine.WIDTH- this.getWidth()));
		this.setY(templocation[1]*(playfield.getBackground().getHeight()- DemoGameEngine.HEIGHT));

		//this.playfield.getTileBackground().getWidth()
	}

	//To clone the same kind of enemy
	public abstract Enemy clone();

	public int getRefireRate() {
		return time;
	}
	// public abstract void death();

	public void death(BufferedImage i) {
		this.setImage(i);
	}

	public abstract void refresh(long elapsedTime);

}