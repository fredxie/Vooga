package element;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

public abstract class Enemy extends Sprite{
	
	private int hp;

	public Enemy(BufferedImage image){
		super(image);
	}
	
	public abstract void attack();
	
	public void changeHp(int h){
		hp = h;
	}
	
	public int getHp(){
		return hp;
	}
	
	public abstract void death();
	
	public void death(BufferedImage i){
		this.setImage(i);
	}
	
	public void setSpeed(double x,double y){
		this.setSpeed(x, y);
	}
	
	public void setLocation(int x, int y){
		this.setLocation(x, y);
	}
	
	public double getLocationX(){
		return this.getX();
	}
	
	public double getLocationY(){
		return this.getY();
	}
	
	public void setImage(BufferedImage image){
		this.setImage(image);
	}
	
		
}
