package api.gameLevel;

import demo.collisionSystem.EnemyBulletCollision;

/**
 * This class is a game level initialization manager for developer to manage the
 * initialization of different game levels
 * 
 * @param gl
 *            current game level
 * 
 * @author Chenbo Zhu
 */
public abstract class GameLevelInit {
	public GameLevel gl;

	public GameLevelInit(GameLevel gl) {
		this.gl = gl;
	}

	/**
	 * parameter initialization
	 */
	public abstract void parametersInit();

	/**
	 * background initialization
	 */
	public abstract void backgroundInit();

	/**
	 * fighter initialization
	 */
	public abstract void fighterInit();

	/**
	 * block initialization
	 */
	public abstract void blockInit();

	/**
	 * bonus initialization
	 */
	public abstract void bonusInit();

	/**
	 * enemy initialization
	 */
	public abstract void enemyInit();

	/**
	 * cannon initialization
	 */
	public abstract void cannonInit();

	/**
	 * collision system initialization
	 */
	public abstract void collisionInit();

	/**
	 * key setting initialization
	 */
	public abstract void keyInit();

	/***
	 * added by Jiawei initialize the number of killed enemies before the start
	 * of every level Help to fix bugs in restart game and game record display
	 * 
	 */
	public void gameRecordInit() {
		EnemyBulletCollision.destroyed = 0;
	}
}
