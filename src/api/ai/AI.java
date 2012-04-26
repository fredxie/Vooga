package api.ai;

import com.golden.gamedev.object.Sprite;

public abstract class AI {
	protected Sprite mySprite;
	public static double ENEMY_WEAPON_DAMAGE = .25;
	public static double ENEMY_HP = 1;

	public void setSprite(Sprite s) {
		mySprite = s;
	}

	public abstract void refresh(long elaspedTime);
}
