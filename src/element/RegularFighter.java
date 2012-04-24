package element;

/**
 * 
 * @author ShiyuanWang
 */
import game.TopDownTimer;
import gameLevel.GameLevel;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import playerState.AssistanceState;
import playerState.CollisionState;
import playerState.PlayerState;
import util.JsonUtil;
import configuration.api.FighterKeyChangedObserver;
import configuration.api.FighterKeyPressedObserver;
import configuration.api.Key;
import configuration.api.KeyAnnotation;

public abstract class RegularFighter extends Fighter {

	private List<Key> keyList;
	public boolean allowBomb = true;
	public TopDownTimer rebombRate;
	public AssistanceState assistanceState;
	public CollisionState collisionState;
	public AutoFighter assistance;
	public double moveSpeed; // (default)
	public boolean allowFire = true;
	public GameLevel game;
	public BufferedImage bulletImage;
	public List<PlayerState> stateList = new ArrayList<PlayerState>();
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

	@Override
	public void attack() {

		weaponState.fire();
		allowFire = false;
	}

	public void addState(PlayerState newState) {
		stateList.add(newState);
	}

	public void stateUpdate(long elapsedTime) {
		for (PlayerState state : stateList) {
			state.update(elapsedTime);

		}
	}

}