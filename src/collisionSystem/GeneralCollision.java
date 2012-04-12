package collisionSystem;

import java.util.List;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.CollisionGroup;

public class GeneralCollision extends CollisionGroup{
	
	{ pixelPerfectCollision = true; }
	
	private List<CoolCollision> list;
	
	public GeneralCollision(List<CoolCollision> coolList)
	{
		super();
		list = coolList;
	}

	@Override
	public void collided(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		for (CoolCollision collision : list)
			collision.oncollide(s1, s2);
	}

}
