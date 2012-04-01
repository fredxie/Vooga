package element;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

public abstract class Element extends Sprite{
	
	public Element(BufferedImage image) {
		super(image);
	}
	
	public Element(){
		super();
	}

	public void setSpeed(double x,double y){
		super.setSpeed(x, y);
	}
	
	public void setLocation(int x, int y){
		super.setLocation(x, y);
	}
	
	public double getX(){
		return super.getX();
	}
	
	public double getY(){
		return super.getY();
	}
	
	public void setImage(BufferedImage image){
		super.setImage(image);
	}
}
