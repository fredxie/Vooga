package game;

import java.awt.event.KeyEvent;

public class Configuration {
	// space
	public static double BACKGROUND_SPEED = 0.1;
	public static int ENEMY_NUM = 30;
	public static int BONUS_NUM = 30;
	public static int BONUS_STYLE_NUM = 3;
	public static int BLOCK_NUM = 20;
//	public static boolean IS_HARD;
//	public static int AMMUNITION_UPGRADE_NUM;
	
	//Default:Key Control
    public static int UP = KeyEvent.VK_UP;
    public static int DOWN = KeyEvent.VK_DOWN;
    public static int LEFT = KeyEvent.VK_LEFT;
    public static int RIGHT = KeyEvent.VK_RIGHT;
    public static int FIRE = KeyEvent.VK_SHIFT;

  //Default Fighter HP & LifeNum
    public static int FIGHTER_WEAPON_DAMAGE = 1;
    public static int ENEMY_WEAPON_DAMAGE = 1;
    
    public static int ENEMY_HP = 1;
    public static int FIGHTER_HP = 1;
    public static int lifeNum =2;
    public static int INITIAL_STYLE =0;
    
    
    public static int BOMB_NUM =5;
    public static int BOMB = KeyEvent.VK_CONTROL;

    
//	public static void setter(int level) {
//		switch (level) {
//		case 0: 
//			BACKGROUND_SPEED = 0.1;
//			ENEMY_NUM = 40;
//			IS_HARD = false;
//			AMMUNITION_UPGRADE_NUM = 7;
//			break;
//		
//		case 1: 
//			BACKGROUND_SPEED = 0.15;
//			ENEMY_NUM = 15;
//			IS_HARD = true;
//			AMMUNITION_UPGRADE_NUM = 5;
//			break;
//		
//		}
//	}
}
