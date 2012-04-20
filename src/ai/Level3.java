
package ai;
import element.*; 
import game.*;
import collision.*;
import demo.*;
import game.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
//import com.golden.gamedev.object.Timer;
import javax.swing.Timer;
import java.util.Random;
import element.Missile;
public class Level3 implements EnemyTopDownBehavior
{
	Timer timer;
	
	public void enemy_Changes(Enemy enemy)
	{
		enemy.setSpeed(0.15,0.15);
		enemy.setRefireRate(700);
		Configuration.ENEMY_HP = 2.5;
	}

	public void weapon_Changes(final Missile missile)
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 1.5;
	
		/*
		 * bullets zig zag every half second
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

	public int getState()
	{
		return 3;
	}
//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(1.5);
//	}
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 2.5;
//		enemy.setHP(h);
//	}
	
}
