package api.gameLevel;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import api.collisionSystem.CollisionManager;
import api.element.Block;
import api.element.Bonus;
import api.element.Enemy;
import api.element.RegularFighter;
import api.element.TopDownPlayField;
import api.game.TopDownGameEngine;
import api.game.TopDownTimer;
import api.gameObject.TopDownGameObject;
import api.spawn.ElementSpawner;

/**
 * This class extends the top down game object and developers can use this
 * superclass to create specific game levels of top down games
 * 
 * @param enemyNum
 *            number of enemies in current game level
 * @param bonusNum
 *            number of bonus in current game level
 * @param blockNum
 *            number of blocks in current game level
 * @param cannonNum
 *            number of cannons in current game level
 * @param showSatellite
 *            satellite show tag in current game level
 * @param manager
 *            manager of collision system
 * @param timer
 *            top down game timer
 * @param playfield
 *            playfield of current game level
 * @param fighter
 *            regular fighter of current game level
 * @param juniorEnemies
 *            list for storing enemies in current game level
 * @param cannon
 *            list for storing cannons in current game level
 * @param bonuses
 *            list for storing bonuses in current game level
 * @param blocks
 *            list for storing blocks in current game level
 * @param enemySpawner
 *            spawner of enemies
 * @param cannonSpawner
 *            spawner of cannons
 * @param bonusSpawner
 *            spawner of bonuses
 * @param blockSpawner
 *            spawner of blocks
 * @param gameOver
 *            boolean value represents whether current game is over
 * @param levelComplete
 *            boolean value represents whether current game level is finished
 * @param levelRequirement
 *            string value represents the finish requirement of current game
 *            level
 * @param level
 *            integer value represents the level number of current game level
 * 
 * @author Chenbo Zhu
 */
public abstract class GameLevel extends TopDownGameObject {
	public int enemyNum;
	public int bonusNum;
	public int blockNum;
	public int cannonNum;
	public boolean showSatellite;

	public CollisionManager manager;
	public static TopDownTimer timer;
	public TopDownPlayField playfield;
	public RegularFighter fighter;
	public List<Enemy> juniorEnemies = new ArrayList<Enemy>();
	public List<Enemy> cannon = new ArrayList<Enemy>();
	public List<Bonus> bonuses = new ArrayList<Bonus>();
	public List<Block> blocks = new ArrayList<Block>();

	public ElementSpawner<Enemy> enemySpawner;
	public ElementSpawner<Enemy> cannonSpawner;
	public ElementSpawner<Bonus> bonusSpawner;
	public ElementSpawner<Block> blockSpawner;

	public boolean gameOver;
	public boolean levelComplete;

	public String levelRequirement;
	public int level;

	public GameLevel(TopDownGameEngine parent) {
		super(parent);
	}

	/**
	 * render of current game level
	 * 
	 * @param g
	 */
	public abstract void gameRender(Graphics2D g);
}
