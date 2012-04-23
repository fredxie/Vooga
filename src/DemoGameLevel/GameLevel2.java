package DemoGameLevel;

import game.TopDownGameEngine;
import gameLevel.GameLevel;

import java.awt.Graphics2D;

import state.DefaultLastLevelState;
import collisionSystem.EnemyBulletCollision;

public class GameLevel2 extends GameLevel {

	public GameLevel2(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLastLevelState(parent, this);
	}

	public void initResources() {
		DemoLevelInit2 demoLevelInit2 = new DemoLevelInit2(this);
		demoLevelInit2.gameRecordInit();
		demoLevelInit2.parametersInit();
		demoLevelInit2.backgroundInit();
		demoLevelInit2.collisionInit();
		demoLevelInit2.fighterInit();
		demoLevelInit2.blockInit();
		demoLevelInit2.bonusInit();
		demoLevelInit2.enemyInit();
		demoLevelInit2.cannonInit();
		demoLevelInit2.keyInit();

	}

	public void render(Graphics2D g) {
		playfield.render(g);
		gameRender(g);
	}

	public void innerStateUpdate(long elapsedTime) {
		DemoLevelUpdate2 demoLevelUpdate2 = new DemoLevelUpdate2(this);

		demoLevelUpdate2.levelComplete();
		demoLevelUpdate2.keyUpdate(elapsedTime, fighter);
		demoLevelUpdate2.playFieldUpdate(elapsedTime);
		demoLevelUpdate2.enemyUpdate(elapsedTime);
		demoLevelUpdate2.fighterUpdate(elapsedTime);
		demoLevelUpdate2.bonusUpdate(elapsedTime);
	    demoLevelUpdate2.cannonUpdate(elapsedTime);
		demoLevelUpdate2.gameUpdate();

	}

	public void gameRender(Graphics2D g) {
		fontManager.getFont("FPS Font").drawString(g, levelRequirement, 20, 15);
		fontManager
				.getFont("FPS Font")
				.drawString(
						g,
						"ENEMIES DESTROYED   " + EnemyBulletCollision.destroyed,
						20, 30);
	}
}
