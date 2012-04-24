package demo;

import java.awt.image.BufferedImage;

import DemoElement.PhysicalProtection;

import element.Element;

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
	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return new DemoProtection(this.getImage());
	}

}
