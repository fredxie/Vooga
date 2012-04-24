package DemoGameLevel;

import game.TopDownTimer;
import gameLevel.GameLevelInit;
import spawn.ElementSpawner;
import spawn.SpawnByRandom;
import util.JsonUtil;
import util.TopDownImageUtil;
import DemoCollisioSystem.BlockBulletCollision;
import DemoCollisioSystem.BonusCollision;
import DemoCollisioSystem.EnemyBulletCollision;
import DemoCollisioSystem.FighterBulletCollision;
import DemoCollisioSystem.FighterEnemyOrBlockCollision;
import DemoCollisioSystem.ImageCollision;
import DemoCollisioSystem.InActiveCollision;
import DemoCollisioSystem.PhysicCollision;
import DemoCollisioSystem.SoundCollision;
import ai.AI;
import collisionSystem.CollisionManager;
import configuration.api.GameParameters;
import demo.DemoBlock;
import demo.DemoBonus1;
import demo.DemoCannonBlock;
import demo.DemoEnemy;
import demo.DemoFighter;
import element.Block;
import element.Bonus;
import element.Enemy;

public class DemoLevelInit2 extends GameLevelInit {
	public DemoLevelInit2(GameLevel2 gl) {
		super(gl);
	}

	public void parametersInit() {
		gl.gameOver = false;
		gl.levelComplete =false;
		gl.showSatellite = false;
		gl.enemyNum = JsonUtil.parse("paraConfig.json").get(
				GameParameters.ENEMY_NUM);
		gl.bonusNum = JsonUtil.parse("paraConfig.json").get(
				GameParameters.BONUS_NUM);
		gl.blockNum = JsonUtil.parse("paraConfig.json").get(
				GameParameters.BLOCK_NUM);
		gl.cannonNum = 30;
		gl.timer = new TopDownTimer(3000);
		gl.fighter = new DemoFighter(
				TopDownImageUtil.getImage("images/game/fighter.png"));

		gl.levelRequirement = "BEAT DOWN 20 ENEMIES !!";
		gl.level = 2;
	}

	public void backgroundInit() {
		gl.playfield.init("images/game/background.png");
	}

	public void fighterInit() {
		gl.fighter.setPlayfield(gl.playfield);
		gl.fighter.setGameObject(gl);
		gl.fighter.init();
	}

	public void blockInit() {
		gl.blockSpawner = new ElementSpawner<Block>(new SpawnByRandom(),
				new DemoBlock(gl.playfield, gl
						.getImage("images/game/block2.png"), 3),
				gl.blockNum / 3);

		gl.blocks.addAll(gl.blockSpawner.spawn());

		gl.blockSpawner = new ElementSpawner<Block>(new SpawnByRandom(),
				new DemoBlock(gl.playfield, gl
						.getImage("images/game/block.png")),
				2 * gl.blockNum / 3);
		gl.blocks.addAll(gl.blockSpawner.spawn());
	}

	public void bonusInit() {
		gl.bonusSpawner = new ElementSpawner<Bonus>(new SpawnByRandom(),
				new DemoBonus1(gl.playfield,
						gl.getImage("images/game/bonus.png")), gl.bonusNum);
		gl.bonuses.addAll(gl.bonusSpawner.spawn());
	}

	public void enemyInit() {
		gl.enemySpawner = new ElementSpawner<Enemy>(new SpawnByRandom(),
				new DemoEnemy(gl.playfield, gl
						.getImage("images/game/enemy_easy.png"), AI.ENEMY_HP),
				gl.enemyNum);
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

	public void cannonInit() {
		gl.cannonSpawner = new ElementSpawner<Enemy>(new SpawnByRandom(),
				new DemoCannonBlock(gl.playfield, gl
						.getImage("images/game/base.png"), gl
						.getImage("images/game/cannon.png"), gl.fighter),
				gl.cannonNum);
		gl.cannon.addAll(gl.cannonSpawner.spawn());

	}

	public void keyInit() {
		gl.fighter.setKeyList(JsonUtil.createKeyList(gl.fighter,
				"keyConfig.json", gl));

	}

	/***
	 * added by Jiawei initialize the number of killed enemies before the start
	 * of every level Help to fix bugs in restart game and game record display
	 */
	public void gameRecordInit() {
		EnemyBulletCollision.destroyed = 0;
	}

}
