package gameLevel;

import DemoCollisioSystem.EnemyBulletCollision;

public abstract class GameLevelInit {
	public GameLevel gl;

	public GameLevelInit(GameLevel gl) {
		this.gl = gl;
	}

	public abstract void parametersInit();

	public abstract void backgroundInit();

	public abstract void fighterInit();

	public abstract void blockInit();

	public abstract void bonusInit();

	public abstract void enemyInit();

	public abstract void cannonInit();

	public abstract void collisionInit();

	public abstract void keyInit();

	/***
	 * added by Jiawei initialize the number of killed enemies before the start
	 * of every level Help to fix bugs in restart game and game record display
	 */
	public void gameRecordInit() {
		EnemyBulletCollision.destroyed = 0;
	}
}
