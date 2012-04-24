package demo.gameLevel;

import ai.AI;
import api.collisionSystem.CollisionManager;
import api.element.Block;
import api.element.Bonus;
import api.element.Enemy;
import api.game.TopDownTimer;
import api.gameLevel.GameLevelInit;
import api.spawn.ElementSpawner;
import api.spawn.SpawnByRandom;
import api.util.JsonUtil;
import api.util.TopDownImageUtil;
import demo.collisionSystem.BlockBulletCollision;
import demo.collisionSystem.BonusCollision;
import demo.collisionSystem.EnemyBulletCollision;
import demo.collisionSystem.FighterBulletCollision;
import demo.collisionSystem.FighterEnemyOrBlockCollision;
import demo.collisionSystem.ImageCollision;
import demo.collisionSystem.InActiveCollision;
import demo.collisionSystem.PhysicCollision;
import demo.collisionSystem.SoundCollision;
import demo.element.DemoBlock;
import demo.element.DemoBonus1;
import demo.element.DemoCannonBlock;
import demo.element.DemoEnemy;
import demo.element.DemoFighter;

public class DemoLevelInit2 extends GameLevelInit {
	public DemoLevelInit2(GameLevel2 gl) {
		super(gl);
	}

	public void parametersInit() {
		gl.gameOver = false;
		gl.levelComplete = false;
		gl.showSatellite = false;
		gl.enemyNum = JsonUtil.parse("json/paraConfig.json").get("ENEMY_NUM");
		gl.bonusNum = JsonUtil.parse("json/paraConfig.json").get("BONUS_NUM");
		gl.blockNum = JsonUtil.parse("json/paraConfig.json").get("BLOCK_NUM");
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