package ai;

import gameObject.GameLevel;
import gameObject.GameLevel1;
import gameObject.TopDownGameManager;

import java.util.ArrayList;
import java.util.Collection;

import state.State;

import demo.DemoEnemy;

public class BehaviorManager 
{
	protected static EnemyTopDownBehavior behavior;
	static double h;
	static double v;
	protected static ArrayList<EnemyTopDownBehavior> behaviors = new ArrayList<EnemyTopDownBehavior>();
	
	public static void behaviors_List(EnemyTopDownBehavior... behaviours){
		for(EnemyTopDownBehavior level : behaviours){
				behaviors.add(level);
		}
	}
	public static void BehaviorManager(DemoEnemy enemy, int Level)
	{
		for(EnemyTopDownBehavior level : behaviors)
		{
			if(Level <= behaviors.size())
			{
				if (Level == level.getState())
				{
					enemy.setBehavior(level);
				}
			}
			else if (Level > behaviors.size())
			{ 
				h = enemy.getHorizontalSpeed();
				v = enemy.getVerticalSpeed();
				enemy.setSpeed(h + .05, v + .03);
			}
		}
	}
	public void setBehavior(EnemyTopDownBehavior behavior) 
	{
		this.behavior = behavior;
	}
	public static EnemyTopDownBehavior getBehaviour()
	{
		return behavior;
	}
}
