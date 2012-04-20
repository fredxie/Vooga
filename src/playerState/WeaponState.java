package playerState;

import util.TopDownImageUtil;
import element.Weapon;
import element.Fighter;
import element.Laser;

public class WeaponState extends PlayerState{
	
	public int weaponStyle = 0;
	public double weaponDamage= 0;
	
	
	private Weapon bullet = new Laser(
			TopDownImageUtil.getImage("images/game/bigLaser1.png")); //Default value for easy test
	
	public WeaponState(Fighter fighter) {
		super(fighter);
	}

	public WeaponState(Fighter fighter,int numberOfBullet,double weaponDamage) {
		super(fighter);
		this.weaponStyle = numberOfBullet;
		this.weaponDamage = weaponDamage;
	}
	
	public void setWeapon(int numOfBullet,double weaponDamage)
	{
		this.weaponStyle = numOfBullet;
		this.weaponDamage = weaponDamage;
	}
	
	public void changeState(Object bullet) {
		this.bullet = (Weapon)bullet;
	}

	public void setWeaponStyle(int weaponStyle)
	{
		this.weaponStyle = weaponStyle;
	}
	
	public void setWeaponDamage(double weaponDamage)
	{
		this.weaponDamage = weaponDamage;
	}
	
	public int getWeaponStyle()
	{
		 return weaponStyle;
	}
	
	public double getWeaponDamage()
	{
		 return weaponDamage;
	}
		
	
	public void fire(long elapsedTime, int numOfBullet, double weaponDamage) {
		bullet.genBullets(fighter, numOfBullet, weaponDamage);
	}

    public void fire()
    {
    	bullet.genBullets(fighter,weaponStyle,weaponDamage);
    }
    
    public void changeNumOFBullet(int change)
    {
    	weaponStyle = change + weaponStyle;
    }
    
    public void changeWeaponDamage(double change)
    {
    	weaponDamage = change + weaponDamage;
    }
	
    @Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}
