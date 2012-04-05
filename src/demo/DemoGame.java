package demo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import keyconfiguration.KeyConfig;

import util.TopDownImageUtil;

import collision.EnemyFighterBulletCollision;


import background.TopDownBackground;


import element.Bonus;
import element.ElementGroup;
import element.Enemy;
import element.Fighter;
import element.TopDownPlayField;

import game.Configuration;
import game.TopDownGame;
import game.TopDownGameEngine;
import game.TopDownGameObject;

public class DemoGame extends TopDownGameObject {
	

	private int enemyNum = Configuration.ENEMY_NUM;
	private int bonusNum = Configuration.BONUS_NUM;
	private int blockNum = Configuration.BLOCK_NUM;
//	private int ammunitionUpgradeNum = Configuration.AMMUNITION_UPGRADE_NUM;

	private DemoPlayField playfield = new DemoPlayField();;
//	private TopDownBackground background;
//	private ElementGroup FIGHTER, FIGHTER_BULLET, ENEMY, ENEMY_MISSILE,
//			AMMUNITION_UPGRADE;

	private DemoFighter fighter = new DemoFighter(Configuration.FIGHTER_PATH);

//	private DemoFighter fighter = new DemoFighter(TopDownImageUtil.getImage("images/game/fighter.png"));
	private DemoEnemy[] juniorEnemies = new DemoEnemy[enemyNum];
	private DemoBonus[] bonuses = new DemoBonus[enemyNum];
	private DemoBlock[] blocks = new DemoBlock[blockNum];
	private boolean completed = false, lose = false; // whether game is over
	private KeyConfig keyConfig;

	public DemoGame(TopDownGameEngine parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initResources() {
		
		EnemyFighterBulletCollision.destroyed = 0;

		playfield.init();
		for (int i = 0; i < blockNum; i++) {
			blocks[i] = new DemoBlock(playfield,
					getImage("images/game/block.png"));
			blocks[i].init();
		}
		fighter.setPlayfield(playfield);
		fighter.setGameObject(this);
		fighter.init();
		
		//init enemies
		for (int i = 0; i < enemyNum; i++) {
			juniorEnemies[i] = new DemoEnemy(playfield,
					Configuration.ENEMY_PATH, Configuration.ENEMY_HP);
			juniorEnemies[i].init();
		}
		
		for (int i = 0; i < bonusNum; i++) {
			bonuses[i] = new DemoBonus(playfield,
					getImage("images/game/bonus.png"));
			bonuses[i].init();
		}
		keyConfig = new KeyConfig(fighter,this);
        keyConfig.parseKeyConfig("keyConfig.json");
        fighter.setKeyList(keyConfig.getKeyList());
		
	}

	@Override
	public void update(long elapsedTime) {

		playfield.update(elapsedTime);
		
		fighter.refresh(elapsedTime);
		
		fighter.bomb(elapsedTime);
		//update Enemies
		for (int i = 0; i < enemyNum; i++) {
			juniorEnemies[i].refresh(elapsedTime);
		}
		
		for (int i = 0; i < bonusNum; i++) {
			bonuses[i].refresh(elapsedTime);
		}

		// press ESC at any time to go back to menu
		if (keyDown(KeyEvent.VK_ESCAPE)) {
			parent.nextGameID = DemoGameEngine.MENU;
			finish();
		}
	}
	
	@Override
	public void render(Graphics2D g) {

		playfield.render(g);
		// display enemies destroyed
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED   " + EnemyFighterBulletCollision.destroyed, 20,
				20);
		
		fontManager.getFont("FPS Font").drawString(g,
				"PLAYER HP   " + fighter.getHP(), 20,
				35);
		
		fontManager.getFont("FPS Font").drawString(g,
				"PLAYER LIFE NUMBER   " + fighter.getLifeNum(), 20,
				50);
		// game over
		if (completed) {
			fontManager.getFont("FPS Font").drawString(g,
					"MISSION COMPLETE!    PRESS ESC...", 20,
					DemoGameEngine.HEIGHT / 2);
		}
		if (lose) {
			fontManager.getFont("FPS Font").drawString(g,
					"GAME OVER!    PRESS ESC...", 20, DemoGameEngine.HEIGHT / 2);
		}
	}

}
