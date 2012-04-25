package ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import api.element.Enemy;
import api.element.Weapon;

public class BehaviorManager {
	static double h;
	static double v;
	protected static ArrayList<AI> e_behaviors = new ArrayList<AI>();
	protected static ArrayList<AI> w_behaviors = new ArrayList<AI>();
	protected static Map<AI,Integer> w_map = new HashMap<AI,Integer>();
	protected static Map<AI,Integer> e_map = new HashMap<AI,Integer>();
	static AI rightBrain;

	public static void enemy_Map(AI brains, int level){
		System.out.println(level);
		if(!e_map.containsKey(brains)){
			e_map.put(brains, level);
		}
		e_behaviors.add(brains);
	}
	public static void weapon_Map(AI brains, int level){
		if(!w_map.containsKey(brains)){
			w_map.put(brains, level);
		}
		w_behaviors.add(brains);
	}
	public static AI eBehaviorManager(Enemy enemy, int Level) {
		for (AI brain : e_behaviors) {
			if (Level <= e_behaviors.size()) {
				if(e_map.containsKey(brain)){
					if (Level == e_map.get(brain)){
						
						rightBrain = brain;
					}
				}
			} else if (Level > e_behaviors.size()) {
				h = enemy.getHorizontalSpeed();
				v = enemy.getVerticalSpeed();
				enemy.setSpeed(h + .05, v + .03);
			}

		}
		e_behaviors.clear();
		e_map.clear();
		return rightBrain;
	}
	public static AI wBehaviorManager(Weapon missile, int Level) {
		for (AI brain : w_behaviors) {
			if (Level <= w_behaviors.size()) {
				if(w_map.containsKey(brain)){
					if (Level == w_map.get(brain)){
						rightBrain = brain;
					}
				}
			} else if (Level > w_behaviors.size()) {
				h = missile.getHorizontalSpeed();
				v = missile.getVerticalSpeed();
				missile.setSpeed(h + .02, v + .03);
			}

		}
		w_behaviors.clear();
		w_map.clear();
		return rightBrain;
	}
}
