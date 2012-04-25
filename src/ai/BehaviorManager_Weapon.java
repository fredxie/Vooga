package ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import api.element.Enemy;

import demo.element.Missile;


public class BehaviorManager_Weapon {
	static double h;
	static double v;
	protected static ArrayList<AI> behaviors = new ArrayList<AI>();
	protected static Map<AI,Integer> map = new HashMap<AI,Integer>();
	static AI rightBrain;

	public static void behavior_Map(AI brains, int level){
		if(!map.containsKey(brains)){
			map.put(brains, level);
		}
		behaviors.add(brains);
	}
	public static AI BehaviorManager(Missile missile, int Level) {
		for (AI brain : behaviors) {
			if (Level <= behaviors.size()) {
				if(map.containsKey(brain)){
					if (Level == map.get(brain)){
						rightBrain = brain;
					}
				}
			} else if (Level > behaviors.size()) {
				h = missile.getHorizontalSpeed();
				v = missile.getVerticalSpeed();
				missile.setSpeed(h + .02, v + .03);
			}
		}
		behaviors.clear();
		map.clear();
		return rightBrain;
	}
}