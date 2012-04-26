package demo.game;

import api.background.TopDownTileBackground;
import api.game.TopDownPlayField;
import api.gameObject.TopDownGameObject;
import api.util.TopDownImageUtil;
import api.util.TopDownUtility;

public class DemoPlayField extends TopDownPlayField {

	public DemoPlayField(TopDownGameObject o) {
		super(o);
	}

	public void init(String s) {

		int[][] tiles = new int[100][100];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j] = TopDownUtility.getRandom(0, 9);
			}
		}

		
		TopDownTileBackground background = new TopDownTileBackground(
				TopDownImageUtil
						.getImages(s, 10, 1),
				tiles);
		background.setLocation(0, background.getHeight());
		this.setBackground(background);
		/*
		 * // create groups ElementGroup FIGHTER = this.addGroup(new
		 * ElementGroup("Fighter")); ElementGroup FIGHTER_MISSILE =
		 * this.addGroup(new ElementGroup( "Fighter Bullet")); ElementGroup
		 * ENEMY = this.addGroup(new ElementGroup("Enemy")); ElementGroup
		 * ENEMY_MISSILE = this.addGroup(new ElementGroup( "Enemy Missile"));
		 * ElementGroup BONUS = this.addGroup(new ElementGroup("Bonus"));
		 * ElementGroup BLOCK = this.addGroup(new ElementGroup("Block"));
		 * 
		 * // set up collision groups // this.addCollisionGroup( //
		 * FIGHTER_MISSILE, // ENEMY, // new EnemyDestroyedCollision(this,
		 * TopDownImageUtil.getImages( // "images/game/explosion.png", 6, 1)));
		 * this.addCollisionGroup(
		 * 
		 * FIGHTER,ENEMY_MISSILE, new FighterEnemyBulletCollision(this,
		 * TopDownImageUtil.getImages( "images/game/explosion.png", 6,
		 * 1),"sounds/explosion.wav"));
		 * 
		 * this.addCollisionGroup(
		 * 
		 * FIGHTER, ENEMY, new FighterEnemyCollision(this,
		 * TopDownImageUtil.getImages(
		 * 
		 * "images/game/explosion.png", 6, 1),"sounds/explosion.wav"));
		 * 
		 * this.addCollisionGroup( ENEMY, FIGHTER_MISSILE, new
		 * EnemyFighterBulletCollision(this, TopDownImageUtil.getImages(
		 * "images/game/explosion.png", 6, 1),"sounds/explosion.wav"));
		 * 
		 * this.addCollisionGroup( FIGHTER, BONUS, new
		 * FighterBonusCollision(this, TopDownImageUtil.getImages(
		 * "images/game/explosion.png", 6, 1),"sounds/explosion.wav"));
		 * this.addCollisionGroup( FIGHTER, BLOCK, new
		 * FighterBlockCollision(this, TopDownImageUtil.getImages(
		 * "images/game/explosion.png", 6, 1),"sounds/explosion.wav"));
		 * 
		 * this.addCollisionGroup( BLOCK,FIGHTER_MISSILE, new
		 * BlockFighterBulletCollision
		 * (this,TopDownImageUtil.getImages("images/game/explosion.png", 6,
		 * 1),"sounds/explosion.wav"));
		 */
	}

}