package DemoGameLevel;

import gameLevel.GameLevelUpdate;

import java.awt.event.KeyEvent;

import DemoLevelTransition.DemoLevelTransition;

import levelTransition.LevelTransition;

import collisionSystem.EnemyBulletCollision;

import playerState.AssistanceState;
import util.TopDownImageUtil;
import configuration.KeyPressedSubject;
import demo.DemoGameEngine;
import demo.DemoProtection;

public class DemoLevelUpdate1 extends GameLevelUpdate{

	public DemoLevelUpdate1(GameLevel1 gl) {
		super(gl);
	}

	public void keyUpdate(long elapsedTime) {
		KeyPressedSubject.getInstance().notifyObservers(elapsedTime);
	}

	public void playFieldUpdate(long elapsedTime) {
		gl.playfield.update(elapsedTime);
	}

	public void fighterUpdate(long elapsedTime) {
		gl.fighter.refresh(elapsedTime);
		if (gl.keyDown(KeyEvent.VK_SPACE) && !gl.showSatellite) {
			gl.showSatellite = true;
			gl.fighter.getAssistanceState().changeState(
					new DemoProtection(TopDownImageUtil
							.getImage("images/game/Satellite.png"), gl.fighter));
			((AssistanceState) gl.fighter.getAssistanceState()).genAssistance();
		}
	
	}

	public void cannonUpdate(long elapsedTime) {
		for (int i = 0; i < gl.cannonNum; i++) {
			gl.cannon.get(i).refresh(elapsedTime);
		}
	}

	public void enemyUpdate(long elapsedTime) {
		for (int i = 0; i < gl.juniorEnemies.size(); i++) {
			gl.juniorEnemies.get(i).refresh(elapsedTime);
			double h = gl.juniorEnemies.get(i).getHorizontalSpeed();
			double v = gl.juniorEnemies.get(i).getVerticalSpeed();
			if (gl.juniorEnemies.get(i).getX() <= 0
					|| gl.juniorEnemies.get(i).getX() >= DemoGameEngine.WIDTH
							- ((gl.juniorEnemies.get(i).getWidth()))) {
				gl.juniorEnemies.get(i).setSpeed(-h, v);
			}
		}

		gl.juniorEnemies.addAll(gl.enemySpawner.spawn());
	}

	public void bonusUpdate(long elapsedTime) {
		for (int i = 0; i < gl.bonuses.size(); i++) {
			gl.bonuses.get(i).refresh(elapsedTime);
		}
	}

	
	public void levelComplete() {
		if (EnemyBulletCollision.destroyed >= 1
				||gl.playfield.getBackground().getY() == 0) {
			gl.levelComplete = true;
			gl.playfield.clearPlayField();
		}
	}

	public void gameUpdate() {
		LevelTransition lt = new DemoLevelTransition(gl);
		lt.gameOver();
	}
}
