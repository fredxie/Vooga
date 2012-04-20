package ai;
import element.Enemy;
import element.Missile;
import game.Configuration;
/*
 * When the player gets x number of points, score limit increases the ai of the computer. This will happen
 * multiple times through the game depending on the score of the player, and can happen in any level, and in
 * addition to any other ai change.
 */
public class ScoreLimit implements TopDownBehavior
{
	double d,h;
	public void movement(Enemy enemy)
	{
		double hSpeed = enemy.getHorizontalSpeed();
		double vSpeed = enemy.getVerticalSpeed();
		hSpeed = hSpeed + .05;
		vSpeed = vSpeed + .02;
		enemy.setSpeed(hSpeed,vSpeed);
	}
	public void fireRate(Enemy enemy){
		int rate = enemy.getRefireRate();
		rate = rate - 150;
		enemy.setRefireRate(rate);		
	}
	public void weaponDamage(Missile missile)
	{
		double x = missile.getDamage();
		x = x + 0.5;
		missile.setDamage(x);
	}
	public double enemyDamage()
	{
		double a = Configuration.ENEMY_WEAPON_DAMAGE;
		d = a + .5;
		Configuration.ENEMY_WEAPON_DAMAGE = d;
		return d;
	}
	public void weaponSpeed(Missile missile)
	{
		double x = missile.getHorizontalSpeed();
		double y = missile.getVerticalSpeed();
		x = x * 1.3;
		missile.setHorizontalSpeed(x);
		y = y * 1.3;
		missile.setVerticalSpeed(y);
	}
	public double enemyHP() {
		double x = Configuration.ENEMY_HP;
		h = x + .5;
		Configuration.ENEMY_HP = h;
		return h;	
	}
	public void enemyHP(Enemy enemy)
	{
		double h = enemy.getHP();
		h = h + .25;
		enemy.setHP(h);
	}
	public double getState()
	{
		return 0;// setting as 0 since gamestate always starts at 1 and never reaches 0, these arent levels but ai changes based on changes in the game
	}
}
