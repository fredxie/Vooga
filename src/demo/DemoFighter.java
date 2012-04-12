package demo;

import java.awt.image.BufferedImage;

import util.TopDownAreaUtil;
import util.TopDownImageUtil;
import collisionSystem.LifeDecreaseCollision;
import element.Bullet;
import element.Element;
import element.Laser;
import element.RegularFighter;
import element.Satellite;
import game.Configuration;
import game.TopDownVolatileElement;

public class DemoFighter extends RegularFighter {
    Bullet bullet = new Laser(TopDownImageUtil.getImage(
			"images/game/bigLaser1.png"));
    private Satellite satellite;
	public DemoFighter(BufferedImage image) {
		super(image);
	}

	public void init() {

		setRefireRate(100);// Default Re-fire Rate
		setLocation(DemoGameEngine.WIDTH / 2, playfield.getBackground()
				.getHeight() - getHeight());// Default Location
		playfield.getGroup("Fighter").add(this);
		setBombNum(Configuration.BOMB_NUM);
	}

	public void refresh(long elapsedTime) {
		if (isActive()) {
			fighterControl(elapsedTime);
			TopDownAreaUtil.setFighterArea(this, playfield.getTileBackground(),
					DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
			if (getY() == 0) {
				game.finish();
			}
		}
	}

	@Override
	public void attack(long elapsedTime, int weaponStyle, double weaponDamage) {
        Bullet[] bullets = bullet.genBullets(this,weaponStyle);
		for(Bullet bullet : bullets)
		playfield.getGroup("Fighter Bullet").add(bullet);
		allowFire = false;
	}

	public void bomb(long elapsedTime) {
		if (allowBomb == false) {
			allowBomb = rebombRate.action(elapsedTime);
		}
		if (game.keyDown(Configuration.BOMB) && bombNum > 0 && allowBomb) {
			bombNum--;
			
			clearElement("Enemy");
			clearElement("Enemy Missile");
			allowBomb = false;
			// rebombRate.refresh();
		}

	}

	private void clearElement(String name) {
		Element[] element = playfield.getGroup(name).getElement();
		int size = playfield.getGroup(name).getSize();
		for (int i = 0; i < size; i++) {
			if (element[i].isActive()
					&& element[i].getY() >= playfield.getTileBackground()
							.getY()
					&& element[i].getY() <= playfield.getTileBackground()
							.getY() + DemoGameEngine.HEIGHT) {
				element[i].setActive(false);
				if (name.equals("Enemy")) {
					LifeDecreaseCollision.destroyed++;
					playfield.add(new TopDownVolatileElement(TopDownImageUtil
							.getImages("images/game/explosion.png", 6, 1),
							element[i].getX(), element[i].getY()));
					// EnemyDestroyedCollision.destroyed++;
				}
			}
		}
	}
	public void genSatellite(BufferedImage image)
    {   
		satellite = new DemoSatellite(image,this);
    	
    }
   public Satellite getSatellite()
   {
	   return satellite;
   }

}