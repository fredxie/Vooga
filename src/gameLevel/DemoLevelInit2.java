package gameLevel;

import ai.AI;
import spawn.ElementSpawner;
import spawn.SpawnByRandom;
import collisionSystem.BlockBulletCollision;
import collisionSystem.BonusCollision;
import collisionSystem.CollisionManager;
import collisionSystem.EnemyBulletCollision;
import collisionSystem.FighterBulletCollision;
import collisionSystem.FighterEnemyOrBlockCollision;
import collisionSystem.ImageCollision;
import collisionSystem.InActiveCollision;
import collisionSystem.PhysicCollision;
import collisionSystem.SoundCollision;
import demo.DemoBlock;
import demo.DemoBonus1;
import demo.DemoEnemy;
import element.Block;
import element.Bonus;
import element.Enemy;
import game.Configuration;

public class DemoLevelInit2 {
	public void backgroundInit(GameLevel2 gl) {
		gl.playfield.init("images/game/background.png");
	}

	public void fighterInit(GameLevel2 gl) {
		gl.fighter.setPlayfield(gl.playfield);
		gl.fighter.setGameObject(gl);
		gl.fighter.init();
	}

	public void blockInit(GameLevel2 gl) {
		gl.blockSpawner1 = new ElementSpawner<Block>(
				new SpawnByRandom(),
				new DemoBlock(gl.playfield, gl.getImage("images/game/block2.png"), 3),
				gl.blockNum / 3);
		gl.blockSpawner2 = new ElementSpawner<Block>(new SpawnByRandom(),
				new DemoBlock(gl.playfield, gl.getImage("images/game/block.png")),
				2 * gl.blockNum / 3);
		gl.blocks.addAll(gl.blockSpawner1.spawn());
		gl.blocks.addAll(gl.blockSpawner2.spawn());
	}

	public void bonusInit(GameLevel2 gl) {
		gl.bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus1(gl.playfield,
				gl.getImage("images/game/bonus.png")),  gl.bonusNum );
		gl.bonuses.addAll(gl.bonusSpawner1.spawn());
	}

	public void enemyInit(GameLevel2 gl) {
		gl.ES = new ElementSpawner<Enemy>(new SpawnByRandom(), new DemoEnemy(
				gl.playfield, gl.getImage("images/game/enemy_easy.png"),
				AI.ENEMY_HP), gl.enemyNum);
		gl.juniorEnemies.addAll(gl.ES.spawn());
	}


	public void collisionInit(GameLevel2 gl) {
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
	
	/***
	 * added by Jiawei
	 * initialize the number of killed enemies before the start of every level
	 * Help to fix bugs in restart game and game record display
	 */
	public void gameRecordInit(){
		EnemyBulletCollision.destroyed = 0;
	}



}