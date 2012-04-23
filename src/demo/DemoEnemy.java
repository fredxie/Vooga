
package demo;

import java.awt.image.BufferedImage; 


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import DemoGameLevel.GameLevel1;
import ai.AI;
import ai.BehaviorManager_Enemy;
import ai.BehaviorManager_Weapon;
import ai.BonusBrain_Enemy;
import ai.BonusBrain_Weapon;
import ai.BonusLimit; // 
import ai.Brain1_Enemy;
import ai.Brain1_Weapon;
import ai.Brain2_Enemy;
import ai.Brain2_Weapon;
import ai.Brain3_Enemy;
import ai.Brain3_Weapon;
import ai.Brain4_Enemy;
import ai.Brain4_Weapon;
import ai.Brain5_Enemy;
import ai.Brain5_Weapon;
import ai.EnemyTopDownBehavior;
import ai.ScoreBrain_Enemy;
import ai.ScoreBrain_Weapon;
import ai.hpBrain_Enemy;
import ai.hpBrain_Weapon;
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
import gameObject.TopDownGameManager;
import state.*;
public class DemoEnemy extends Enemy {
	//State gameID;
	public EnemyTopDownBehavior behavior;
	EnemyTopDownBehavior oldBehavior;
	public int Level = TopDownGameManager.getCurrentGameID() - (TopDownGameManager.GAMELEVELBEGIN - 1);

	ArrayList<EnemyTopDownBehavior> behaviors = new ArrayList<EnemyTopDownBehavior>();
	double h,v,y;
	AI myBrain_Enemy;
	AI oldBrain_Enemy;
	AI oldBrain_Weapon;
	AI myBrain_Weapon;
	
	private boolean hpLimit = false;
	public DemoEnemy(TopDownPlayField playfield, BufferedImage image, double eNEMY_HP) {
		super(playfield, image);
		healthPoint = eNEMY_HP;
		this.mySpawnBehavior=new SpawnByRandom();
		BehaviorManager_Enemy.behaviors_List(new Brain1_Enemy(), new Brain2_Enemy(),new Brain3_Enemy(),new Brain4_Enemy(),new Brain5_Enemy());
		BehaviorManager_Weapon.behaviors_List(new Brain1_Weapon(), new Brain2_Weapon(),new Brain3_Weapon(),new Brain4_Weapon(),new Brain5_Weapon());
		//myBrain = BehaviorManager.BehaviorManager(this, Level);
		this.setAI_Enemy();
		//behavior = this.getBehaviour();
		healthPoint = AI.ENEMY_HP;
	}

	public DemoEnemy(BufferedImage image){//, AI initialAI) {
		super(image);//, initialAI);
		this.mySpawnBehavior=new SpawnByRandom();
	}

	@Override
	public void init() {

//		this.setX(TopDownUtility.getRandom(0,
//				DemoGameEngine.WIDTH - this.getWidth()));
//		this.setY(TopDownUtility.getRandom(100, playfield.getBackground()
//				.getHeight() - DemoGameEngine.HEIGHT));
		setMass(3);

	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // enemy has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the enemy
				BehaviorManager_Enemy.BehaviorManager(this, Level);
				myBrain_Enemy.refresh(elapsedTime);
//				behavior.enemy_Changes(this);
				y = getY();
				playfield.getGroup("Enemy").add(this);
				show = true;
				oldBrain_Enemy = this.getAI_Enemy();
				if(DemoFighter.getHP() <= .5){ 
					this.setAI_Enemy(new hpBrain_Enemy());
					hpLimit = true;
				}
				if(hpLimit == true){
					if(DemoFighter.getHP() > .5){
						this.setAI_Enemy(oldBrain_Enemy);
						hpLimit = false;
					}
				}
				if (LifeDecreaseCollision.destroyed >= 6) {
					this.setAI_Enemy(new ScoreBrain_Enemy());
					oldBrain_Enemy = this.getAI_Enemy();
				}
				if(DemoFighter.best_weapon == true){
					this.setAI_Enemy(new BonusBrain_Enemy());
				}
				if(DemoFighter.best_weapon == false){
					this.setAI_Enemy(oldBrain_Enemy);
				}
//				oldBehavior = this.getBehaviour();
//				if(DemoFighter.getHP() <= .5){ 
//					this.setBehavior(new hpLimit());
//					hpLimit = true;
//				}
//				if(hpLimit == true){
//					if(DemoFighter.getHP() > .5){
//						this.setBehavior(oldBehavior);
//						hpLimit = false;
//					}
//				}
//				if (LifeDecreaseCollision.destroyed >= 6) {
//					this.setBehavior(new ScoreLimit());
//					oldBehavior = this.getBehaviour();
//				}
//				if(DemoFighter.best_weapon == true){
//					this.setBehavior(new BonusLimit());
//				}
//				if(DemoFighter.best_weapon == false){
//					this.setBehavior(oldBehavior);
//				}
				// enemy fires
				attack(elapsedTime);
			}
		} else { // for those have shown before, they should continue firing
			attack(elapsedTime);
		}
	}
//	public void setBehavior(EnemyTopDownBehavior behavior){
//		this.behavior = behavior;
//	}
//	public EnemyTopDownBehavior getBehaviour()
//	{
//		return behavior;
//	}
	public void setAI_Enemy(AI newbrain){
		this.myBrain_Enemy = newbrain;
	}
	public void setAI_Weapon(AI newbrain){
		this.myBrain_Weapon = newbrain;
	}
	public AI getAI_Enemy(){
		return myBrain_Enemy;
	}
	public AI getAI_Weapon(){
		return myBrain_Weapon;
	}
	public void setAI_Enemy(){
		AI newBrain = BehaviorManager_Enemy.BehaviorManager(this,Level);
		newBrain.setSprite(this);
		this.myBrain_Enemy = newBrain;
	}

	public void attack(long elapsedTime) {
		if (isActive() == true) {
			if (refireRate.action(elapsedTime)) {
				Missile enemyMissile;
				try {
					enemyMissile = new Missile(ImageIO.read(new File("images/game/emissle_easy.png")), getX()+ getWidth() / 2, getY() + 20,1);
					oldBrain_Weapon = getAI_Weapon();
					if(DemoFighter.getHP() <= .5){ 
						this.setAI_Weapon(new hpBrain_Weapon());
						hpLimit = true;
					}
					if(hpLimit == true){
						if(DemoFighter.getHP() > .5){
							this.setAI_Weapon(oldBrain_Weapon);
							hpLimit = false;
						}
					}
					if (LifeDecreaseCollision.destroyed >= 6) {
						this.setAI_Weapon(new ScoreBrain_Weapon());
						oldBrain_Weapon = this.getAI_Weapon();
					}
					if(DemoFighter.best_weapon == true){
						this.setAI_Weapon(new BonusBrain_Weapon());
					}
					if(DemoFighter.best_weapon == false){
						this.setAI_Weapon(oldBrain_Weapon);
					}
					AI newBrain2 = BehaviorManager_Weapon.BehaviorManager(enemyMissile,Level);
					newBrain2.setSprite(this);
					this.myBrain_Weapon = newBrain2;
					myBrain_Weapon.refresh(elapsedTime);
					BehaviorManager_Weapon.BehaviorManager(enemyMissile, Level);
//					behavior.weapon_Changes(enemyMissile);
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
		DemoEnemy DE=new DemoEnemy(playfield, getImage(), healthPoint);
		DE.init();// TODO Auto-generated method stub
		return DE;
	}

}
