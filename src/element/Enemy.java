package element;

import java.awt.image.BufferedImage;

public abstract class Enemy extends Element{
	
	private int healthPoint;

	public Enemy(BufferedImage image){
		super(image);
	}
	
	public abstract void attack();
	
	public void setHP(int healthPoint){
		this.healthPoint = healthPoint;
	}
	
	public int getHP(){
		return healthPoint;
	}
	
//	public abstract void death();
	
	public void death(BufferedImage i){
		this.setImage(i);
	}
	
}
