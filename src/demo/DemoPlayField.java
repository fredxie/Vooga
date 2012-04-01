package demo;

import collision.EnemyFighterBulletCollision;
import background.TopDownTileBackground;
import util.TopDownImageUtil;
import util.TopDownUtility;
import element.ElementGroup;
import element.TopDownPlayField;

public class DemoPlayField extends TopDownPlayField{

	public void init() {

		int[][] tiles = new int[100][100];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j] = TopDownUtility.getRandom(0, 9);
			}
		}

		TopDownTileBackground background = new TopDownTileBackground(TopDownImageUtil.getImages("images/game/background.png",
				10, 1), tiles);
		background.setLocation(0, background.getHeight());
		this.setBackground(background);

		// create groups
		ElementGroup FIGHTER = this.addGroup(new ElementGroup("Fighter"));
		ElementGroup FIGHTER_MISSILE = this
				.addGroup(new ElementGroup("Fighter Bullet"));
		ElementGroup ENEMY = this.addGroup(new ElementGroup("Enemy"));
		ElementGroup ENEMY_MISSILE = this.addGroup(new ElementGroup("Enemy Missile"));
		ElementGroup BONUS = this.addGroup(new ElementGroup("Bonus"));
		ElementGroup BLOCK = this.addGroup(new ElementGroup("Block"));

		// set up collision groups
//		this.addCollisionGroup(
//				FIGHTER_MISSILE,
//				ENEMY,
//				new EnemyDestroyedCollision(this, TopDownImageUtil.getImages(
//						"images/game/explosion.png", 6, 1)));
		this.addCollisionGroup(
				ENEMY_MISSILE,
				FIGHTER,
				new FighterDestroyedCollision(this, TopDownImageUtil.getImages(
						"images/game/explosion.png", 6, 1)));
		this.addCollisionGroup(
				ENEMY,
				FIGHTER,
				new FighterDestroyedCollision(this, TopDownImageUtil.getImages(
						"images/game/explosion.png", 6, 1)));
		
		this.addCollisionGroup(
				ENEMY, FIGHTER_MISSILE, 
				new EnemyFighterBulletCollision(this, TopDownImageUtil.getImages(
						"images/game/explosion.png", 6, 1)));
	}

}
