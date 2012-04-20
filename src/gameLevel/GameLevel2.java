package gameLevel;

import game.TopDownGameEngine;
import game.TopDownTimer;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import levelTransition.DemoLevelTransition2;
import spawn.ElementSpawner;
import state.DefaultLastLevelState;
import util.JsonUtil;
import util.TopDownImageUtil;
import collisionSystem.CollisionManager;
import collisionSystem.EnemyBulletCollision;
import collisionSystem.LifeDecreaseCollision;
import configuration.GameParameters;
import demo.DemoFighter;
import demo.DemoPlayField;
import element.Block;
import element.Bonus;
import element.Enemy;

public class GameLevel2 extends GameLevel {
	public int enemyNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.ENEMY_NUM);
	public int bonusNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BONUS_NUM);
	public int blockNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BLOCK_NUM);
	public CollisionManager manager;

	public static TopDownTimer timer = new TopDownTimer(3000);
	public DemoPlayField playfield = new DemoPlayField(this);
	public DemoFighter fighter = new DemoFighter(
			TopDownImageUtil.getImage("images/game/fighter.png"));
	public List<Enemy> juniorEnemies = new ArrayList<Enemy>(); // Use Arraylist
																// instead of
																// enemies, by
																// Gang
	public List<Bonus> bonuses = new ArrayList<Bonus>();// [bonusNum]
	public List<Block> blocks = new ArrayList<Block>();
	public ElementSpawner<Enemy> ES;
	public ElementSpawner<Block> blockSpawner1;
	public ElementSpawner<Block> blockSpawner2;
	public ElementSpawner<Bonus> bonusSpawner1;

	public GameLevel2(TopDownGameEngine parent) {
		super(parent);

		myState = new DefaultLastLevelState(parent, this);
	}

	public void initResources() {
		LifeDecreaseCollision.destroyed = 0;
		DemoLevelInit2 demoLevelInit2 = new DemoLevelInit2();
		demoLevelInit2.backgroundInit(this);
		demoLevelInit2.collisionInit(this);
		demoLevelInit2.fighterInit(this);
		demoLevelInit2.blockInit(this);
		demoLevelInit2.bonusInit(this);
		demoLevelInit2.enemyInit(this);
		fighter.setKeyList(JsonUtil.createKeyList(fighter, "keyConfig.json",
				this));

	}

	public void render(Graphics2D g) {
		DemoLevelTransition2 dlt2 = new DemoLevelTransition2();
		playfield.render(g);
		if (levelComplete) {
			playfield.clearPlayField();
			dlt2.betweenLevelsRender(g, 3, fontManager);
		}

		else if (gameOver) {
			playfield.clearPlayField();
			dlt2.gameOverRender(g, fontManager);
		} else {
			dlt2.gameRender(g, "BEAT DOWN 20 ENEMIES ", fontManager);

		}

	}

	public void innerStateUpdate(long elapsedTime) {
		DemoLevelUpdate2 demoLevelUpdate2 = new DemoLevelUpdate2();
		DemoLevelTransition2 dlt2 = new DemoLevelTransition2();

		//dlt2.levelComplete(levelComplete);
		demoLevelUpdate2.keyUpdate(elapsedTime);
		demoLevelUpdate2.playFieldUpdate(this, elapsedTime);
		demoLevelUpdate2.enemyUpdate(this, elapsedTime);
		demoLevelUpdate2.fighterUpdate(this, elapsedTime);
		demoLevelUpdate2.bonusUpdate(this, elapsedTime);
		demoLevelUpdate2.gameUpdate(this, elapsedTime);

	}

	public boolean levelComplete() {
		if (EnemyBulletCollision.destroyed >= 1) {
			levelComplete = true;
		}
		return levelComplete;
	}
}
