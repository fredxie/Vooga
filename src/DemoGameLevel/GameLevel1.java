package DemoGameLevel;

import game.TopDownGameEngine;
import gameLevel.GameLevel;

import java.awt.Graphics2D;

import state.api_State.DefaultLevelState;
import collisionSystem.EnemyBulletCollision;

public class GameLevel1 extends GameLevel {

	public GameLevel1(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLevelState(parent, this);
	}

	public void initResources() {
		DemoLevelInit1 demoLevelInit1 = new DemoLevelInit1(this);
		demoLevelInit1.gameRecordInit();
		demoLevelInit1.parametersInit();
		demoLevelInit1.backgroundInit();
		demoLevelInit1.collisionInit();
		demoLevelInit1.fighterInit();
		demoLevelInit1.blockInit();
		demoLevelInit1.bonusInit();
		demoLevelInit1.enemyInit();
		demoLevelInit1.cannonInit();
		demoLevelInit1.keyInit();
	}

	public void render(Graphics2D g) {
		playfield.render(g);
		gameRender(g);

	}

	public void innerStateUpdate(long elapsedTime) {

		DemoLevelUpdate1 demoLevelUpdate1 = new DemoLevelUpdate1(this);

		demoLevelUpdate1.levelComplete();
		demoLevelUpdate1.keyUpdate(elapsedTime, fighter);
		demoLevelUpdate1.playFieldUpdate(elapsedTime);
		demoLevelUpdate1.enemyUpdate(elapsedTime);
		demoLevelUpdate1.fighterUpdate(elapsedTime);
		demoLevelUpdate1.bonusUpdate(elapsedTime);
		demoLevelUpdate1.cannonUpdate(elapsedTime);
		demoLevelUpdate1.gameUpdate();
		
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
