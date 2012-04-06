package element;

import game.Configuration;

import background.TopDownBackground;
import background.TopDownTileBackground;

import com.golden.gamedev.object.PlayField;

public class TopDownPlayField extends PlayField {

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
