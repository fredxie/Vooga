package api.gameLevel;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import api.collisionSystem.CollisionManager;
import api.element.Block;
import api.element.Bonus;
import api.element.Enemy;
import api.game.TopDownGameEngine;
import api.game.TopDownTimer;
import api.gameObject.TopDownGameObject;
import api.spawn.ElementSpawner;


import demo.element.DemoFighter;
import demo.game.DemoPlayField;

public abstract class GameLevel extends TopDownGameObject {
	public int enemyNum;
	public int bonusNum;
	public int blockNum;
	public int cannonNum;
	public boolean showSatellite;

	public CollisionManager manager;
	public static TopDownTimer timer = new TopDownTimer(3000);
	public DemoPlayField playfield = new DemoPlayField(this);
	public DemoFighter fighter;
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

	public abstract void gameRender(Graphics2D g);
}