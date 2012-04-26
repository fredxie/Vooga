package api.element;


import java.awt.image.BufferedImage;

import api.ai.AI;
import api.ai.BehaviorManager;
import api.game.TopDownPlayField;
import api.game.TopDownTimer;
import api.gameObject.TopDownGameManager;
import api.spawn.SpawnBehavior;
import demo.game.DemoGameEngine;

@SuppressWarnings("serial")
public abstract class Enemy extends Element {

	protected double healthPoint;
	public boolean show = false;

	public SpawnBehavior mySpawnBehavior;
	public int time = 800;
	public TopDownTimer refireRate = new TopDownTimer(time);
	AI myBrain_Enemy;
	public int Level = TopDownGameManager.getCurrentGameID()
			- (TopDownGameManager.GAMELEVELBEGIN - 1);

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
	public void setSpawnBehavior(SpawnBehavior SB) {
		// mySpawnBehavior=new SpawnByLocation();
		mySpawnBehavior = SB;
	}

	public void spawn(SpawnBehavior sb) {
		double[] templocation = sb.spawn();

		this.setX(templocation[0] * (DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(templocation[1]
				* (playfield.getBackground().getHeight() - DemoGameEngine.HEIGHT));

		// this.playfield.getTileBackground().getWidth()
	}

	// To clone the same kind of enemy
	public abstract Enemy clone();

	public int getRefireRate() {
		return time;
	}

	// public abstract void death();

	public void death(BufferedImage i) {
		this.setImage(i);
	}

	public abstract void refresh(long elapsedTime);
	
	public AI getAI_Enemy() {
		return myBrain_Enemy;
	}

	public void setAI_Enemy() {
		AI newBrain = BehaviorManager.eBehaviorManager(this, Level);
		newBrain.setSprite(this);
		this.myBrain_Enemy = newBrain;
	}

	public void setAI_Enemy(AI newbrain) {
		this.myBrain_Enemy = newbrain;
	}
}