package gameObject;

import game.Configuration;
import game.TopDownGameEngine;
import game.TopDownTimer;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import keyconfiguration.KeyConfig;
import spawn.ElementSpawner;
import spawn.SpawnByRandom;
import spawn.SpawnByTime;
import state.Level2State;
import util.JsonUtil;
import util.TopDownImageUtil;
import collisionSystem.BonusCollision;
import collisionSystem.CollisionManager;
import collisionSystem.ImageCollision;
import collisionSystem.LifeDecreaseCollision;
import collisionSystem.SoundCollision;
import configuration.GameParameters;
import demo.DemoBlock;
import demo.DemoBonus;
import demo.DemoEnemy;
import demo.DemoFighter;
import demo.DemoGameEngine;
import demo.DemoPlayField;
import element.Block;
import element.Bonus;
import element.Enemy;

public class GameLevel2 extends GameLevel {
	private int enemyNum = JsonUtil.parse("paraConfig.json").get(GameParameters.ENEMY_NUM);
	private int bonusNum = JsonUtil.parse("paraConfig.json").get(GameParameters.BONUS_NUM);
	private int blockNum = JsonUtil.parse("paraConfig.json").get(GameParameters.BLOCK_NUM);
	private KeyConfig keyConfig;
	private CollisionManager manager;

	public static TopDownTimer timer = new TopDownTimer(3000);
	private DemoPlayField playfield = new DemoPlayField(this);
	private DemoFighter fighter = new DemoFighter(
			TopDownImageUtil.getImage("images/game/fighter.png"));
	private List<Enemy> juniorEnemies = new ArrayList<Enemy>(); // Use Arraylist instead of enemies, by Gang
	private List<Bonus> bonuses = new ArrayList<Bonus>();
	private List<Block> blocks = new ArrayList<Block>();
	private ElementSpawner<Enemy> ES;
	private ElementSpawner<Bonus> bonusSpawner1;
	private ElementSpawner<Block> blockSpawner1;
    private ElementSpawner<Block> blockSpawner2;
	
	public GameLevel2(TopDownGameEngine parent) {
		super(parent);

        myState = new Level2State(parent, this);
	}

	public void initResources() {
		LifeDecreaseCollision.destroyed = 0;

		playfield.init("images/game/background.png");
		
		manager = new CollisionManager(playfield);
		manager.registerCollision("Fighter", "Enemy Missile", new SoundCollision(playfield,"sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Enemy Missile", new ImageCollision(playfield,"images/game/explosion.png"));
		manager.registerCollision("Fighter", "Enemy Missile", new LifeDecreaseCollision());
		manager.registerCollision("Fighter", "Enemy", new SoundCollision(playfield,"sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Enemy", new ImageCollision(playfield,"images/game/explosion.png"));
		manager.registerCollision("Fighter", "Enemy", new LifeDecreaseCollision());
		manager.registerCollision("Enemy", "Fighter Bullet",new SoundCollision(playfield,"sounds/explosion.wav"));
		manager.registerCollision("Enemy", "Fighter Bullet",new ImageCollision(playfield,"images/game/explosion.png"));
		manager.registerCollision("Enemy", "Fighter Bullet", new LifeDecreaseCollision());
		manager.registerCollision("Fighter", "Bonus", new SoundCollision(playfield,"sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Bonus", new BonusCollision());
		manager.registerCollision("Fighter", "Block", new SoundCollision(playfield,"sounds/explosion.wav"));
		manager.registerCollision("Fighter", "Block", new ImageCollision(playfield,"images/game/explosion.png"));
		manager.registerCollision("Fighter", "Block", new LifeDecreaseCollision());
		manager.registerCollision("Block", "Fighter Bullet",new SoundCollision(playfield,"sounds/explosion.wav"));
		manager.registerCollision("Block", "Fighter Bullet",new ImageCollision(playfield,"images/game/explosion.png"));
		manager.registerCollision("Block", "Fighter Bullet",new LifeDecreaseCollision());
		
		// use Element spawner to spawn most of the elements in the game
		blockSpawner1=new ElementSpawner<Block>(new SpawnByRandom(), new DemoBlock(playfield,
						getImage("images/game/block2.png"), 3), blockNum/3);
		blockSpawner2=new ElementSpawner<Block>(new SpawnByRandom(),  new DemoBlock(playfield,
				getImage("images/game/block.png")), 2*blockNum/3);
		blocks.addAll(blockSpawner1.spawn());
		blocks.addAll(blockSpawner2.spawn());

		fighter.setPlayfield(playfield);
		fighter.setGameObject(this);
		fighter.init();

		//Use enemy spawner to spawn enemies, please do not change it to original spawning method
		//In this level, enemies are spawned by random
		ES = new ElementSpawner<Enemy>(new SpawnByRandom(), new DemoEnemy(
				playfield, getImage("images/game/enemy_easy.png"),
				Configuration.ENEMY_HP), enemyNum);
		juniorEnemies.addAll(ES.spawn());

		//to Element spawner to spawn most of the elements in the game
		bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus(playfield,
				getImage("images/game/bonus.png")),  bonusNum );
		bonuses.addAll(bonusSpawner1.spawn());

		keyConfig = new KeyConfig(fighter, this);
		keyConfig.parseKeyConfig("keyConfig.json");
		fighter.setKeyList(keyConfig.getKeyList());

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

		for (int i = 0; i < bonuses.size(); i++) {
			bonuses.get(i).refresh(elapsedTime);
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
				"ENEMIES DESTROYED   " + LifeDecreaseCollision.destroyed,
				20, 30);
	}

	public void betweenLevelsRender(Graphics2D g, int nextLevelNum) {
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED   " + LifeDecreaseCollision.destroyed,
				20, DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g, "MISSION COMPLETE!   ",
				20, DemoGameEngine.HEIGHT / 2);
		fontManager.getFont("FPS Font").drawString(g,
				"COMING: LEVEL" + " " + nextLevelNum + "       ", 20,
				DemoGameEngine.HEIGHT / 2 + 50);
	}

}
