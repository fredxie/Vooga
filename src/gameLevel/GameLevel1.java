package gameLevel;

import game.TopDownGameEngine;
import game.TopDownTimer;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import levelTransition.DemoLevelTransition1;
import playerState.AssistanceState;
import spawn.ElementSpawner;
import state.DefaultLastLevelState;
import state.DefaultLevelState;
import util.JsonUtil;
import util.TopDownImageUtil;
import collisionSystem.CollisionManager;
import collisionSystem.EnemyBulletCollision;
import collisionSystem.LifeDecreaseCollision;
import configuration.GameParameters;
import demo.DemoFighter;
import demo.DemoPlayField;
import demo.DemoProtection;
import element.Block;
import element.Bonus;
import element.Enemy;

public class GameLevel1 extends GameLevel {
	public int enemyNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.ENEMY_NUM);
	public int bonusNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BONUS_NUM);
	public int blockNum = JsonUtil.parse("paraConfig.json").get(
			GameParameters.BLOCK_NUM);
	public int cannonNum = 20;

	public boolean showSatellite = false;

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
	public List<Enemy> cannon = new ArrayList<Enemy>(); // Yi Ding's revise,
														// Gang changed it to
														// ArrayList;

	public ElementSpawner<Enemy> enemySpawner1;
	public ElementSpawner<Enemy> cannonSpawner1;
	public ElementSpawner<Bonus> bonusSpawner1;
	public ElementSpawner<Block> blockSpawner1;
	public ElementSpawner<Block> blockSpawner2;

	public GameLevel1(TopDownGameEngine parent) {
		super(parent);

		myState = new DefaultLevelState(parent, this);
	}

	public void initResources() {
		LifeDecreaseCollision.destroyed = 0;
		DemoLevelInit1 demoLevelInit1 = new DemoLevelInit1();
		demoLevelInit1.backgroundInit(this);
		demoLevelInit1.collisionInit(this);
		demoLevelInit1.fighterInit(this);
		demoLevelInit1.blockInit(this);
		demoLevelInit1.bonusInit(this);
		demoLevelInit1.enemyInit(this);
		demoLevelInit1.cannonInit(this);
		demoLevelInit1.gameRecordInit();
		fighter.setKeyList(JsonUtil.createKeyList(fighter, "keyConfig.json",
				this));

	}

	@Override
	public void render(Graphics2D g) {
		
		DemoLevelTransition1 dlt1 = new DemoLevelTransition1();
		playfield.render(g);
		if (levelComplete) {
			playfield.clearPlayField();
			dlt1.betweenLevelsRender(g, 2, fontManager);
		}

		else if (gameOver) {
			playfield.clearPlayField();
			dlt1.gameOverRender(g,fontManager);
		} else {
			dlt1.gameRender(g, "BEAT DOWN 10 ENEMIES ",fontManager);

		}

	}

	public void innerStateUpdate(long elapsedTime) {
		DemoLevelUpdate1 demoLevelUpdate1 = new DemoLevelUpdate1();
		DemoLevelTransition1 dlt1 = new DemoLevelTransition1();

		//dlt1.levelComplete(levelComplete);
		demoLevelUpdate1.keyUpdate(elapsedTime);
		demoLevelUpdate1.playFieldUpdate(this, elapsedTime);
		demoLevelUpdate1.enemyUpdate(this, elapsedTime);
		demoLevelUpdate1.fighterUpdate(this, elapsedTime);
		demoLevelUpdate1.bonusUpdate(this, elapsedTime);
		demoLevelUpdate1.gameUpdate(this, elapsedTime);
		demoLevelUpdate1.cannonUpdate(this, elapsedTime);
		if (keyDown(KeyEvent.VK_SPACE) && !showSatellite) {
			showSatellite = true;
			fighter.getAssistanceState().changeState(
					new DemoProtection(TopDownImageUtil
							.getImage("images/game/Satellite.png"), fighter));
			((AssistanceState) fighter.getAssistanceState()).genAssistance();
		}
	}
	public boolean levelComplete() {
		if (EnemyBulletCollision.destroyed >= 1) {
			levelComplete = true;
		}
		return levelComplete;
	}
}
