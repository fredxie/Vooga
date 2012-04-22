package gameLevel;

import configuration.KeyPressedSubject;
import demo.DemoGameEngine;

public class DemoLevelUpdate1 {

	public void keyUpdate(long elapsedTime) {
		KeyPressedSubject.getInstance().notifyObservers(elapsedTime);
	}

	public void playFieldUpdate(GameLevel1 gl, long elapsedTime) {
		gl.playfield.update(elapsedTime);
	}

	public void fighterUpdate(GameLevel1 gl, long elapsedTime) {
		gl.fighter.refresh(elapsedTime);
//		gl.fighter.bomb(elapsedTime);
	
	}

	public void cannonUpdate(GameLevel1 gl, long elapsedTime) {
		for (int i = 0; i < gl.cannonNum; i++) {
			gl.cannon.get(i).refresh(elapsedTime);
		}
	}

	public void enemyUpdate(GameLevel1 gl, long elapsedTime) {
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

		gl.juniorEnemies.addAll(gl.enemySpawner1.spawn());
	}

	public void bonusUpdate(GameLevel1 gl, long elapsedTime) {
		for (int i = 0; i < gl.bonuses.size(); i++) {
			gl.bonuses.get(i).refresh(elapsedTime);
		}
	}

	public void gameUpdate(GameLevel1 gl, long elapsedTime) {
		if (gl.fighter.getLifeNum() == 0) {
			gl.gameOver = true;
		}
	}
}
