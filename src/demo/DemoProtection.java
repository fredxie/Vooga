package demo;

import java.awt.image.BufferedImage;

import element.PhysicalProtection;
import element.RegularFighter;

public  class DemoProtection extends PhysicalProtection{

	public DemoProtection(BufferedImage image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	public DemoProtection(BufferedImage image, RegularFighter fighter) {
		super(image,fighter);
		playfield.add(this);
	}

}
