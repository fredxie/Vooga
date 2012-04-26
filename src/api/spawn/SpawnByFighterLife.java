package api.spawn;

import umontreal.iro.lecuyer.probdist.NormalDist;
import api.element.Fighter;

public class SpawnByFighterLife implements SpawnBehavior {

	public Fighter myFighter;
	private double x;
	private double y;
	private int myBootLevel;
	private double myWaveLength;
	private boolean hasSpawn;

	public SpawnByFighterLife(Fighter fighter, int lifeNumber) {
		x = 0;
		y = 0;
		myFighter = fighter;
		myBootLevel = lifeNumber;
		myWaveLength = 0.1;
		hasSpawn = false;
	}

	/**
	 * @param i
	 *            indicates if the fighter's number of lives is smaller than i,
	 *            the enemy will be generated
	 */
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

	public int getBootLevel() {

		return myBootLevel;

	}

	/**
	 * @param length
	 *            , should be between 0 and 1
	 */
	public void setWaveLength(double length) {
		myWaveLength = length - Math.floor(length);
	}

	@Override
	public boolean checkIfSpawn() {
		// myFighter.
		if (hasSpawn == false && myFighter.getLifeNum() <= myBootLevel) {
			hasSpawn = true;
			return true;
		}
		return false;

	}

}
