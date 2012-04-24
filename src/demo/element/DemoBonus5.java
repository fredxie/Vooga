package demo.element;

import java.awt.image.BufferedImage;

import demo.playerState.PhysicCollisionStatus;

import api.element.Bonus;
import api.element.Element;
import api.element.RegularFighter;
import api.element.TopDownPlayField;
import api.playerState.CollisionState;
import api.playerState.CollisionStatus;

/**
 * 
 * @author Yi Ding
 *
 */

public class DemoBonus5 extends Bonus {

	private CollisionStatus state;

	// = new Laser(
	// TopDownImageUtil.getImage("images/game/bigLaser1.png"));
	public DemoBonus5(TopDownPlayField playfield, BufferedImage image,
			CollisionStatus status) {
		super(playfield, image);
		this.state = status;

	}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.getCollisionState().changeState(state);

	}

	public Element clone() {
		DemoBonus5 db = new DemoBonus5(this.playfield, this.getImage(),
				this.state);
		db.init();
		return db;
	}

}
