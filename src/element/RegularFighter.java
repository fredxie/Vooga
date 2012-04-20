package element;

/**
 * 
 * @author ShiyuanWang
 */
import game.TopDownTimer;
import gameObject.GameLevel;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import playerState.AssistanceState;
import playerState.CollisionState;
import playerState.NormalCollisionState;
import playerState.PhysicCollisionState;
import playerState.PlayerState;
import playerState.WeaponState;
import util.TopDownImageUtil;

import com.golden.gamedev.object.Sprite;

import configuration.FighterKeyChangedObserver;
import configuration.FighterKeyPressedObserver;
import configuration.GameParameters;
import configuration.Key;
import configuration.KeyAnnotation;
import configuration.KeyChangedSubject;
import configuration.KeyPressedSubject;

public abstract class RegularFighter extends Fighter {

	private List<Key> keyList;
	public boolean allowBomb = true;
	public TopDownTimer rebombRate = new TopDownTimer(5000); // allow to rebomb
	public WeaponState weaponState = new WeaponState(this);
	public AssistanceState assistanceState = new AssistanceState(this);

	public CollisionState collisionState = new PhysicCollisionState(this);
	public AutoFighter assistance;
	public double moveSpeed = 0.3; // (default)
	public boolean allowFire = true;
	public GameLevel game;
	public BufferedImage bulletImage;
	public List<PlayerState> stateList = new ArrayList<PlayerState>();

	public FighterKeyChangedObserver keyChangedObserver;
	public FighterKeyPressedObserver keyPressedObserver;

	public RegularFighter(BufferedImage image) {
		super(image);
	}

	public void setGameObject(GameLevel game) {
		this.game = game;
	}

	public void setKeyList(List<Key> list) {
		keyList = list;
	}

	public List<Key> getKeyList() {
		return keyList;
	}

	// @KeyAnnotation(action = GameParameters.UP)
	// public void keyUpPressed(long elapsedTime) {
	// speedY = -moveSpeed;
	// }
	//
	// @KeyAnnotation(action = GameParameters.DOWN)
	// public void keyDownPressed(long elapsedTime) {
	// speedY = moveSpeed;
	// }
	//
	// @KeyAnnotation(action = GameParameters.LEFT)
	// public void keyLeftPressed(long elapsedTime) {
	// speedX = -moveSpeed;
	// }
	//
	// @KeyAnnotation(action = GameParameters.RIGHT)
	// public void keyRightPressed(long elapsedTime) {
	// speedX = moveSpeed;
	// }
	//
	// @KeyAnnotation(action = GameParameters.FIRE)
	// public void keyFirePressed(long elapsedTime) {
	// if (!allowFire) {
	// allowFire = refireRate.action(elapsedTime);
	// }
	//
	// else if (allowFire)
	// attack(elapsedTime, weaponStyle, weaponDamage);
	// }

	@KeyAnnotation(action = GameParameters.UP)
	public abstract void keyUpPressed(long elapsedTime);

	@KeyAnnotation(action = GameParameters.DOWN)
	public abstract void keyDownPressed(long elapsedTime);

	@KeyAnnotation(action = GameParameters.LEFT)
	public abstract void keyLeftPressed(long elapsedTime);

	@KeyAnnotation(action = GameParameters.RIGHT)
	public abstract void keyRightPressed(long elapsedTime);

	@KeyAnnotation(action = GameParameters.FIRE)
	public abstract void keyFirePressed(long elapsedTime);

	public abstract void refresh(long elapsedTime);

	public abstract void bomb(long elapsedTime);

	public void attack(long elapsedTime, int numOfBullet, double weaponDamage) {
		weaponState.fire(elapsedTime, numOfBullet, weaponDamage);
	}

	public PlayerState getWeaponState() {
		return weaponState;
	}

	public PlayerState getAssistanceState() {
		return assistanceState;
	}

	// State in Collision Part

	public CollisionState getCollisionState() {
		return collisionState;
	}

	public void init() {
		// TODO Auto-generated method stub
		keyChangedObserver = new FighterKeyChangedObserver(this);
		keyPressedObserver = new FighterKeyPressedObserver(this);
		initHelper();
	}

	public abstract void initHelper();
	
	public void fighterControl(long elapsedTime) {
		// speedX = speedY = 0;
		// for (Key key : keyList) {
		// if (key.isKeyDown()) {
		// key.notifyObserver(elapsedTime);
		// }
		// }
		// speedY -= backgroundSpeed / 10.0;
		// setSpeed(speedX, speedY);
		if (assistance != null)
			assistance.fighterControl(elapsedTime);

		for (PlayerState state : stateList) {
			state.update(elapsedTime);
		}

	}
}