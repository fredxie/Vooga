package demo.gameLevel;

import api.configuration.KeyPressedSubject;
import api.element.Fighter;
import api.gameLevel.GameLevel;
import api.gameLevel.GameLevelUpdate;
import demo.collisionSystem.EnemyBulletCollision;
import demo.game.DemoGameEngine;


public class DemoLevelUpdate2 extends GameLevelUpdate {
	public DemoLevelUpdate2(GameLevel gl) {
		super(gl);
	}

	public void keyUpdate(long elapsedTime, Fighter fighter) {
		KeyPressedSubject.getInstance().notifyObservers(elapsedTime, fighter);
	}

	public void playFieldUpdate(long elapsedTime) {
		gl.playfield.update(elapsedTime);
	}

	public void fighterUpdate(long elapsedTime) {
		gl.fighter.refresh(elapsedTime);
	}

	public void enemyUpdate(long elapsedTime) {
		// update Enemies
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
	}

	public void bonusUpdate(long elapsedTime) {

		for (int i = 0; i < gl.bonuses.size(); i++) {
			gl.bonuses.get(i).refresh(elapsedTime);
		}
	}


	public void levelComplete() {
		if (EnemyBulletCollision.destroyed >= 20
				|| gl.playfield.getBackground().getY() == 0) {
			gl.levelComplete = true;
			gl.playfield.clearPlayField();
		}
	}

	public void gameUpdate() {
		if (gl.fighter.getLifeNum() == 0) {
			gl.gameOver = true;
			gl.playfield.clearPlayField();
		}
	}
}
