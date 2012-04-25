/**
 * @author Gang Song
 */

package api.spawn;

import umontreal.iro.lecuyer.probdist.NormalDist;

import api.element.Fighter;

import com.golden.gamedev.object.Timer;


public class SpawnByTime implements SpawnBehavior {

	private double x;
	private double y;
	// private SpawnBehavior spawn;

	private Timer myTimer;
	// private long myElapsedTime;
	private Fighter myFighter;
	private double myWaveLength;

	public SpawnByTime(Fighter ft) {
		x = -10;// indicates enemy's location is out of map if it has not been
				// spawned
		y = -10;
		myFighter = ft;
		myWaveLength = 0.1;
		myTimer = new Timer(9000);
	}

	public SpawnByTime(Fighter ft, Timer timer) {
		x = -10;// indicates enemy's location is out of map if it has not been
				// spawned
		y = -10;
		myFighter = ft;
		myWaveLength = 0.1;
		myTimer = timer;
	}

	@Override
	public double[] spawn() {

		x = Math.random();

		double relativePosition = (NormalDist.inverseF01(Math.random()) / 6)
				* myWaveLength;

		double positionBaseline = myFighter.getY()
				/ (myFighter.playfield.getBackground().getHeight()) * 0.98;

		y = positionBaseline + relativePosition;

		double[] loc = new double[2];
		loc[0] = x;
		loc[1] = y;
		return loc;
	}

	public boolean checkIfSpawn() {

		boolean state = myTimer.action(myFighter.playfield.getElapsedTime());
		if (state) {
			myTimer.refresh();
		}
		return state;
	}

}
