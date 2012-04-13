package spawn;

import java.util.ArrayList;
import java.util.List;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Timer;

import util.TopDownImageUtil;
import demo.DemoEnemy;
import demo.DemoPlayField;
import element.Enemy;
import element.TopDownPlayField;
import game.Configuration;

/**
 * 
 * @author Gang Song
 * @Description This class is mainly for creating a group of enemies
 *              It is implemented by Strategy pattern for 
 *
 */

public class EnemySpawner {
	
	private SpawnBehavior mySpawnBehavior;
	private Enemy myEnemy;
	private int myEnemyNum;
	//private PlayField myPlayField;
	private boolean hasSpawned;
	private Timer myTimer;
	
	/**
	 * The SpawnBehavior here is set default to SpawnByRandom
	 * The enemy type is set to DemoEnemy
	 * @param playfield
	 */
//	public EnemySpawner(PlayField playfield, int enemyNum){
//		
//		mySpawnBehavior=new SpawnByRandom();
//		myEnemy=new DemoEnemy((TopDownPlayField)playfield,
//				TopDownImageUtil.getImage("images/game/enemy_easy.png"), Configuration.ENEMY_HP);
//		hasSpawned=false;
//		myTimer=new Timer(3000);
//		enemyNum=myEnemyNum;
//	}
	
    public EnemySpawner(SpawnBehavior sb, Enemy enemy, int enemyNum){
    	
    	myEnemyNum=enemyNum;
//		myPlayField=playfield;
		mySpawnBehavior=sb;
		myEnemy=enemy;
		hasSpawned=false;
		myTimer=new Timer(9000);
	}
	
	
	public List<Enemy> spawn() {
		
			List<Enemy> enemies = new ArrayList<Enemy>();
			for (int i = 0; i < myEnemyNum; i++) {

				Enemy currentEnemy = myEnemy.clone();// To clone the same kind of enemy
				currentEnemy.setSpawnBehavior(mySpawnBehavior);
				currentEnemy.spawn();
				enemies.add(currentEnemy);
			}
		
			return enemies;

	}
	
	
	/**
	 * @param sb: change spawning behavior to sb
	 */
	public void setSpawnBehavior(SpawnBehavior sb){
		mySpawnBehavior=sb;
	}
	
	/**
	 * @param enemy: change Enemy type to enemy
	 */
	public void setEnemy(Enemy enemy){
		myEnemy=enemy;
	}
	
	/**
	 * 
	 * @param elapsedTime
	 * @Description: This method is mainly used for time related spawning behavior, such as SpawnByTime
	 */
	
//	
//	public Enemy[] refresh(long elapsedTime){
//		if(myTimer.action(elapsedTime)){	   	
//			myTimer.refresh();
//			return spawn();
//		}
//		return null;
//	}
//	

	public boolean refresh(long elapsedTime){
		boolean state=myTimer.action(elapsedTime);
		if(state){
			myTimer.refresh();
		}
		return state;
	}
	
	
	public void setTimer(Timer time){
		myTimer=time;
	}
	
//	public Enemy[] spawnByFighterState(){
//		if (hasSpawned == false) {
//			
//			Enemy[] retEne=spawn();
//			  if(retEne!=null){
//				    hasSpawned = true;
//			  }	
//			return retEne;
//		}
//		return null;
//	}

	public boolean checkSpawn(){
		return hasSpawned; 
	}

}
