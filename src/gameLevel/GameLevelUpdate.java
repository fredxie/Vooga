package gameLevel;

import element.Fighter;

public abstract class GameLevelUpdate {
	public GameLevel gl;

	public GameLevelUpdate(GameLevel gl) {
		this.gl = gl;
	}

	public abstract void keyUpdate(long elapsedTime, Fighter fighter);

	public abstract void playFieldUpdate(long elapsedTime);

	public abstract void fighterUpdate(long elapsedTime);

	public abstract void cannonUpdate(long elapsedTime);

	public abstract void enemyUpdate(long elapsedTime);

	public abstract void bonusUpdate(long elapsedTime);

	public abstract void levelComplete();

	public abstract void gameUpdate();
}
