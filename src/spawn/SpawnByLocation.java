
/**
 * @author Gang Song
 * @Description This location spawning behavior will not generate an exact location based on the input parameter
 *              in the constructor, but will generate a group of enemy with a normal distribution for their location
 */
package spawn;

import umontreal.iro.lecuyer.probdist.NormalDist;

public class SpawnByLocation implements SpawnBehavior{

	private double x;
	private double y;

	private double myWaveLength=0.1;


	public SpawnByLocation(){
		x=0;
		y=0;

	}
	
	/**
	 * 
	 * @param Y_Location: this parameter means you should input a decimal value (between 0 and 1) to
	 *                            indicate the approximate position on the entire map of the group of enemy
	 *                            0 means at the top of the map and 1 means at the bottom of the map.
	 *                            If the input is larger than 1, the program only extracts its decimal part. 
	 */
	public SpawnByLocation(double Y_Location){
		
		x=Math.random();
		y=Y_Location-Math.floor(Y_Location);
	}
//	
//	public SpawnByLocation(double X_Location, double Y_Location){
//		
//		x=X_Location-Math.floor(X_Location);
//		y=Y_Location-Math.floor(Y_Location);
//	}

	@Override
	public double[] spawn() {

		//x=calculateX(Scale_X);

		y=calculateY(y);
		
	    //y=calculateY(Scale_Y, TopDownUtility.getRandom(1, k), k);

	    double[] loc=new double[2];
	    loc[0]=x;
	    loc[1]=y;
	    return loc;
	}
//
//	private double calculateX(double scale){
//
//		return Math.random()*scale;
//
//	}

	private double calculateY(double groupPosition){
		
		
		double relativePosition=(NormalDist.inverseF01(Math.random())/6)*myWaveLength;

		double pos=groupPosition+relativePosition;

		return pos;
	}
	
	/**
	 * 
	 * @param length, should be between 0 and 1
	 */
	
	public void setWaveLength(double length){
		myWaveLength=length-Math.floor(length);
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 
	 * @param scale  means the range in y coordinate
	 * @param waveNumber  represents i-th wave
	 * @param totalWave represents the total number of waves
	 * @return the Y coordinate or enemy
	 * @Description use Normal distribution in each wave to calculate Y coordinate
	 */
//	private double calculateY(double scale, int waveNumber, int totalWave){
//
//		double y=0;
//
//		double distanceBetweenWave=scale/totalWave;
//
//		double groupPosition=(distanceBetweenWave*waveNumber+(1-scale)/2);//Return the mean position of this group
//
//		double relativePosition=(NormalDist.inverseF01(Math.random())/6)*distanceBetweenWave;
//
//		y=groupPosition+relativePosition;
//
//		return y;
//
//	}
//
//	public double getX(){
//		return x;
//	}
//	public double getY(){
//		return y;
//	}





}