package demo.gameLevel;

import levelEditor.LevelEditorUtil;
import levelEditor.Load;
import ai.AI;
import api.collisionSystem.BonusCollision;
import api.collisionSystem.CollisionManager;
import api.collisionSystem.ImageCollision;
import api.collisionSystem.PhysicCollision;
import api.collisionSystem.SoundCollision;
import api.element.Block;
import api.element.Bonus;
import api.element.Enemy;
import api.game.TopDownTimer;
import api.gameLevel.GameLevel;
import api.gameLevel.GameLevelInit;
import api.spawn.ElementSpawner;
import api.spawn.SpawnByRandom;
import api.spawn.SpawnByTime;
import api.util.JsonUtil;
import api.util.TopDownImageUtil;
import demo.collisionSystem.BlockBulletCollision;
import demo.collisionSystem.EnemyBulletCollision;
import demo.collisionSystem.FighterBulletCollision;
import demo.collisionSystem.FighterEnemyOrBlockCollision;
import demo.collisionSystem.InActiveCollision;
import demo.element.DemoBlock;
import demo.element.DemoBonus1;
import demo.element.DemoEnemy;
import demo.element.DemoFighter;
import demo.game.DemoPlayField;

public class MyOwnGameLevelInit extends GameLevelInit {
	public String blockPath;
	public String enemyPath;
	public String bonusPath;

	public MyOwnGameLevelInit(GameLevel gl) {
		super(gl);
	}

	@SuppressWarnings("static-access")
	public void parametersInit() {
		gl.gameOver = false;
		gl.levelComplete = false;
		gl.showSatellite = false;
		gl.playfield = new DemoPlayField(gl);
		for (int i = 1; i < Load.list.size(); i++) {
			if (Load.list.get(i).get(1).equals("Enemy")) {
				gl.enemyNum = LevelEditorUtil.castObjectToInteger(Load.list
						.get(i).get(5));
				enemyPath = (String)Load.list.get(i).get(0);
				System.out.print(enemyPath);
			} else if (Load.list.get(i).get(1).equals( "Block")) {
				gl.blockNum = LevelEditorUtil.castObjectToInteger(Load.list
						.get(i).get(5));
				blockPath = (String)Load.list.get(i).get(0);

				System.out.print(blockPath);
			} else if (Load.list.get(i).get(1) .equals( "Bonus") ){
				gl.bonusNum = LevelEditorUtil.castObjectToInteger(Load.list
						.get(i).get(5));
				bonusPath = (String)Load.list.get(i).get(0);

				System.out.print(bonusPath);
			}

		}
		gl.timer = new TopDownTimer(3000);
		gl.fighter = new DemoFighter(
				TopDownImageUtil.getImage("images/game/fighter.png"));

		gl.level = 3;
		gl.levelRequirement = "GO THROUGH IT!!";
		
	}

	public void backgroundInit() {
		gl.playfield.init((String)Load.list.get(0).get(0));
	}

	public void fighterInit() {
		gl.fighter.setPlayfield(gl.playfield);
		gl.fighter.setGameObject(gl);
		gl.fighter.init();
	}

	public void blockInit() {
		gl.blockSpawner = new ElementSpawner<Block>(new SpawnByRandom(),
				new DemoBlock(gl.playfield, gl
						.getImage(blockPath)),
				2 * gl.blockNum / 3);
		gl.blocks.addAll(gl.blockSpawner.spawn());
	}

	// Yi Ding's revise different bonus spawn

	public void bonusInit() {
		gl.bonusSpawner = new ElementSpawner<Bonus>(new SpawnByRandom(),
				new DemoBonus1(gl.playfield, gl
						.getImage(bonusPath)),
				gl.bonusNum);
		gl.bonuses.addAll(gl.bonusSpawner.spawn());
	}

	public void enemyInit() {
		gl.enemySpawner = new ElementSpawner<Enemy>(
				new SpawnByTime(gl.fighter),
				new DemoEnemy(gl.playfield, gl
						.getImage(enemyPath), AI.ENEMY_HP),
				5);
		gl.juniorEnemies.addAll(gl.enemySpawner.spawn());

	}

	public void collisionInit() {
		gl.manager = new CollisionManager(gl.playfield);
		gl.manager.registerCollision("Fighter", "Enemy Missile",
				new SoundCollision(gl.playfield, "sounds/explosion.wav"),
				new ImageCollision(gl.playfield, "images/game/explosion.png"));

		gl.manager.registerCollision("Fighter", "Normal", "Enemy Missile",
				new FighterBulletCollision());

		gl.manager.registerCollision("Fighter", "Shield", "Enemy Missile",
				new InActiveCollision());

		gl.manager.registerCollision("Fighter", "Enemy", new SoundCollision(
				gl.playfield, "sounds/explosion.wav"), new ImageCollision(
				gl.playfield, "images/game/explosion.png"));

		gl.manager.registerCollision("Fighter", "Shield", "Enemy",
				new PhysicCollision());

		gl.manager.registerCollision("Fighter", "Normal", "Enemy",
				new FighterEnemyOrBlockCollision());

		gl.manager.registerCollision("Enemy", "Fighter Bullet",
				new SoundCollision(gl.playfield, "sounds/explosion.wav"),
				new ImageCollision(gl.playfield, "images/game/explosion.png"),
				new EnemyBulletCollision());

		gl.manager.registerCollision("Fighter", "Bonus", new SoundCollision(
				gl.playfield, "sounds/explosion.wav"), new BonusCollision());

		gl.manager.registerCollision("Fighter", "Block", new SoundCollision(
				gl.playfield, "sounds/explosion.wav"), new ImageCollision(
				gl.playfield, "images/game/explosion.png"),
				new FighterEnemyOrBlockCollision());

		gl.manager.registerCollision("Fighter", "Normal", "Block",
				new FighterEnemyOrBlockCollision());

		gl.manager.registerCollision("Fighter", "Shield", "Block",
				new InActiveCollision());

		gl.manager.registerCollision("Block", "Fighter Bullet",
				new SoundCollision(gl.playfield, "sounds/explosion.wav"),
				new ImageCollision(gl.playfield, "images/game/explosion.png"),
				new BlockBulletCollision());

	}

	public void keyInit() {
		gl.fighter.setKeyList(JsonUtil.createKeyList(gl.fighter,
				"json/keyConfig.json", gl));
	}

	/***
	 * added by Jiawei initialize the number of killed enemies before the start
	 * of every level Help to fix bugs in restart game and game record display
	 */
	public void gameRecordInit() {
		EnemyBulletCollision.destroyed = 0;
	}

}
