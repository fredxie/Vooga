package ai;

import gameLevel.GameLevel;
import gameObject.TopDownGameManager;

import java.util.ArrayList;
import java.util.Collection;

import DemoGameLevel.GameLevel1;

import state.State;

import demo.DemoEnemy;
import element.Missile;

public class BehaviorManager_Weapon
{
	protected static EnemyTopDownBehavior behavior;
	static double h;
	static double v;
	protected static ArrayList<AI> behaviors = new ArrayList<AI>();
	static AI rightBrain;
	
	public static void behaviors_List(AI... brains){
		for(AI brain : brains){
				behaviors.add(brain);
		}
	}
	public static AI BehaviorManager(Missile missile, int Level)
	{
		for(AI brain : behaviors)
		{
			if(Level <= behaviors.size())
			{
				if (Level == brain.getState())
				{
					rightBrain = brain;
					System.out.print(rightBrain + "\n");
				}
			}
			else if (Level > behaviors.size())
			{ 
				h = missile.getHorizontalSpeed();
				v = missile.getVerticalSpeed();
				missile.setSpeed(h + .02, v + .03);
			}
		}
		behaviors.clear();
		return rightBrain;
	}
}	