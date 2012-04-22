package game;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import util.TopDownImageUtil;

public class Configuration {
	// space
//	public static double BACKGROUND_SPEED = 0.1;
//	public static int ENEMY_NUM = 30;
//	public static int BONUS_NUM = 30;
	public static int BONUS_STYLE_NUM = 3;
//	public static int BLOCK_NUM = 20;

	// Default Fighter HP & LifeNum
	public static double FIGHTER_WEAPON_DAMAGE = 1;
	public static double ENEMY_WEAPON_DAMAGE = .25;

	public static double ENEMY_HP = 1;
	public static double FIGHTER_HP = 1;
//	public static int lifeNum = 2;
	public static int INITIAL_STYLE = 0;

	public static int BOMB_NUM = 5;
//	public static int BOMB = KeyEvent.VK_CONTROL;

	public static String BACKGROUND_PATH;
	public static BufferedImage FIGHTER_PATH = TopDownImageUtil
			.getImage("images/game/fighter.png");
	public static BufferedImage ENEMY_PATH = TopDownImageUtil
			.getImage("images/game/enemy_easy.png");

}
