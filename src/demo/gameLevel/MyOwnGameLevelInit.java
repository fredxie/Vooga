package demo.gameLevel;

import levelEditor.Load;
import api.background.TopDownImageBackground;
import api.collisionSystem.BonusCollision;
import api.collisionSystem.CollisionManager;
import api.collisionSystem.ImageCollision;
import api.collisionSystem.PhysicCollision;
import api.collisionSystem.SoundCollision;
import api.game.TopDownTimer;
import api.gameLevel.GameLevel;
import api.gameLevel.GameLevelInit;
import api.util.JsonUtil;
import api.util.TopDownImageUtil;

import com.golden.gamedev.object.background.ImageBackground;

import demo.collisionSystem.BlockBulletCollision;
import demo.collisionSystem.EnemyBulletCollision;
import demo.collisionSystem.FighterBulletCollision;
import demo.collisionSystem.FighterEnemyOrBlockCollision;
import demo.collisionSystem.InActiveCollision;
import demo.element.DemoBlock;
import demo.element.DemoBonus1;
import demo.element.DemoEnemy;
import demo.element.DemoFighter;
import demo.game.DemoGameEngine;
import demo.game.DemoPlayField;

public class MyOwnGameLevelInit extends GameLevelInit {
   

	public MyOwnGameLevelInit(GameLevel gl) {
		super(gl);
		
	}

	@SuppressWarnings("static-access")
	public void parametersInit() {
		gl.gameOver = false;
		gl.levelComplete = false;
		gl.showSatellite = false;
		gl.playfield = new DemoPlayField(gl);
		gl.timer = new TopDownTimer(3000);
		gl.fighter = new DemoFighter(
				TopDownImageUtil.getImage("images/game/fighter.png"));

		gl.levelRequirement = "GO THROUGH IT!!";
		gl.level = 3;
		
		int size = Load.list.size();
		for(int i = 1; i<size;i++){
			if(Load.list.get(i).get(1).equals("Bonus")){
				gl.bonusNum++;
				DemoBonus1 demoBonus = new DemoBonus1(gl.playfield,gl.getImage((String)Load.list.get(i).get(0)));
				demoBonus.setX((Double) Load.list.get(i).get(3));
				demoBonus.setY((Double) Load.list.get(i).get(4));
				gl.bonuses.add(demoBonus);
			}
			else if(Load.list.get(i).get(1).equals("Block")){
				gl.blockNum++;
				DemoBlock demoBlock = new DemoBlock(gl.playfield,gl.getImage((String)Load.list.get(i).get(0)));
				demoBlock.setX((Double) Load.list.get(i).get(3));
				demoBlock.setY((Double) Load.list.get(i).get(4));
				gl.blocks.add(demoBlock);
			}
			else if(Load.list.get(i).get(1).equals("Enemy")){
				gl.enemyNum++;
				DemoEnemy demoEnemy = new DemoEnemy(gl.playfield,gl.getImage((String)Load.list.get(i).get(0)),(Double) Load.list.get(i).get(2));
				demoEnemy.setX((Double) Load.list.get(i).get(3));
				demoEnemy.setY((Double) Load.list.get(i).get(4));
				gl.juniorEnemies.add(demoEnemy);
			}
		}
		
	}

	public void backgroundInit() {
		ImageBackground img = new TopDownImageBackground(gl.getImage((String)Load.list.get(0).get(0)), DemoGameEngine.WIDTH, (Integer) Load.list.get(0).get(1));
		gl.playfield.setBackground(img);
	}

	public void fighterInit() {
		gl.fighter.setPlayfield(gl.playfield);
		gl.fighter.setGameObject(gl);
		gl.fighter.init();
	}

	public void blockInit() {
      //for this game level, all initialization of elements moved into parameteInit()
	}
	
	public void bonusInit() {
      //for this game level, all initialization of elements moved into parameteInit()
	}

	public void enemyInit() {
      //for this game level, all initialization of elements moved into parameteInit()
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

	public void gameRecordInit() {
		EnemyBulletCollision.destroyed = 0;
	}
}
