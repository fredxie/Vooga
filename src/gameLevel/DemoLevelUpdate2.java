package gameLevel;

import configuration.KeyPressedSubject;
import demo.DemoGameEngine;

public class DemoLevelUpdate2 {
	public void keyUpdate(long elapsedTime) {
		KeyPressedSubject.getInstance().notifyObservers(elapsedTime);
	}

	public void playFieldUpdate(GameLevel2 gl, long elapsedTime) {
		gl.playfield.update(elapsedTime);
	}

	public void fighterUpdate(GameLevel2 gl, long elapsedTime) {
		gl.fighter.refresh(elapsedTime);
		gl.fighter.bomb(elapsedTime);
	}

	public void enemyUpdate(GameLevel2 gl, long elapsedTime) {
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

	public void bonusUpdate(GameLevel2 gl, long elapsedTime) {

		for (int i = 0; i < gl.bonusNum; i++) {
			gl.bonuses.get(i).refresh(elapsedTime);
		}
	}

	public void gameUpdate(GameLevel2 gl, long elapsedTime) {
		if (gl.fighter.getLifeNum() == 0) {
			gl.gameOver = true;
		}
	}
}
