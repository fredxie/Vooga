package element;

import game.Configuration;
import game.TopDownGameObject;

import background.TopDownBackground;
import background.TopDownTileBackground;

import com.golden.gamedev.object.PlayField;

public class TopDownPlayField extends PlayField {

	
private TopDownGameObject game;

public TopDownPlayField(TopDownGameObject object)
{
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
		super.update(elapsedTime);
		this.getBackground().move(0,
				-Configuration.BACKGROUND_SPEED * elapsedTime);
	}

	public TopDownTileBackground getTileBackground() {
		return (TopDownTileBackground) super.getBackground();
	}

	public ElementGroup getGroup(String name) {
		return (ElementGroup) super.getGroup(name);
	}
}
