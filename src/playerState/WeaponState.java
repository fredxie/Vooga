package playerState;

import util.TopDownImageUtil;
import element.Weapon;
import element.Fighter;
import element.Laser;

public class WeaponState extends PlayerState{
	
	
	private Weapon bullet = new Laser(
			TopDownImageUtil.getImage("images/game/bigLaser1.png")); //Default value for easy test
	
	public WeaponState(Fighter fighter) {
		super(fighter);
	}


	public void changeState(Object bullet) {
		this.bullet = (Weapon)bullet;
	}

	public void fire(long elapsedTime, int numOfBullet, double weaponDamage) {
		bullet.genBullets(fighter, numOfBullet, weaponDamage);
	}


	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}
