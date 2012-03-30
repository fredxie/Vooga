package element;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;


public class Weapon extends Sprite{
	
	private double damage;
	private double style;
	
	public Weapon(BufferedImage image, double damage, double style){
		super(image);
		this.damage = damage;
		this.style = style;
	}
	
	public void fire() {
		//do something
	}

}
