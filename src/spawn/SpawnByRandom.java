package spawn;

import util.TopDownUtility;
import demo.DemoGameEngine;

public class SpawnByRandom implements SpawnBehavior {

	private double x;
	private double y;

	public SpawnByRandom() {
		x = 0;
		y = 0;
	}

	@Override
	public double[] spawn() {

		x = Math.random();
		y = Math.random();

		double[] loc = new double[2];
		loc[0] = x;
		loc[1] = y;
		return loc;
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return true;
	}

}
