package api.gameLevel;

import api.element.Fighter;

/**
 * This class is a game level update manager for developer to manage the update
 * of different game levels
 * 
 * @param gl
 *            current game level
 * 
 * @author Chenbo Zhu
 */
public abstract class GameLevelUpdate {
	public GameLevel gl;

	public GameLevelUpdate(GameLevel gl) {
		this.gl = gl;
	}

	/**
	 * all things update
	 */
	public void updateAll(long elapsedTime, Fighter fighter) {
		keyUpdate(elapsedTime, fighter);
		playFieldUpdate(elapsedTime);
		fighterUpdate(elapsedTime);
		enemyUpdate(elapsedTime);
		bonusUpdate(elapsedTime);
		levelComplete();
		gameUpdate();
	}

	/**
	 * key setting update
	 * 
	 * @param elapsedTime
	 * @param fighter
	 */
	public abstract void keyUpdate(long elapsedTime, Fighter fighter);

	/**
	 * playfield update
	 * 
	 * @param elapsedTime
	 */
	public abstract void playFieldUpdate(long elapsedTime);

	/**
	 * fighter update
	 * 
	 * @param elapsedTime
	 */
	public abstract void fighterUpdate(long elapsedTime);

	/**
	 * enemy update
	 * 
	 * @param elapsedTime
	 */
	public abstract void enemyUpdate(long elapsedTime);

	/**
	 * bonus update
	 * 
	 * @param elapsedTime
	 */
	public abstract void bonusUpdate(long elapsedTime);

	/**
	 * check whether current game level state achieve the level complete
	 * requirement for game level update
	 */
	public abstract void levelComplete();

	/**
	 * game finish update
	 */
	public abstract void gameUpdate();
}
