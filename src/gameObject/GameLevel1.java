package gameObject;

import game.Configuration;
import game.TopDownGameEngine;
import game.TopDownTimer;
import hud.HUD;

import java.awt.Graphics2D;
import java.util.ArrayList;

import keyconfiguration.KeyConfig;
import state.Level1State;
import util.TopDownImageUtil;

import collision.EnemyFighterBulletCollision;

import demo.DemoBlock;
import demo.DemoBonus;
import demo.DemoEnemy;
import demo.DemoFighter;
import demo.DemoGameEngine;
import demo.DemoPlayField;


public class GameLevel1 extends TopDownGameObject {
	private double backgroundSpeed = Configuration.BACKGROUND_SPEED;
	private int enemyNum = Configuration.ENEMY_NUM;
	private int bonusNum = Configuration.BONUS_NUM;
	private int blockNum = Configuration.BLOCK_NUM;
	private KeyConfig keyConfig;
	private static int Level;

	public static TopDownTimer timer = new TopDownTimer(3000);
	private DemoPlayField playfield = new DemoPlayField(this);
	private DemoFighter fighter = new DemoFighter(TopDownImageUtil.getImage("images/game/fighter.png"));
	private DemoEnemy[] juniorEnemies = new DemoEnemy[enemyNum];
	private DemoBonus[] bonuses = new DemoBonus[enemyNum];
	private DemoBlock[] blocks = new DemoBlock[blockNum];

	public GameLevel1(TopDownGameEngine parent) {
		super(parent);
		myState = new Level1State(parent,this);
	}

	
	@Override
	public void initResources() {
		EnemyFighterBulletCollision.destroyed = 0;

		playfield.init("images/game/background.png");
		for (int i = 0; i < blockNum; i++) {
			int j = getRandom(0,30);
			if(j<=10)
			blocks[i] = new DemoBlock(playfield,
					getImage("images/game/block2.png"),3);
			else 
				blocks[i] = new DemoBlock(playfield,
						getImage("images/game/block.png"));
			blocks[i].init();
		}

		fighter.setPlayfield(playfield);
		fighter.setGameObject(this);
		fighter.init();

		for (int i = 0; i < enemyNum; i++) {
			juniorEnemies[i] = new DemoEnemy(playfield,
					getImage("images/game/enemy_easy.png"), Configuration.ENEMY_HP);
			juniorEnemies[i].init();
		}

		for (int i = 0; i < bonusNum; i++) {
			bonuses[i] = new DemoBonus(playfield,
					getImage("images/game/bonus.png"));
			bonuses[i].init();
		}

		keyConfig = new KeyConfig(fighter, this);
		keyConfig.parseKeyConfig("keyConfig.json");
		fighter.setKeyList(keyConfig.getKeyList());	
		
	}

	@Override
	public void render(Graphics2D g) {
		playfield.render(g);
		// game over
		if (levelComplete) {
			playfield.clearPlayField();
			fontManager.getFont("FPS Font").drawString(g, "ENEMIES DESTROYED   " + EnemyFighterBulletCollision.destroyed, 20, DemoGameEngine.HEIGHT / 2 -50);

		/*
		 * Take in object[] without Element object and display	
		 */
			ArrayList<Object[]> list = new ArrayList<Object[]>();
			Object[] obj1 = {"MISSION COMPLETE!", 20, DemoGameEngine.HEIGHT / 2};
			Object[] obj2 = {"COMING: LEVEL 2 ", 20, DemoGameEngine.HEIGHT / 2 + 50};
			list.add(obj1);
			list.add(obj2);

		}
		else if (gameOver) {
			/*
			 * Takes in individual parameters and display
			 */
			HUD hud = new HUD(g, "FPS Font", "GAME OVER! PRESS ESC TO QUIT", 20, DemoGameEngine.HEIGHT / 2);
			hud.displayMono();
		}

		else{
			// display enemies destroyed
			fontManager.getFont("FPS Font").drawString(g, "BEAT DOWN 10 ENEMIES ", 20, 15);
			fontManager.getFont("FPS Font").drawString(g, "ENEMIES DESTROYED   " + EnemyFighterBulletCollision.destroyed, 20, 30);
		}
		
	}

	@Override
	public void innerStateUpdate(long elapsedTime) {
		playfield.update(elapsedTime);

		fighter.refresh(elapsedTime);

		fighter.bomb(elapsedTime);
		//update Enemies
		for(int i = 0; i < enemyNum; i++){
			juniorEnemies[i].refresh(elapsedTime);
			double h = juniorEnemies[i].getHorizontalSpeed();
			double v = juniorEnemies[i].getVerticalSpeed();
			if(juniorEnemies[i].getX() <= 0 || juniorEnemies[i].getX() >= DemoGameEngine.WIDTH-((juniorEnemies[i].getWidth()))){
				juniorEnemies[i].setSpeed(-h, v);		
			}
		}
		for (int i = 0; i < enemyNum; i++) {
			juniorEnemies[i].refresh(elapsedTime);
		}

		for (int i = 0; i < bonusNum; i++) {
			bonuses[i].refresh(elapsedTime);
		}
		
		
	}
	
	public boolean levelComplete() {
		if(EnemyFighterBulletCollision.destroyed>=10){
			levelComplete = true;
		 }
		return levelComplete;
	}
	public static  int getLevel() {
		return Level;
	}


	public void setLevel(int level) {
		Level = level;
	}

}
