
package demo;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.TopDownUtility;

import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.Timer;

import element.Block;
import element.Bullet;
import element.Enemy;
import element.Fighter;
import element.Missile;
import element.TopDownPlayField;
import element.Weapon;
import game.Configuration;


public class DemoCannonBlock extends Enemy {

	public static final int DEFAULT_FIRE_DELAY = 2000;

	protected Fighter fighter;
	protected BufferedImage m_baseImg;
	protected BufferedImage m_cannonImg;
	protected Timer m_fireTimer;
	protected boolean m_canFire;
	protected double m_cannonAngle; // Cannon angle in degrees

	protected static final int CANNON_ROTATIONX = 16 / 2;
	protected static final int CANNON_ROTATIONY = 70 + 45;
	public static final int WIDTH = 128;
	public static final int HEIGHT = 64;

	protected static final int CANNON_XOFFSET = (WIDTH - 16) / 2;
	protected static final int CANNON_YOFFSET = -3 * HEIGHT / 4;

	public DemoCannonBlock(TopDownPlayField playfield, BufferedImage baseImg,
			BufferedImage cannonImg, Fighter player)

	{
		super(baseImg);
		this.playfield = playfield;
		m_baseImg = baseImg;
		m_cannonImg = cannonImg;
       
		m_fireTimer = new Timer(DEFAULT_FIRE_DELAY);
		m_canFire = true;
		fighter = player;
	}

	public void rotateCannon() {
		double cannonX = getX() + CANNON_XOFFSET + CANNON_ROTATIONX;
		double cannonY = getY() + CANNON_YOFFSET + CANNON_ROTATIONY;
		double deltaX = fighter.getX() - cannonX;
		double deltaY = fighter.getY() - cannonY;
		m_cannonAngle = Math.atan2(deltaY, deltaX);
	}

	public void update(long elapsedTime) {
		super.update(elapsedTime);
		rotateCannon();
		setReadyToFire(isReadyToFire() || m_fireTimer.action(elapsedTime));
	}

	public boolean isReadyToFire() {
		return m_canFire;
	}

	public void attack(long elapsedTime) {
		/**
		 * No no no.. you have to wait a little more or enter an answer before
		 * firing another bullet.
		 */
		if (isReadyToFire()) {

			double rotCenterX = getX() + CANNON_XOFFSET + CANNON_ROTATIONX;
			double rotCenterY = getY() + CANNON_YOFFSET + CANNON_ROTATIONY;
			int r = CANNON_ROTATIONY;

			double radAngle = m_cannonAngle;
			double headX = r * Math.cos(radAngle) + rotCenterX;
			double headY = r * Math.sin(radAngle) + rotCenterY;

			double speedX = (headX - rotCenterX) / r;
			double speedY = (headY - rotCenterY) / r;

			Weapon enemyMissile;
			try {
				enemyMissile = new Missile(ImageIO.read(new File(
						"images/game/emissle_easy.png")), headX, headY,
						Configuration.ENEMY_WEAPON_DAMAGE);

				enemyMissile.setSpeed(speedX, speedY);
				playfield.getGroup("Enemy Missile").add(enemyMissile);

				m_canFire = false;
				m_fireTimer.refresh();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void setReadyToFire(boolean canFire) {
		m_canFire = canFire;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
	}

	@Override
	public void refresh(long elapsedTime) {
		// TODO Auto-generated method stub
		if (show == false) { // enemy has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the enemy
				playfield.getGroup("Enemy").add(this);
				show = true;
				// enemy fires
				attack(elapsedTime);
			}
		} else { // for those have shown before, they should continue firing
			attack(elapsedTime);
		}

	}

	public void render(Graphics2D g) {
		renderCannon(g);
		renderBase(g);
		super.render(g);
	}

	protected void renderCannon(Graphics2D g) {
		int cannonX = (int) (getX() + CANNON_XOFFSET);
		int cannonY = (int) (getY() + CANNON_YOFFSET);

		/**
		 * Rotating the cannon image.
		 * 
		 * Cannot use ImageUtile.rotate because the image is not a square and
		 * there's no way to specify a center of rotation. A simple solution
		 * would be to make a square image, and combine a translation with the
		 * rotation.
		 * 
		 * Another solution would be to create a standard AffineTransformation.
		 * That's the implemented solution for now.
		 * 
		 * @todo Fatal error under MacOsX 1.3 if the rotation angle of an
		 *       AffineTransformation is lower then 0 or greater then PI/2.
		 */

		AffineTransformOp op = new AffineTransformOp(
				AffineTransform.getRotateInstance(m_cannonAngle,
						CANNON_ROTATIONX, CANNON_ROTATIONY),
				AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		g.drawImage(m_cannonImg, op, cannonX, cannonY);
		//System.out.println(cannonX);
	}
	
    protected void renderBase( Graphics2D g)
    {
        g.drawImage( m_baseImg, null, (int) getX(),(int) getY() );
    }

	@Override
	public Enemy clone() {
		// TODO Auto-generated method stub
		return new DemoCannonBlock(playfield, m_baseImg, m_cannonImg, fighter);
	}

}

