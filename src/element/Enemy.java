package element;

import game.TopDownTimer;

import java.awt.image.BufferedImage;

import demo.DemoGameEngine;
import demo.DemoPlayField;

public abstract class Enemy extends Element {

	protected double healthPoint;
	public boolean show = false;
	public int time = 800;
	public TopDownTimer refireRate = new TopDownTimer(time);

	public Enemy(BufferedImage image) {
		super(image);
		this.setMass(3);
	}

	public Enemy(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
		this.setMass(3);
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

	public int getRefireRate() {
		return time;
	}
	// public abstract void death();

	public void death(BufferedImage i) {
		this.setImage(i);
	}

	public abstract void refresh(long elapsedTime);

}
