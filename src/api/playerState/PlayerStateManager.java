package api.playerState;

import java.util.ArrayList;
import java.util.List;

import api.element.AutoFighter;
import api.element.Fighter;
import api.element.RegularFighter;

/**
 * This class performs as central manager of playerState, it can encapsulate all
 * player states and act as the intermediator between fighter and player state.
 * 
 * @author Shiyuan Wang
 * 
 */

public class PlayerStateManager {

	Fighter fighter;
	protected WeaponState weaponState;
	protected AssistanceState assistanceState;
	protected CollisionState collisionState;
	protected List<PlayerState> stateList = new ArrayList<PlayerState>();

	public PlayerStateManager(RegularFighter fighter) {
		this.fighter = fighter;
		weaponState = new WeaponState(fighter, fighter.getWeaponStyle(),
				fighter.getWeaponDamage());
		assistanceState = new AssistanceState(fighter);
		collisionState = new CollisionState(fighter);
		stateList.add(weaponState);
		stateList.add(assistanceState);
		stateList.add(collisionState);
	}

	public PlayerStateManager(AutoFighter fighter) {
		this.fighter = fighter;
		weaponState = new WeaponState(fighter, fighter.getWeaponStyle(),
				fighter.getWeaponDamage());
		stateList.add(weaponState);
	}

	/**
	 * Set the weapon according to weapon style and weapon damage
	 * 
	 */
	public void setWeapon(int weaponStyle, double weaponDamage) {
		weaponState.setWeapon(weaponStyle, weaponDamage);
	}

	/**
	 * Change the state of Weapon based on the passed parameter
	 * 
	 */
	public void changeWeaponState(Object bullet) {
		weaponState.changeState(bullet);
	}

	public void setWeaponStyle(int weaponStyle) {
		weaponState.setWeaponStyle(weaponStyle);
	}

	public void setWeaponDamage(double weaponDamage) {
		weaponState.setWeaponDamage(weaponDamage);
	}

	public int getWeaponStyle() {
		return weaponState.getWeaponStyle();
	}

	public double getWeaponDamage() {
		return weaponState.getWeaponDamage();
	}

	/**
	 * Fire by different weapons according to current weapon state
	 * 
	 */

	public void fire() {
		weaponState.fire();
	}

	public void changeNumOFBullet(int change) {
		weaponState.changeNumOFBullet(change);

	}

	public void changeWeaponDamage(double change) {
		weaponState.changeWeaponDamage(change);
	}

	public WeaponState getWeaponState() {
		return weaponState;
	}

	public void changeCollisionState(Object collisionStatus) {
		collisionState.changeState(collisionStatus);
	}

	public String getCollisionID() {
		return collisionState.getID();
	}

	public void changeAssistanceState(Object state) {
		assistanceState.changeState(state);

	}

	public void genAssistance() {
		assistanceState.genAssistance();
	}

	/**
	 * Add new State as the properties of the fighter
	 * 
	 */

	public void registerNewState(PlayerState newState) {
		stateList.add(newState);

	}

	public CollisionState getCollisionState() {
		return collisionState;
	}

	public AssistanceState getAssistanceState() {
		return assistanceState;
	}

	/**
	 * update the fighter from time to time
	 * 
	 */

	public void update(long elapsedTime) {

		for (PlayerState state : stateList) {
			if (state != null)
				state.update(elapsedTime);
		}

	}

}
