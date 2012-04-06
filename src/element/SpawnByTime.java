/**
 * @author Gang Song
 */

package element;

public class SpawnByTime implements SpawnBehavior{

	private double x;
	private double y;
	//private SpawnBehavior spawn;
	
	public SpawnByTime(){
		x=0;
		y=0;
	}
	
	
	
	@Override
	public double[] spawn(int t) {
		
		
		
		 double[] loc=new double[2];
		    loc[0]=x;
		    loc[1]=y;
		    return loc;
		// TODO Auto-generated method stub
		
	}

}
