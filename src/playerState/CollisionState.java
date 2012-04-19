package playerState;

import com.golden.gamedev.object.Timer;

import element.Fighter;

public abstract class CollisionState extends PlayerState{
	protected String collisionID;
	CollisionState collisionState; 
//	Timer shieldLength = new Timer(5000);
	
	public CollisionState(Fighter fighter) {
		super(fighter);
		
	}
    public void changeState(Object collisionState)
    {
    	this.collisionState = (CollisionState)collisionState;
    }
    
	public String getID()
	{
		return collisionID;
	}
   

}
