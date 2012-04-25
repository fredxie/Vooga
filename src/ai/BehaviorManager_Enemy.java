package ai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import demo.element.DemoEnemy;
import demo.gameLevel.GameLevel1;

import api.element.Enemy;
import api.gameLevel.GameLevel;
import api.gameObject.TopDownGameManager;
import api.state.State;

public class BehaviorManager_Enemy {
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
	public static AI BehaviorManager(Enemy enemy, int Level) {
		for (AI brain : behaviors) {
			if (Level <= behaviors.size()) {
				if(map.containsKey(brain)){
					if (Level == map.get(brain)){
						rightBrain = brain;
					}
				}
			} else if (Level > behaviors.size()) {
				h = enemy.getHorizontalSpeed();
				v = enemy.getVerticalSpeed();
				enemy.setSpeed(h + .05, v + .03);
			}

		}
		behaviors.clear();
		map.clear();
		return rightBrain;
	}
}
