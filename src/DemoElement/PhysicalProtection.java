package DemoElement;

import java.awt.image.BufferedImage;

import util.JsonUtil;
import util.TopDownAreaUtil;

import com.golden.gamedev.object.Timer;

import configuration.api.GameParameters;
import demo.DemoGameEngine;
import element.AutoFighter;
import element.Element;
import element.RegularFighter;

public  class PhysicalProtection extends AutoFighter {

	Timer resetLocation = new Timer(50);
	double degree = 0;
	public static final double PI = Math.PI;
    
	public PhysicalProtection(BufferedImage image) {
		super(image);
	}

	public PhysicalProtection(BufferedImage image, RegularFighter fighter) {
		super(image);
		master = fighter;
		init();
	}

	public void init() {
		playfield = master.playfield;
		game = master.game;
		setLocation(master.getX() - 0.8 * master.getWidth(), master.getY()
				- 0.5 * master.getWidth());
	}

	public void fighterControl(long elapsedTime) {
		degree = degree + 8;
		if (resetLocation.action(elapsedTime)) {
			setLocation(master.getX() - master.getWidth(), master.getY() - 0.3
					* master.getWidth());
			degree = 0;
			resetLocation = new Timer(1000);
		}

		if (master.isActive()) {
			setSpeed(
					Math.sin(PI * degree / 180) * master.getWidth() * 0.01
							+ master.getHorizontalSpeed() * 0.5,
					Math.cos(PI * degree / 180)
							* master.getWidth()
							* 0.01
							+ master.getVerticalSpeed()
							* 0.6
							+ 0.01
							* backgroundSpeed);
			TopDownAreaUtil.setAutoFighterArea(this,
					playfield.getTileBackground(), DemoGameEngine.HEIGHT,
					DemoGameEngine.WIDTH);
		} else
			setActive(false);
	}



	public void setBrinkVerticalSpeed() {
		setVerticalSpeed(Math.cos(6 * PI * degree / 180)
				* master.getWidth()
				* 0.01
				- backgroundSpeed);
	}

	public void setBrinkHorizontalSpeed() {
		setHorizontalSpeed(Math.sin(6 * PI * degree / 180) * master.getWidth()
				* 0.01);
	}

	@Override
	public Element clone() {
		 PhysicalProtection PP=new PhysicalProtection(this.getImage());
		 PP.init();
		return PP;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
