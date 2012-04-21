
package gameObject;

import game.Configuration;
import game.TopDownGameEngine;
import game.TopDownTimer;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import playerState.AssistanceState;

import keyconfiguration.KeyConfig;
import spawn.ElementSpawner;
import spawn.SpawnByRandom;
import spawn.SpawnByTime;
import state.DefaultLevelState;
import util.JsonUtil;
import util.TopDownImageUtil;
import collisionSystem.BlockBulletCollision;
import collisionSystem.BonusCollision;
import collisionSystem.CollisionManager;
import collisionSystem.EnemyBulletCollision;
import collisionSystem.FighterBulletCollision;
import collisionSystem.FighterEnemyOrBlockCollision;
import collisionSystem.ImageCollision;
import collisionSystem.InActiveCollision;
import collisionSystem.LifeDecreaseCollision;
import collisionSystem.PhysicCollision;
import collisionSystem.SoundCollision;
import configuration.GameParameters;
import configuration.KeyPressedSubject;
import demo.DemoBlock;
import demo.DemoBonus1;
import demo.DemoCannonBlock;
import demo.DemoEnemy;
import demo.DemoFighter;
import demo.DemoGameEngine;
import demo.DemoPlayField;
import demo.DemoProtection;
import demo.DemoSatellite;
import element.Block;
import element.Bonus;
import element.Enemy;

public class GameLevel1 extends GameLevel {
	private int enemyNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.ENEMY_NUM);
	private int bonusNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BONUS_NUM);
	private int blockNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BLOCK_NUM);
	private int cannonNum = 20;

	private boolean showSatellite = false;

	private KeyConfig keyConfig;
	private CollisionManager manager;

	public static TopDownTimer timer = new TopDownTimer(3000);
	private DemoPlayField playfield = new DemoPlayField(this);
	private DemoFighter fighter = new DemoFighter(
			TopDownImageUtil.getImage("images/game/fighter.png"));
	private List<Enemy> juniorEnemies = new ArrayList<Enemy>(); // Use Arraylist instead of enemies, by Gang
														
	private List<Bonus> bonuses = new ArrayList<Bonus>();//[bonusNum]
	private List<Block> blocks = new ArrayList<Block>();
	private List<Enemy> cannon = new ArrayList<Enemy>(); // Yi Ding's revise, Gang changed it to ArrayList;
												
	private ElementSpawner<Enemy> enemySpawner1;
	private ElementSpawner<Enemy> cannonSpawner1;
	private ElementSpawner<Bonus> bonusSpawner1;
    private ElementSpawner<Block> blockSpawner1;
    private ElementSpawner<Block> blockSpawner2;
	
	public GameLevel1(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLevelState(parent, this);
	}

	public void initResources() {
		LifeDecreaseCollision.destroyed = 0;

		playfield.init("images/game/background.png");

		manager = new CollisionManager(playfield);
		manager.registerCollision("Fighter", "Enemy Missile",new SoundCollision(playfield, "sounds/explosion.wav"),new ImageCollision(playfield, "images/game/explosion.png"));

		manager.registerCollision("Fighter","Normal","Enemy Missile",new FighterBulletCollision());
		
		manager.registerCollision("Fighter","Shield","Enemy Missile",new InActiveCollision());

		manager.registerCollision("Fighter", "Enemy", new SoundCollision(playfield, "sounds/explosion.wav"),new ImageCollision(playfield, "images/game/explosion.png"));

		manager.registerCollision("Fighter", "Shield","Enemy",new PhysicCollision());
		
		manager.registerCollision("Fighter", "Normal","Enemy",new FighterEnemyOrBlockCollision());
		
		manager.registerCollision("Enemy", "Fighter Bullet",new SoundCollision(playfield, "sounds/explosion.wav"),new ImageCollision(playfield, "images/game/explosion.png"),new EnemyBulletCollision());

		
		manager.registerCollision("Fighter", "Bonus", new SoundCollision(playfield, "sounds/explosion.wav"),new BonusCollision());
		
		manager.registerCollision("Fighter", "Block", new SoundCollision(playfield, "sounds/explosion.wav"),new ImageCollision(playfield, "images/game/explosion.png"),new FighterEnemyOrBlockCollision());
		
		manager.registerCollision("Fighter", "Normal","Block",new FighterEnemyOrBlockCollision());
		
		manager.registerCollision("Fighter", "Shield","Block",new InActiveCollision());

		manager.registerCollision("Block", "Fighter Bullet",new SoundCollision(playfield, "sounds/explosion.wav"),new ImageCollision(playfield, "images/game/explosion.png"),new BlockBulletCollision());


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

		// Yi Ding's revise, Gang changed it to use EnemySpawner to generate cannons
		cannonSpawner1=new ElementSpawner<Enemy>(new SpawnByRandom(), new DemoCannonBlock(playfield,
				getImage("images/game/base.png"),
				getImage("images/game/cannon.png"), fighter), cannonNum);
		cannon.addAll(cannonSpawner1.spawn());

		// In this level we use Time Spawning mechanism to generate enemies
		enemySpawner1 = new ElementSpawner<Enemy>(new SpawnByTime(fighter), new DemoEnemy(
				playfield, getImage("images/game/enemy_easy.png"),
				Configuration.ENEMY_HP), 5);

		//use Element spawner to spawn most of the elements in the game
		bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus1(playfield,
				getImage("images/game/bonus.png")),  bonusNum );
		bonuses.addAll(bonusSpawner1.spawn());

		fighter.setKeyList(JsonUtil.createKeyList(fighter, "keyConfig.json",
				this));

	}

	@Override
	public void render(Graphics2D g) {
		playfield.render(g);
		if (levelComplete) {
			playfield.clearPlayField();
			betweenLevelsRender(g, 2);
		}

		else if (gameOver) {
			playfield.clearPlayField();
			gameOverRender(g);
		} else {
			gameRender(g, "BEAT DOWN 10 ENEMIES ");

		}

	}

	@Override
	public void innerStateUpdate(long elapsedTime) {
		playfield.update(elapsedTime);

		fighter.refresh(elapsedTime);

		
		KeyPressedSubject.getInstance().notifyObservers(elapsedTime);
		
		if (keyDown(KeyEvent.VK_SPACE) && !showSatellite) {
			showSatellite = true;
			fighter.getAssistanceState().changeState(
					new DemoProtection(TopDownImageUtil
							.getImage("images/game/Satellite.png"), fighter));
			((AssistanceState) fighter.getAssistanceState()).genAssistance();
		}

		// fighter.bomb(elapsedTime);

		// Yi Ding's revise
		for (int i = 0; i < cannonNum; i++) {
			cannon.get(i).refresh(elapsedTime);
		}
		
		
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
		
        // Spawn enemies after a certain period of time
		juniorEnemies.addAll(enemySpawner1.spawn());
			

		for (int i = 0; i < bonuses.size(); i++) {
			bonuses.get(i).refresh(elapsedTime);
		}

		if (fighter.getLifeNum() == 0) {
			gameOver = true;
		}
	}

	public boolean levelComplete() {
		if (EnemyBulletCollision.destroyed >= 1) {
			levelComplete = true;
		}
		return levelComplete;
	}

	public void gameRender(Graphics2D g, String levelRequirement) {
		fontManager.getFont("FPS Font").drawString(g, levelRequirement, 20, 15);
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED   " + LifeDecreaseCollision.destroyed, 20,
				30);
	}

	public void betweenLevelsRender(Graphics2D g, int nextLevelNum) {
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED   " + LifeDecreaseCollision.destroyed, 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g, "MISSION COMPLETE!   ",
				20, DemoGameEngine.HEIGHT / 2);
		fontManager.getFont("FPS Font").drawString(g,
				"COMING: LEVEL" + " " + nextLevelNum + "       ", 20,
				DemoGameEngine.HEIGHT / 2 + 50);
	}
}

