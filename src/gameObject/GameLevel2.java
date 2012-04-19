package gameObject;

import game.Configuration;
import game.TopDownGameEngine;
import game.TopDownTimer;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import spawn.EnemySpawner;
import spawn.SpawnByRandom;
import state.DefaultLastLevelState;
import util.JsonUtil;
import util.TopDownImageUtil;
import collisionSystem.BonusCollision;
import collisionSystem.CollisionManager;
import collisionSystem.ImageCollision;
import collisionSystem.LifeDecreaseCollision;
import collisionSystem.SoundCollision;
import configuration.GameParameters;
import configuration.KeyPressedSubject;
import demo.DemoBlock;
import demo.DemoBonus;
import demo.DemoEnemy;
import demo.DemoFighter;
import demo.DemoGameEngine;
import demo.DemoPlayField;
import element.Enemy;

public class GameLevel2 extends GameLevel {
	private int enemyNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.ENEMY_NUM);
	private int bonusNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BONUS_NUM);
	private int blockNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BLOCK_NUM);
	private CollisionManager manager;

	public static TopDownTimer timer = new TopDownTimer(3000);
	private DemoPlayField playfield = new DemoPlayField(this);
	private DemoFighter fighter = new DemoFighter(
			TopDownImageUtil.getImage("images/game/fighter.png"));
	private List<Enemy> juniorEnemies = new ArrayList<Enemy>(); // Use Arraylist
																// instead of
																// enemies, by
																// Gang
	private DemoBonus[] bonuses = new DemoBonus[bonusNum];
	private DemoBlock[] blocks = new DemoBlock[blockNum];
	private EnemySpawner ES;

	public GameLevel2(TopDownGameEngine parent) {
		super(parent);

		myState = new DefaultLastLevelState(parent, this);
	}

	public void initResources() {
		LifeDecreaseCollision.destroyed = 0;

		playfield.init("images/game/background.png");

		manager = new CollisionManager(playfield);
		manager.registerCollision("Fighter", "Enemy Missile",
				new SoundCollision(playfield, "sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Enemy Missile",
				new ImageCollision(playfield, "images/game/explosion.png"));
		manager.registerCollision("Fighter", "Enemy Missile",
				new LifeDecreaseCollision());
		manager.registerCollision("Fighter", "Enemy", new SoundCollision(
				playfield, "sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Enemy", new ImageCollision(
				playfield, "images/game/explosion.png"));
		manager.registerCollision("Fighter", "Enemy",
				new LifeDecreaseCollision());
		manager.registerCollision("Enemy", "Fighter Bullet",
				new SoundCollision(playfield, "sounds/explosion.wav"));
		manager.registerCollision("Enemy", "Fighter Bullet",
				new ImageCollision(playfield, "images/game/explosion.png"));
		manager.registerCollision("Enemy", "Fighter Bullet",
				new LifeDecreaseCollision());
		manager.registerCollision("Fighter", "Bonus", new SoundCollision(
				playfield, "sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Bonus", new BonusCollision());
		manager.registerCollision("Fighter", "Block", new SoundCollision(
				playfield, "sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Block", new ImageCollision(
				playfield, "images/game/explosion.png"));
		manager.registerCollision("Fighter", "Block",
				new LifeDecreaseCollision());
		manager.registerCollision("Block", "Fighter Bullet",
				new SoundCollision(playfield, "sounds/explosion.wav"));
		manager.registerCollision("Block", "Fighter Bullet",
				new ImageCollision(playfield, "images/game/explosion.png"));
		manager.registerCollision("Block", "Fighter Bullet",
				new LifeDecreaseCollision());

		for (int i = 0; i < blockNum; i++) {
			int j = getRandom(0, 30);
			if (j <= 10)
				blocks[i] = new DemoBlock(playfield,
						getImage("images/game/block2.png"), 3);
			else
				blocks[i] = new DemoBlock(playfield,
						getImage("images/game/block.png"));
			blocks[i].init();
		}

		fighter.setPlayfield(playfield);
		fighter.setGameObject(this);
		fighter.init();

		// Use enemy spawner to spawn enemies, please do not change it to
		// original spawning method
		// In this level, enemies are spawned by random
		ES = new EnemySpawner(new SpawnByRandom(),
				new DemoEnemy(playfield,
						getImage("images/game/enemy_easy.png"),
						Configuration.ENEMY_HP), enemyNum);
		juniorEnemies.addAll(ES.spawn());

		for (int i = 0; i < bonusNum; i++) {
			bonuses[i] = new DemoBonus(playfield,
					getImage("images/game/bonus.png"));
			bonuses[i].init();
		}
		fighter.setKeyList(JsonUtil.createKeyList(fighter, "keyConfig.json",
				this));

	}

	@Override
	public void render(Graphics2D g) {
		playfield.render(g);
		if (levelComplete) {
			playfield.clearPlayField();
			betweenLevelsRender(g, 3);
		}

		else if (gameOver) {
			playfield.clearPlayField();
			gameOverRender(g);
		} else {
			gameRender(g, "BEAT DOWN 20 ENEMIES ");

		}

	}

	@Override
	public void innerStateUpdate(long elapsedTime) {
		playfield.update(elapsedTime);

		fighter.refresh(elapsedTime);

		KeyPressedSubject.getInstance().notifyObservers(elapsedTime);

		fighter.bomb(elapsedTime);
		// update Enemies
		for (int i = 0; i < juniorEnemies.size(); i++) {
			juniorEnemies.get(i).refresh(elapsedTime);
			double h = juniorEnemies.get(i).getHorizontalSpeed();
			double v = juniorEnemies.get(i).getVerticalSpeed();
			if (juniorEnemies.get(i).getX() <= 0
					|| juniorEnemies.get(i).getX() >= DemoGameEngine.WIDTH
							- ((juniorEnemies.get(i).getWidth()))) {
				juniorEnemies.get(i).setSpeed(-h, v);
			}
		}
		for (int i = 0; i < juniorEnemies.size(); i++) {
			juniorEnemies.get(i).refresh(elapsedTime);
		}

		for (int i = 0; i < bonusNum; i++) {
			bonuses[i].refresh(elapsedTime);
		}

		if (fighter.getLifeNum() == 0) {
			gameOver = true;
		}
	}

	public boolean levelComplete() {
		if (LifeDecreaseCollision.destroyed >= 20) {
			levelComplete = true;
		}
		return levelComplete;
	}

	public void gameRender(Graphics2D g, String levelRequirement) {
		fontManager.getFont("FPS Font").drawString(g, levelRequirement, 20, 15);
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED " + LifeDecreaseCollision.destroyed, 20, 30);
	}

	public void betweenLevelsRender(Graphics2D g, int nextLevelNum) {
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED " + LifeDecreaseCollision.destroyed, 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g, "MISSION COMPLETE! ", 20,
				DemoGameEngine.HEIGHT / 2);
		fontManager.getFont("FPS Font").drawString(g,
				"COMING: LEVEL" + " " + nextLevelNum + " ", 20,
				DemoGameEngine.HEIGHT / 2 + 50);
	}

}