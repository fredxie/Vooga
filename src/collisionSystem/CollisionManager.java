package collisionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import element.ElementGroup;
import element.TopDownPlayField;

public class CollisionManager {
	
	private TopDownPlayField playfield;
	private HashMap<String, List<CoolCollision>> actionMap;
	
	
	public CollisionManager(TopDownPlayField playfield)
	{
		this.playfield=playfield;
		actionMap = new HashMap<String,List<CoolCollision>>();
	}
	
	
	public void registerCollision(String s1,String s2, CoolCollision collide)
	{
		if(playfield.getGroup(s1)==null)
			playfield.addGroup(new ElementGroup(s1));
		if(playfield.getGroup(s2)==null)
			playfield.addGroup(new ElementGroup(s2));
		String collisionType = s1+s2;
		
		if(!actionMap.containsKey(collisionType))
		{
			ArrayList<CoolCollision> list = new ArrayList<CoolCollision>();
			actionMap.put(collisionType, list);
			playfield.addCollisionGroup(playfield.getGroup(s1), playfield.getGroup(s2), new GeneralCollision(list));
		}
		actionMap.get(collisionType).add(collide);
	}

}
