package element;

import java.awt.image.BufferedImage;

public class RegularEnemy extends Enemy{

	public RegularEnemy(BufferedImage image) {
		super(image);
		this.mySpawnBehavior=new SpawnByLocation();// TODO Auto-generated constructor stub
	}

	
	

	@Override
	public void attack(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
