package game;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import util.TopDownImageUtil;

public class Configuration {
	// space
	public static double BACKGROUND_SPEED = 0.1;
	public static int ENEMY_NUM = 30;
	public static int BONUS_NUM = 30;
	public static int BONUS_STYLE_NUM = 3;
	public static int BLOCK_NUM = 20;
	// public static boolean IS_HARD;
	// public static int AMMUNITION_UPGRADE_NUM;

	// Default:Key Control
	public static int UP = KeyEvent.VK_UP;
	public static int DOWN = KeyEvent.VK_DOWN;
	public static int LEFT = KeyEvent.VK_LEFT;
	public static int RIGHT = KeyEvent.VK_RIGHT;
	public static int FIRE = KeyEvent.VK_SHIFT;

	// Default Fighter HP & LifeNum
	public static double FIGHTER_WEAPON_DAMAGE = 1;
	public static double ENEMY_WEAPON_DAMAGE = .25;

	public static double ENEMY_HP = 1;
	public static double FIGHTER_HP = 1;
	public static int lifeNum = 2;
	public static int INITIAL_STYLE = 0;

	public static int BOMB_NUM = 5;
	public static int BOMB = KeyEvent.VK_CONTROL;

	public static String BACKGROUND_PATH;
	public static BufferedImage FIGHTER_PATH = TopDownImageUtil
			.getImage("images/game/fighter.png");
	public static BufferedImage ENEMY_PATH = TopDownImageUtil
			.getImage("images/game/enemy_easy.png");

}
