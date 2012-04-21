package gameLevel;

import playerState.PhysicCollisionState;
import spawn.ElementSpawner;
import spawn.SpawnByRandom;
import spawn.SpawnByTime;
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
import demo.DemoBonus2;
import demo.DemoBonus3;
import demo.DemoBonus4;
import demo.DemoBonus5;
import demo.DemoCannonBlock;
import demo.DemoEnemy;
import element.Block;
import element.Bonus;
import element.Enemy;
import game.Configuration;

public class DemoLevelInit1 {

	public void backgroundInit(GameLevel1 gl) {
		gl.playfield.init("images/game/background.png");
	}

	public void fighterInit(GameLevel1 gl) {
		gl.fighter.setPlayfield(gl.playfield);
		gl.fighter.setGameObject(gl);
		gl.fighter.init();
	}

	public void blockInit(GameLevel1 gl) {
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
	
	// Yi Ding's revise different bonus spawn

	public void bonusInit(GameLevel1 gl) {
		gl.bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus1(gl.playfield,
				gl.getImage("images/game/bullet_scatterload.png")),  gl.bonusNum );
		gl.bonuses.addAll(gl.bonusSpawner1.spawn());
		gl.bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus2(gl.playfield,
				gl.getImage("images/game/fight_damage_powerup.png")),  gl.bonusNum );
		gl.bonuses.addAll(gl.bonusSpawner1.spawn());
		gl.bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus3(gl.playfield,
				gl.getImage("images/game/bullet_laser.png")),  gl.bonusNum );
		gl.bonuses.addAll(gl.bonusSpawner1.spawn());
		gl.bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus4(gl.playfield,
				gl.getImage("images/game/fight_hp_plus.png")),  gl.bonusNum );
		gl.bonuses.addAll(gl.bonusSpawner1.spawn());
		gl.bonusSpawner1 = new ElementSpawner<Bonus>(new SpawnByRandom(),new DemoBonus5(gl.playfield,
				gl.getImage("images/game/fighter_accelerate.png"),new PhysicCollisionState(gl.fighter)),  gl.bonusNum );
		gl.bonuses.addAll(gl.bonusSpawner1.spawn());
	}

	public void enemyInit(GameLevel1 gl) {
		gl.enemySpawner1 = new ElementSpawner<Enemy>(new SpawnByTime(gl.fighter), new DemoEnemy(
				gl.playfield, gl.getImage("images/game/enemy_easy.png"),
				Configuration.ENEMY_HP), 5);
	}

	public void cannonInit(GameLevel1 gl) {
		gl.cannonSpawner1=new ElementSpawner<Enemy>(new SpawnByRandom(), new DemoCannonBlock(gl.playfield,
				gl.getImage("images/game/base.png"),
				gl.getImage("images/game/cannon.png"), gl.fighter), gl.cannonNum);
		gl.cannon.addAll(gl.cannonSpawner1.spawn());
	}

	public void collisionInit(GameLevel1 gl) {
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



}
