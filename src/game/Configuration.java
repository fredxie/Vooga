package game;

import java.awt.image.BufferedImage;

import util.TopDownImageUtil;

public class Configuration {
	
//	public static double ENEMY_WEAPON_DAMAGE = .25;
//	public static double ENEMY_HP = 1;

	public static String BACKGROUND_PATH;
	public static BufferedImage FIGHTER_PATH = TopDownImageUtil
			.getImage("images/game/fighter.png");
	public static BufferedImage ENEMY_PATH = TopDownImageUtil
			.getImage("images/game/enemy_easy.png");

}
