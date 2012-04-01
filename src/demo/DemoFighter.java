package demo;

import java.awt.image.BufferedImage;

import util.TopDownAreaUtil;
import util.TopDownImageUtil;


import element.Bullet;
import element.Fighter;

public class DemoFighter extends Fighter{
	
	public DemoFighter(BufferedImage image) {
		super(image);
	}

	public void init() {
		
		setHP(10);//Default HP
		setRefireRate(300);//Default Re-fire Rate
		setLocation(DemoGameEngine.WIDTH/2, playfield.getBackground().getHeight()-getHeight());//Default Location
		playfield.getGroup("Fighter").add(this);
	}

	public void refresh(long elapsedTime) {
		 if(isActive()){
			 fighterControl(elapsedTime);
			 TopDownAreaUtil.setFighterArea(this, playfield.getTileBackground(), DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
			 if(getY()==0){
				 game.finish();
			 }
		 }
	}

	@Override
	public void attack(long elapsedTime, int weaponStyle, int weaponDamage) {

		switch (weaponStyle) {
		case 0: {
			Bullet missile = new Bullet(TopDownImageUtil.getImage("images/game/bullet.png"),
					this.getX() + this.getWidth() / 2,
					this.getY() - 20, weaponDamage);
			missile.setVerticalSpeed(-0.7);
			playfield.getGroup("Fighter Bullet").add(missile);
			break;
		}
		case 1: {
			Bullet[] missile = new Bullet[3];
			for (int i = 0; i < 3; i++) {
				missile[i] = new Bullet(TopDownImageUtil.getImage("images/game/bullet.png"),
						this.getX() + this.getWidth() / 2,
						this.getY() - 20, weaponDamage);
				missile[i].setSpeed(
						0.35 * Math.sin((1 - i) * 30 * 3.14 / 180), -0.6
								* Math.cos((1 - i) * 30 * 3.14 / 180));
				playfield.getGroup("Fighter Bullet").add(missile[i]);
			}
			break;
		}
		case 2: {
			Bullet[] missile = new Bullet[5];
			for (int i = 0; i < 5; i++) {
				missile[i] = new Bullet(TopDownImageUtil.getImage("images/game/bullet.png"),
						this.getX() + this.getWidth() / 2,
						this.getY() - 20, weaponDamage);
				missile[i].setSpeed(
						0.35 * Math.sin((2 - i) * 22.5 * 3.14 / 180), -0.6
								* Math.cos((2 - i) * 22.5 * 3.14 / 180));
				playfield.getGroup("Fighter Bullet").add(missile[i]);
			}
			break;
		}
		}
		allowFire = false;
//		refireRate.refresh();
	}



}
