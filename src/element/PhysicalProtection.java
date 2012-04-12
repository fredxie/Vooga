package element;

import game.Configuration;
import game.TopDownGameObject;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Timer;

import configuration.GameParameters;

import demo.DemoGameEngine;

import util.JsonUtil;
import util.TopDownAreaUtil;
import util.TopDownImageUtil;

public abstract class PhysicalProtection extends AutoFighter{

    Timer resetLocation = new Timer(100);
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



	public void init()
	{  
		playfield = master.playfield;
		game = master.game;
		setLocation(master.getX()-0.8*master.getWidth(), master.getY()-0.5*master.getWidth());
	}

	public void fighterControl(long elapsedTime) {
		degree = degree+8;
		if(resetLocation.action(elapsedTime))
		{
			setLocation(master.getX()-0.5*master.getWidth(), master.getY()-0.3*master.getWidth());
			degree = 0;
			resetLocation = new Timer(3000);
		}
		
		if(master.isActive())
		{
			setSpeed(Math.sin(PI * degree / 180)*master.getWidth()*0.01+master.getSpeedX(),Math.cos(PI * degree / 180)*master.getWidth()*0.01+master.getSpeedY());
			TopDownAreaUtil.setAutoFighterArea(this, playfield.getTileBackground(),
					DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
		}
		else
			setActive(false);
	}

	@Override
	public void attack(long elapsedTime, int weaponStyle, double weaponDamage2) {
		
	}
    public void setBrinkVerticalSpeed()
    {
    	setVerticalSpeed(Math.cos(6*PI * degree / 180)*master.getWidth()*0.01-JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED));
    }
    public void setBrinkHorizontalSpeed()
    {
    	setHorizontalSpeed(Math.sin(6*PI * degree / 180)*master.getWidth()*0.01);
    }
}
