package ai;
import element.*;
import game.*;
import collision.*;
import demo.*;
import game.Configuration;
import java.util.*;
import com.golden.gamedev.object.Timer;
import java.util.Random;
import element.Missile;
public class Level3 implements TopDownBehavior
{
	double x = (Math.random()*51); 
	double d,h;
	private Timer timer = new Timer(500);
	private boolean timera = false;
//	@Override
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
	public void weaponSpeed(Missile missile)
	{	
		/*
		 * bullets zig zag every half second. May need to move zig zag to gameLevelState update fields
		 */
		double h = .2;
		if(Math.random()*10 > 5)
		{
			missile.setHorizontalSpeed(h);
		}
		else {
			missile.setHorizontalSpeed(-h);
		}
//		timer.refresh();
//		if(timer.getCurrentTick() == 500){
//			timera = true;
//		}
//		if(timera == true){
//			bullet.setHorizontalSpeed(-h);
//			timera = false;
//			timer.refresh();
//		}
		//}
		//		else {
		//			bullet.setHorizontalSpeed(-h);
		//			timer.refresh();
		//			if(timer.getCurrentTick() == 500){
		//				timera = true;
		//			}
		//			if(timera == true){
		//				bullet.setHorizontalSpeed(h);
		//				timera = false;
		//				timer.refresh();
		//			}
		//		}
		missile.setVerticalSpeed(.25);
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
}
