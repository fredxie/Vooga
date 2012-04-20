
/**
 * @author Gang Song
 */
package element;

import umontreal.iro.lecuyer.probdist.NormalDist;
import util.TopDownUtility;

public class SpawnByLocation implements SpawnBehavior{

	private double x;
	private double y;

	private double Scale_X;
	private double Scale_Y;


	public SpawnByLocation(){
		x=0;
		y=0;
		Scale_Y=0.9;
		Scale_X=1;
	}

	@Override
	public double[] spawn(int k) {

		x=calculateX(Scale_X);

	    y=calculateY(Scale_Y, TopDownUtility.getRandom(1, k), k);

	    double[] loc=new double[2];
	    loc[0]=x;
	    loc[1]=y;
	    return loc;
		// TODO Auto-generated method stub
	}

	private double calculateX(double scale){

		return Math.random()*scale;

	}

	/**
	 * 
	 * @param scale  means the range in y coordinate
	 * @param waveNumber  represents i-th wave
	 * @param totalWave represents the total number of waves
	 * @return the Y coordinate or enemy
	 * @Description use Normal distribution in each wave to calculate Y coordinate
	 */
	private double calculateY(double scale, int waveNumber, int totalWave){

		double y=0;

		double distanceBetweenWave=scale/totalWave;

		double groupPosition=(distanceBetweenWave*waveNumber+(1-scale)/2);//Return the mean position of this group

		double relativePosition=(NormalDist.inverseF01(Math.random())/6)*distanceBetweenWave;

		y=groupPosition+relativePosition;

		return y;

	}

	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}




}