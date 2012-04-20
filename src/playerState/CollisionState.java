package playerState;

import com.golden.gamedev.object.Timer;

import element.Fighter;

public class CollisionState extends PlayerState{
	protected String collisionID;
	CollisionState collisionState; 
	
//	Timer shieldLength = new Timer(5000);
	
//	public CollisionState(Fighter fighter, CollisionState collisionState) {
//		super(fighter);
//		this.collisionState=collisionState;
//		
//	}
	
	public CollisionState(Fighter fighter) {
		super(fighter);
		collisionState = this;

	}
	
    public void changeState(Object collisionState)
    {
    	this.collisionState = (CollisionState) collisionState;
    	collisionID =this.collisionState.getID();
    }
    
	public String getID()
	{
		return collisionID;
	}
	
	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		collisionState.update(elapsedTime);
		
	}
	
   

}
