package api.element;

import java.awt.image.BufferedImage;


import api.spawn.SpawnBehavior;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;

import demo.game.DemoGameEngine;

public abstract class Element extends Sprite {

	public TopDownPlayField playfield;
	public SpawnBehavior mySpawnBehavior;

	private int mass; // this is Yi Ding's revise

	public int getMass() { // this is Yi Ding's revise
		return mass;
	}

	public void setMass(int mass) { // this is Yi Ding's revise
		this.mass = mass;
	}

	public Element(BufferedImage image) {
		super(image);
	}

	public Element() {
		super();
	}

	public Element(BufferedImage image, double x, double y) {
		super(image, x, y);
	}

	public void setSpeed(double x, double y) {
		super.setSpeed(x, y);
	}

	public void setLocation(int x, int y) {
		super.setLocation(x, y);
	}

	public double getX() {
		return super.getX();
	}

	public double getY() {
		return super.getY();
	}

	public void setImage(BufferedImage image) {
		super.setImage(image);
	}

	public abstract void init();

	// public abstract void update(long elapsedTime);

	/**
	 * @author Gang Song
	 * @Description set Spawning behavior
	 */
	public void setSpawnBehavior(SpawnBehavior SB) {
		// mySpawnBehavior=new SpawnByLocation();
		mySpawnBehavior = SB;
	}

	public void spawn() {
		double[] templocation = mySpawnBehavior.spawn();

		this.setX(templocation[0] * (DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(templocation[1]
				* (playfield.getBackground().getHeight() - DemoGameEngine.HEIGHT));

		// this.playfield.getTileBackground().getWidth()
	}

	public abstract Element clone();
}