package demo;

import java.awt.image.BufferedImage; 


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ai.BehaviorManager;
import ai.BonusLimit; // 
import ai.EnemyTopDownBehavior;
import ai.hpLimit;
import ai.ScoreLimit;
import ai.Level1;
import ai.Level2;
import ai.Level3;
import ai.Level4;
import ai.Level5;
import ai.hpLimit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import configuration.GameParameters;

import collisionSystem.LifeDecreaseCollision;

import spawn.SpawnByLocation;
import spawn.SpawnByRandom;
import util.JsonUtil;
import util.TopDownUtility;

import element.Bullet;
import element.Enemy;
import element.Missile;
import element.TopDownPlayField;
import game.Configuration;

import util.TopDownUtility;

import element.Bullet;
import element.Enemy;
import element.Fighter;
import element.TopDownPlayField;
import game.Configuration;
import gameObject.GameLevel1;
import gameObject.TopDownGameManager;
import state.*;
public class DemoEnemy extends Enemy {
	//State gameID;
	public EnemyTopDownBehavior behavior;
	EnemyTopDownBehavior oldBehavior;
	public int Level = TopDownGameManager.getCurrentGameID() - (TopDownGameManager.GAMELEVELBEGIN - 1);

	ArrayList<EnemyTopDownBehavior> behaviors = new ArrayList<EnemyTopDownBehavior>();
	double h,v,y;
	
	private boolean hpLimit = false;
	public DemoEnemy(TopDownPlayField playfield, BufferedImage image, double eNEMY_HP) {
		super(playfield, image);
		healthPoint = eNEMY_HP;
		this.mySpawnBehavior=new SpawnByRandom();
		BehaviorManager.behaviors_List(new Level1(), new Level2(),new Level3(),new Level4(),new Level5());
		BehaviorManager.BehaviorManager(this, Level);
//		System.out.print(behavior);
		behavior = this.getBehaviour();
		healthPoint = Configuration.ENEMY_HP;
	}

	public DemoEnemy(BufferedImage image) {
		super(image);
		this.mySpawnBehavior=new SpawnByRandom();
	}

	@Override
	public void init() {

		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(100, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
		setMass(3);

	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // enemy has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the enemy
				behavior.enemy_Changes(this);
				BehaviorManager.BehaviorManager(this, Level);
				y = getY();
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
				if (LifeDecreaseCollision.destroyed >= 6) {
					this.setBehavior(new ScoreLimit());
				}
				if(DemoFighter.best_weapon == true){
					this.setBehavior(new BonusLimit());
				}
				// enemy fires
				attack(elapsedTime);
			}
		} else { // for those have shown before, they should continue firing
			attack(elapsedTime);
		}
	}
	public void setBehavior(EnemyTopDownBehavior behavior){
		this.behavior = behavior;
	}
	public EnemyTopDownBehavior getBehaviour()
	{
		return behavior;
	}

	public void attack(long elapsedTime) {
		if (isActive() == true) {
			if (refireRate.action(elapsedTime)) {
				Missile enemyMissile;
				try {
					enemyMissile = new Missile(ImageIO.read(new File("images/game/emissle_easy.png")), getX()+ getWidth() / 2, getY() + 20,1);
					behavior.weapon_Changes(enemyMissile);
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

	@Override
	public Enemy clone() {
		// TODO Auto-generated method stub
		return new DemoEnemy(playfield, getImage(), healthPoint);
	}

}
