package api.spawn;

import umontreal.iro.lecuyer.probdist.ExponentialDist;
import umontreal.iro.lecuyer.probdist.NormalDist;

public class SpawnByIncreasingElement implements SpawnBehavior{
	private double x;
	private double y;
	private double myWaveLength=0.3;
	private int myTotalWaveNum;
	private double lambda;

	public SpawnByIncreasingElement(int groupNum){
		
		x=0;
		y=0;
		myTotalWaveNum=groupNum;
		lambda=0.5;
	}
	
	@Override
	public double[] spawn() {
		
		x=Math.random();
		
		double posPercentage= ExponentialDist.inverseF(lambda,Math.random())/10;
		if (posPercentage>0.9)
			posPercentage=0.9;
		int waveNum = (int) ((int)myTotalWaveNum*posPercentage);
		if(waveNum<1)
			waveNum=1;
		else if (waveNum>myTotalWaveNum)
			waveNum=myTotalWaveNum;
		y=calculateY(waveNum, myTotalWaveNum);
		
		double[] loc = new double[2];
		loc[0] = x;
		loc[1] = y;
		return loc;

	}
	
	
	/**
	 * 
	 * @param scale  means the range in y coordinate
	 * @param waveNumber  represents i-th wave
	 * @param totalWave represents the total number of waves
	 * @return the Y coordinate or enemy
	 * @Description use Normal distribution in each wave to calculate Y coordinate
	 */
	private double calculateY(int waveNumber, int totalWave){


		double distanceBetweenWave=myWaveLength/totalWave;

		double groupPosition=distanceBetweenWave*waveNumber;//Return the mean position of this group

		double relativePosition=(NormalDist.inverseF01(Math.random())/6)*distanceBetweenWave;

		double pos=groupPosition+relativePosition;
		
		if(pos>0.9)
			pos=0.9;
		else if(pos<0.1)
			pos=0.1;
		
		return pos;
		
	}

	@Override
	public boolean checkIfSpawn() {
		// TODO Auto-generated method stub
		return true;
	}
}
