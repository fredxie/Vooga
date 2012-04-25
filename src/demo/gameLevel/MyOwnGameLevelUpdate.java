package demo.gameLevel;

import java.util.List;

import api.element.Fighter;
import api.gameLevel.GameLevelUpdate;

import levelEditor.Load;

public class MyOwnGameLevelUpdate extends GameLevelUpdate {

	public List<List<Object>> list = Load.list;

	public MyOwnGameLevelUpdate(MyOwnGameLevel gl) {
		super(gl);
	}

	public void keyUpdate(long elapsedTime, Fighter fighter) {

	}

	public void playFieldUpdate(long elapsedTime) {
	}

	public void fighterUpdate(long elapsedTime) {

	}

	public void cannonUpdate(long elapsedTime) {

	}

	public void enemyUpdate(long elapsedTime) {

	}

	public void bonusUpdate(long elapsedTime) {

	}

	public void levelComplete() {
	}

	public void gameUpdate() {

	}

}
