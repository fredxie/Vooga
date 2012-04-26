package demo.element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import api.ai.AI;
import api.ai.BehaviorManager;
import api.ai.BonusBrain_Enemy;
import api.ai.BonusBrain_Weapon;
import api.ai.ScoreBrain_Enemy;
import api.ai.ScoreBrain_Weapon;
import api.ai.hpBrain_Enemy;
import api.ai.hpBrain_Weapon;
import api.element.Enemy;
import api.game.TopDownPlayField;
import api.gameObject.TopDownGameManager;
import api.spawn.SpawnByRandom;
import demo.ai.Brain1_Enemy;
import demo.ai.Brain1_Weapon;
import demo.ai.Brain2_Enemy;
import demo.ai.Brain2_Weapon;
import demo.ai.Brain3_Enemy;
import demo.ai.Brain3_Weapon;
import demo.ai.Brain4_Enemy;
import demo.ai.Brain4_Weapon;
import demo.ai.Brain5_Enemy;
import demo.ai.Brain5_Weapon;
import demo.collisionSystem.LifeDecreaseCollision;
import demo.game.DemoGameEngine;

@SuppressWarnings("serial")
public class DemoEnemy extends Enemy {
	// State gameID;
	public int Level = TopDownGameManager.getCurrentGameID()
			- (TopDownGameManager.GAMELEVELBEGIN - 1);
	double h, v, y;
	AI myBrain_Enemy;
	AI oldBrain_Enemy;
	AI oldBrain_Weapon;
	AI myBrain_Weapon;

	private boolean hpLimit = false;

	public DemoEnemy(TopDownPlayField playfield, BufferedImage image,
			double eNEMY_HP) {
		super(playfield, image);
		healthPoint = eNEMY_HP;
		this.mySpawnBehavior = new SpawnByRandom();
		BehaviorManager.enemy_Map(new Brain1_Enemy(), 1);
		BehaviorManager.enemy_Map(new Brain2_Enemy(), 2);
		BehaviorManager.enemy_Map(new Brain3_Enemy(), 3);
		BehaviorManager.enemy_Map(new Brain4_Enemy(), 4);
		BehaviorManager.enemy_Map(new Brain5_Enemy(), 5);
		BehaviorManager.weapon_Map(new Brain1_Weapon(), 1);
		BehaviorManager.weapon_Map(new Brain2_Weapon(), 2);
		BehaviorManager.weapon_Map(new Brain3_Weapon(), 3);
		BehaviorManager.weapon_Map(new Brain4_Weapon(), 4);
		BehaviorManager.weapon_Map(new Brain5_Weapon(), 5);
		this.setAI_Enemy();
		myBrain_Enemy = this.getAI_Enemy();
		healthPoint = AI.ENEMY_HP;
	}

	public DemoEnemy(BufferedImage image) {
		super(image);
		this.mySpawnBehavior = new SpawnByRandom();
	}

	@Override
	public void init() {
		setMass(3);

	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // enemy has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the enemy
				BehaviorManager.eBehaviorManager(this, Level);
				myBrain_Enemy.refresh(elapsedTime);
				y = getY();
				playfield.getGroup("Enemy").add(this);
				show = true;
				oldBrain_Enemy = this.getAI_Enemy();
				if (DemoFighter.getHP() <= .5) {
					this.setAI_Enemy(new hpBrain_Enemy());
					hpLimit = true;
				}
				if (hpLimit == true) {
					if (DemoFighter.getHP() > .5) {
						this.setAI_Enemy(oldBrain_Enemy);
						hpLimit = false;
					}
				}
				if (LifeDecreaseCollision.destroyed >= 6) {
					this.setAI_Enemy(new ScoreBrain_Enemy());
					oldBrain_Enemy = this.getAI_Enemy();
				}
				if (DemoFighter.best_weapon == true) {
					this.setAI_Enemy(new BonusBrain_Enemy());
				}
				if (DemoFighter.best_weapon == false) {
					this.setAI_Enemy(oldBrain_Enemy);
				}
				attack(elapsedTime);
			}
		} else { // for those have shown before, they should continue firing
			attack(elapsedTime);
		}
	}

	public void attack(long elapsedTime) {
		if (isActive() == true) {
			if (refireRate.action(elapsedTime)) {
				Missile enemyMissile;
				try {
					enemyMissile = new Missile(ImageIO.read(new File("images/game/emissle_easy.png")), getX()+ getWidth() / 2, getY() + 20, 1);
					enemyMissile.setAI_Weapon();
					myBrain_Weapon = enemyMissile.getAI_Weapon();
					myBrain_Weapon.refresh(elapsedTime);
					BehaviorManager.wBehaviorManager(enemyMissile, Level);
					oldBrain_Weapon = enemyMissile.getAI_Weapon();
					if (DemoFighter.getHP() <= .5) {
						enemyMissile.setAI_Weapon(new hpBrain_Weapon());
						hpLimit = true;
					}
					if (hpLimit == true) {
						if (DemoFighter.getHP() > .5) {
							enemyMissile.setAI_Weapon(oldBrain_Weapon);
							hpLimit = false;
						}
					}
					if (LifeDecreaseCollision.destroyed >= 6) {
						enemyMissile.setAI_Weapon(new ScoreBrain_Weapon());
						oldBrain_Weapon = enemyMissile.getAI_Weapon();
					}
					if (DemoFighter.best_weapon == true) {
						enemyMissile.setAI_Weapon(new BonusBrain_Weapon());
					}
					if (DemoFighter.best_weapon == false) {
						enemyMissile.setAI_Weapon(oldBrain_Weapon);
					}
					playfield.getGroup("Enemy Missile").add(enemyMissile);
					refireRate.refresh();
					if (Level >= 5) {
						if (enemyMissile.getX() <= 0
								|| enemyMissile.getX() >= DemoGameEngine.WIDTH
										- ((enemyMissile.getWidth()))) {
							double h2 = enemyMissile.getHorizontalSpeed();
							double v2 = enemyMissile.getVerticalSpeed();
							enemyMissile.setSpeed(-h2, v2);
						}
					} else if (Level > 5) {
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
		DemoEnemy DE = new DemoEnemy(playfield, getImage(), healthPoint);
		DE.init();// TODO Auto-generated method stub
		return DE;
	}

}
