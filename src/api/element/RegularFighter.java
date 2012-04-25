package api.element;

/**
 * 
 * @author ShiyuanWang
 */

import java.awt.image.BufferedImage;
import java.util.List;

import api.configuration.FighterKeyChangedObserver;
import api.configuration.FighterKeyPressedObserver;
import api.configuration.Key;
import api.configuration.KeyAnnotation;
import api.game.TopDownTimer;
import api.gameLevel.GameLevel;
import api.playerState.CollisionState;
import api.playerState.PlayerState;
/**
 * This class designs the fighter which can be controlled by keyWord and have many states.
 * 
 * 
 * @author Ran Zheng & Shiyuan Wang
 * 
 */
public abstract class RegularFighter extends Fighter {

	private List<Key> keyList;
	public boolean allowBomb = true;
	public TopDownTimer rebombRate;
	public AutoFighter assistance;
	public double moveSpeed; // (default)
	public boolean allowFire = true;
	public GameLevel game;
	public BufferedImage bulletImage;
	public FighterKeyChangedObserver keyChangedObserver;
	public FighterKeyPressedObserver keyPressedObserver;
	protected double speedFactor;

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

	@KeyAnnotation(action = "UP")
	public abstract void keyUpPressed(long elapsedTime);

	@KeyAnnotation(action = "DOWN")
	public abstract void keyDownPressed(long elapsedTime);

	@KeyAnnotation(action = "LEFT")
	public abstract void keyLeftPressed(long elapsedTime);

	@KeyAnnotation(action = "RIGHT")
	public abstract void keyRightPressed(long elapsedTime);

	@KeyAnnotation(action = "FIRE")
	public abstract void keyFirePressed(long elapsedTime);

	public abstract void refresh(long elapsedTime);

	/**
	 * Return assistance state, which is the state to manage AutoFighter
	 */


	public PlayerState getAssistanceState() {
		return stateManager.getAssistanceState();
	}

	/**
	 * Return collision state, which is the state to deal the collision between this fighter and other elements
	 */
	public CollisionState getCollisionState() {
		return stateManager.getCollisionState();
	}

	public void init() {
		keyChangedObserver = new FighterKeyChangedObserver(this);
		keyPressedObserver = new FighterKeyPressedObserver(this);
		initHelper();
	}

	public abstract void initHelper();

	/**
	 *  Attack and the make specific effects based on specific weapon state. 
	 */
	@Override
	public void attack() {
		stateManager.fire();
		allowFire = false;
	}

	/**
	 *  Register new player state to grant the fighter more features.  
	 */

	public void addState(PlayerState newState) {
		stateManager.registerNewState(newState);
	}

	public void changeAssistanceState(Object state) {
		stateManager.changeAssistanceState(state);

	}

	public void genAssistance() {
		stateManager.genAssistance();

	}

	/**
	 *  Update the states of the fighter based the time.  
	 */

	public void stateUpdate(long elapsedTime) {
		stateManager.update(elapsedTime);
	}

}