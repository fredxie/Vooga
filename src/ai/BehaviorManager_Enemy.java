package ai;

import gameLevel.GameLevel;
import gameObject.api_GameObject.TopDownGameManager;

import java.util.ArrayList;
import java.util.Collection;

import DemoGameLevel.GameLevel1;

import state.api.State;

import demo.DemoEnemy;

public class BehaviorManager_Enemy {
	protected static EnemyTopDownBehavior behavior;
	static double h;
	static double v;
	protected static ArrayList<AI> behaviors = new ArrayList<AI>();
	static AI rightBrain;

	public static void behaviors_List(AI... brains) {
		for (AI brain : brains) {
			behaviors.add(brain);
		}
	}

	public static AI BehaviorManager(DemoEnemy enemy, int Level) {
		for (AI brain : behaviors) {
			if (Level <= behaviors.size()) {
				if (Level == brain.getState()) {
					rightBrain = brain;
					System.out.print(rightBrain + "\n");
				}
			} else if (Level > behaviors.size()) {
				h = enemy.getHorizontalSpeed();
				v = enemy.getVerticalSpeed();
				enemy.setSpeed(h + .05, v + .03);
			}
		}
		behaviors.clear();
		return rightBrain;
	}
}
// public static void behaviors_List(EnemyTopDownBehavior... behaviours){
// for(EnemyTopDownBehavior level : behaviours){
// behaviors.add(level);
// }
// }
// public static void BehaviorManager(DemoEnemy enemy, int Level)
// {
// for(EnemyTopDownBehavior level : behaviors)
// {
// if(Level <= behaviors.size())
// {
// if (Level == level.getState())
// {
// enemy.setBehavior(level);
// System.out.print(behaviors.size() + "\n");
// }
// }
// else if (Level > behaviors.size())
// {
// h = enemy.getHorizontalSpeed();
// v = enemy.getVerticalSpeed();
// enemy.setSpeed(h + .05, v + .03);
// }
// }
// behaviors.clear();
// }
// public void setBehavior(EnemyTopDownBehavior behavior)
// {
// this.behavior = behavior;
// }
// public static EnemyTopDownBehavior getBehaviour()
// {
// return behavior;
// }
// }
