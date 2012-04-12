package ai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import element.Enemy;
import element.Missile;
import game.Configuration;
public class Level3 implements TopDownBehavior
{
	double x = (Math.random()*51); 
	double d,h,s;
	Timer timer;
	
	public void movement(Enemy enemy)
	{
		enemy.setSpeed(0.15,0.15);
		
	}

	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(700);
	}
	public double enemyDamage()
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 1.5;
		return d = 1.5;
	}

//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(1.5);
//	}
	public void weaponSpeed(final Missile missile)
	{	
		/*
		 * bullets zig zag every half second. May need to move zig zag to gameLevelState update fields
		 */
		final double s = .2;
		missile.setVerticalSpeed(.25);
		if(Math.random()*10 > 5)
		{
			missile.setHorizontalSpeed(s);
		}
		else {
			missile.setHorizontalSpeed(-s);
		}
		
		timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(timer)){
					missile.setHorizontalSpeed(-s);
				}
			}
		});
		timer.setRepeats(true);
		timer.start();
//		if(missile.isActive() == false){
//			timer.restart();
//		}
	}
	public double enemyHP()
	{
		Configuration.ENEMY_HP = 2.5;
		return h = 2.5;
	}
	public void enemyHP(Enemy enemy)
	{
		double h = 2.5;
		enemy.setHP(h);
	}
	public double getState()
	{
		return 3.0;
	}
}
