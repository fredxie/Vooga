package demo;

import java.awt.image.BufferedImage; 


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ai.BonusLimit; // 
import ai.hpLimit;
import ai.ScoreLimit;
import ai.Level1;
import ai.Level2;
import ai.Level3;
import ai.Level4;
import ai.Level5;
import ai.hpLimit;
import ai.TopDownBehavior;
import demoState.GameLevel1State;
import demoState.State;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import util.TopDownUtility;

import element.Bullet;
import element.Enemy;
import element.Missile;
import element.SpawnByLocation;
import element.TopDownPlayField;
import game.Configuration;

import util.TopDownUtility;

import element.Bullet;
import element.Enemy;
import element.Fighter;
import element.TopDownPlayField;
import game.Configuration;

public class DemoEnemy extends Enemy {
	//State gameID;
	public TopDownBehavior behavior;
	TopDownBehavior oldBehavior;
	public double Level = GameLevel1State.getLevel();
	ArrayList<TopDownBehavior> behaviors = new ArrayList<TopDownBehavior>();
	double h,v,y;
	
	private boolean hpLimit = false;
	public DemoEnemy(TopDownPlayField playfield, BufferedImage image, double eNEMY_HP) {
		super(playfield, image);
//		healthPoint = eNEMY_HP;
		this.mySpawnBehavior=new SpawnByLocation();
		behaviors.add(new Level1());
		behaviors.add(new Level2());
		behaviors.add(new Level3());
		behaviors.add(new Level4());
		behaviors.add(new Level5());
//		for( TopDownBehavior level : behaviors){
//			if(Level <= 5){
//				if (Level == level.getState()){
//					this.setBehavior(level);
//				}
//				else{
//					this.setBehavior(new Level1());
//				}
//			}
//			else if (Level > 5){ 
//				h = this.getHorizontalSpeed();
//				v = this.getVerticalSpeed();
//				this.setSpeed(h + .05, v + .03);
//			}
//		}
		if(Level == 1){
			this.setBehavior(new Level5()); 
		}
		else if (Level == 2){ 
			this.setBehavior(new Level2());
		}
		else{
			this.setBehavior(new Level1());
		}
		healthPoint = behavior.enemyHP();
		// TODO Auto-generated constructor stub
	}

	public DemoEnemy(BufferedImage image) {
		super(image);
		this.mySpawnBehavior=new SpawnByLocation();
	}

	@Override
	public void init() {

		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(100, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // enemy has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the enemy
				behavior.movement(this);
				y = getY();
//				double h = this.getHorizontalSpeed();
//				double v = this.getVerticalSpeed();
//				behavior.enemyHP(this);
				behavior.fireRate(this);
				playfield.getGroup("Enemy").add(this);
				show = true;
				oldBehavior = this.getBehaviour();
				if(DemoFighter.getHP() <= .5){ 
					this.setBehavior(new hpLimit());
					hpLimit = true;
				}
				if(hpLimit == true){
					if(DemoFighter.getHP() > .5){
						this.setBehavior(oldBehavior);
						hpLimit = false;
					}
				}
				// enemy fires
				attack(elapsedTime);
			}
		} else { // for those have shown before, they should continue firing
			attack(elapsedTime);
		}
	}
	public void setBehavior(TopDownBehavior behavior){
		this.behavior = behavior;
	}
	public TopDownBehavior getBehaviour()
	{
		return behavior;
	}

	public void attack(long elapsedTime) {
//		if( y > 0 || y < DemoGameEngine.HEIGHT)
//		{
			if (isActive() == true) {
				if (refireRate.action(elapsedTime)) {
					Missile enemyMissile;
					try {
						enemyMissile = new Missile(ImageIO.read(new File("images/game/emissle_easy.png")), getX()+ getWidth() / 2, getY() + 20,behavior.enemyDamage());
						behavior.weaponSpeed(enemyMissile);
						playfield.getGroup("Enemy Missile").add(enemyMissile);
						refireRate.refresh();
						if(Level >= 5 ){
							if(enemyMissile.getX() <= 0 || enemyMissile.getX() >= DemoGameEngine.WIDTH-((enemyMissile.getWidth()))){     
								//behavior.weaponSpeed(enemyMissile);
								double h2 = enemyMissile.getHorizontalSpeed();
								double v2 = enemyMissile.getVerticalSpeed();
								enemyMissile.setSpeed(-h2, v2);	
							}
						}
						else if (Level > 5){
							double h2 = enemyMissile.getHorizontalSpeed();
							double v2 = enemyMissile.getVerticalSpeed();
							enemyMissile.setSpeed(h2 + .02, v2 + .02);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
//	}

}
