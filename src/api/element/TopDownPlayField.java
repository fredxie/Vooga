package api.element;


import api.background.TopDownTileBackground;
import api.gameObject.TopDownGameObject;
import api.util.JsonUtil;

import com.golden.gamedev.object.PlayField;

public abstract class TopDownPlayField extends PlayField {

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
		myElapsedTime = elapsedTime;
		super.update(elapsedTime);
		this.getBackground().move(
				0,
				-JsonUtil.parse("json/paraConfig.json").get("BACKGROUND_SPEED")
						/ 10.0 * elapsedTime);
	}

	public TopDownTileBackground getTileBackground() {
		return (TopDownTileBackground) super.getBackground();
	}

	public ElementGroup getGroup(String name) {
		return (ElementGroup) super.getGroup(name);
	}

	public long getElapsedTime() {
		return myElapsedTime;
	}
	public abstract void init(String s);
}