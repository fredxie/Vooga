package demoState;

import game.Configuration;
import game.TopDownGameEngine;
import game.TopDownTimer;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import collision.EnemyFighterBulletCollision;

import keyconfiguration.KeyConfig;

import demo.DemoBlock;
import demo.DemoBonus;
import demo.DemoEnemy;
import demo.DemoFighter;
import demo.DemoGameEngine;
import demo.DemoPlayField;
import demo.EnemyDestroyedCollision;




import util.TopDownImageUtil;

public class GameLevel2State extends State{
	
	private double backgroundSpeed = Configuration.BACKGROUND_SPEED;
	private int enemyNum = Configuration.ENEMY_NUM;
	private int bonusNum = Configuration.BONUS_NUM;
	private int blockNum = Configuration.BLOCK_NUM;
	private KeyConfig keyConfig;
	private TopDownTimer timer = new TopDownTimer(3000);
	private DemoPlayField playfield = new DemoPlayField(this);
	private DemoFighter fighter = new DemoFighter(TopDownImageUtil.getImage("images/game/fighter.png"));
	private DemoEnemy[] juniorEnemies = new DemoEnemy[enemyNum];
	private DemoBonus[] bonuses = new DemoBonus[enemyNum];
	private DemoBlock[] blocks = new DemoBlock[blockNum];
	
	public GameLevel2State(TopDownGameEngine parent) {
		super(parent);
		gameID = 2;
	}


	public void initResources() {
		
		EnemyDestroyedCollision.destroyed = 0;

		playfield.init("images/game/background.jpg");
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
        
		// press ESC at any time to go to pause state
		if (keyDown(KeyEvent.VK_ESCAPE)) {
			parent.nextGameID = DemoGameEngine.Menu;
			finish();
		}
		if(levelComplete())
		{
			if(timer.action(elapsedTime)){
				levelComplete = false;
				parent.nextGameID = DemoGameEngine.Menu;
				finish();
			}
		}
	}
	
	@Override
	public void render(Graphics2D g) {


		playfield.render(g);
		// game over
		if (levelComplete) {
			playfield.clearPlayField();
			fontManager.getFont("FPS Font").drawString(g, "ENEMIES DESTROYED   " + EnemyFighterBulletCollision.destroyed, 20, DemoGameEngine.HEIGHT / 2 -50);
			fontManager.getFont("FPS Font").drawString(g, "MISSION COMPLETE!   ", 20, DemoGameEngine.HEIGHT / 2 );  
			fontManager.getFont("FPS Font").drawString(g, "COMING: LEVEL 3     ", 20, DemoGameEngine.HEIGHT / 2 + 50);
		}
		else if (gameOver) {
			fontManager.getFont("FPS Font").drawString(g,
					"GAME OVER!    PRESS ESC...", 20, DemoGameEngine.HEIGHT / 2);
		}
		
		else{
			// display enemies destroyed
			fontManager.getFont("FPS Font").drawString(g,
					"BEAT DOWN 20 ENEMIES   ", 20,
					15);
			fontManager.getFont("FPS Font").drawString(g,
					"ENEMIES DESTROYED   " + EnemyFighterBulletCollision.destroyed, 20,
					30);
		}
	}



	@Override
	public boolean levelComplete() {
		if(EnemyFighterBulletCollision.destroyed>=20){
			levelComplete = true;
		 }
		return levelComplete;
	}

}

