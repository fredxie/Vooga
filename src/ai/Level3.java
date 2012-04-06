package ai;
import element.*;
import game.*;
import collision.*;
import demo.*;
import game.Configuration;
import java.util.*;
import com.golden.gamedev.object.Timer;
import java.util.Random;

public class Level3 extends TopDownLevel
{
	double x = (Math.random()*51); 
	private Timer timer = new Timer(500);
	private boolean timera = false;
//	@Override
	public void movement(Enemy enemy)
	{
		enemy.setSpeed(0.15,0.15);
		if (enemy.getX() <= 0){
			enemy.setSpeed(0.15,0.15);
		}
		if (enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
		{
			enemy.setSpeed(-0.15, 0.15);
		}
	}
//	@Override
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(700);
	}
//	public void enemyDamage(double d)
//	{
//		d = 1.5;
//		Configuration.ENEMY_WEAPON_DAMAGE = d;
//	}
//	@Override
	public void weaponDamage(Bullet bullet)
	{
		bullet.setDamage(1.5);
	}
	public void weaponSpeed(Bullet bullet)
	{	
		/*
		 * bullets zig zag every half second
		 */
		double h = .15;
		if(Math.random()*10 > 5)
		{
			bullet.setHorizontalSpeed(h);
		}
		else {
			bullet.setHorizontalSpeed(-h);
		}
		timer.refresh();
		if(timer.getCurrentTick() == 500){
			timera = true;
		}
		if(timera == true){
			bullet.setHorizontalSpeed(-h);
			timera = false;
			timer.refresh();
		}
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
		bullet.setVerticalSpeed(.25);
	}
//	@Override
//	public void enemyHP(double h)
//	{
//		h = 2.5;
//		Configuration.ENEMY_HP = h;
//	}
	public void enemyHP(Enemy enemy)
	{
		double h = 2.5;
		enemy.setHP(h);
	}
}
