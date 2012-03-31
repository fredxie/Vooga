package collision;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

public abstract class DestroyedBoth extends BasicCollisionGroup{

	public void collided(Sprite s1, Sprite s2) {
		s1.setActive(false);
		s2.setActive(false);
		record();
	}
	
	public abstract void record();

}
