package element;
/**
 * 
 * @author ShiyuanWang
 */
import game.Configuration;
import gameObject.GameLevel;

import java.awt.image.BufferedImage;

import configuration.GameParameters;

import util.JsonUtil;
import util.TopDownAreaUtil;
import util.TopDownImageUtil;

import demo.DemoGameEngine;

public abstract class Satellite extends AutoFighter{

    double degree = 0;
	protected Bullet bullet = new Laser(TopDownImageUtil.getImage("images/game/beam3.png"));
	
	GameLevel game;
	

    
	public Satellite(BufferedImage image) {
		super(image);
	}

	public Satellite(BufferedImage image, RegularFighter fighter) {
		super(image);
		master = fighter;
		init();
	}



	public void setWeapon(Bullet bullet,int weaponDamage, int numOfBullet) {
		this.bullet = bullet;
	}


	public void init()
	{   
		playfield = master.playfield;
		game = master.game;
		setRefireRate(1000);
		setLocation(master.getX()-0.5*master.getWidth(), master.getY());
	}

	public void fighterControl(long elapsedTime) {
		speedY = 0;
		speedX = 0;
		if(master.isActive())
		{
			if(!allowFire){
			allowFire = refireRate.action(elapsedTime);}
		else 
			attack(elapsedTime, 0, height);
		speedY = master.getSpeedY();
			//	-0.5* JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED);
		speedX = 0.3 * master.getSpeedX();
		setSpeed(speedX,speedY);
		TopDownAreaUtil.setFighterArea(this, playfield.getTileBackground(),
				DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
		}
		else
			setActive(false);
	}

	
	   public void setBrinkVerticalSpeed()
	    {
	    	setVerticalSpeed(-JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED));
	    }
	    public void setBrinkHorizontalSpeed()
	    {   
	    	setHorizontalSpeed(0);
	    }
}