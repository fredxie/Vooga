package element;

import util.JsonUtil;
import game.Configuration;
import gameObject.api_GameObject.TopDownGameObject;

import background.TopDownBackground;
import background.TopDownTileBackground;

import com.golden.gamedev.object.PlayField;

import configuration.api.GameParameters;

public class TopDownPlayField extends PlayField {

	private TopDownGameObject game;
	private long myElapsedTime; 

	public TopDownPlayField(TopDownGameObject object) {
		super();
		game = object;
	}

	public TopDownGameObject getGame() {
		return game;
	}

	public void setGame(TopDownGameObject game) {
		this.game = game;
	}

	public ElementGroup addGroup(ElementGroup eg) {
		return (ElementGroup) super.addGroup(eg);
	}

	public void update(long elapsedTime) {
		myElapsedTime=elapsedTime;
		super.update(elapsedTime);
		this.getBackground().move(
				0,
				-JsonUtil.parse("paraConfig.json").get(
						GameParameters.BACKGROUND_SPEED)
						/ 10.0 * elapsedTime);
	}

	public TopDownTileBackground getTileBackground() {
		return (TopDownTileBackground) super.getBackground();
	}

	public ElementGroup getGroup(String name) {
		return (ElementGroup) super.getGroup(name);
	}
	
	public long getElapsedTime(){
		return myElapsedTime;
	}
}