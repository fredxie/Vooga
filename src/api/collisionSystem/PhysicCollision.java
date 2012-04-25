package api.collisionSystem;


import api.element.Element;

import com.golden.gamedev.object.Sprite;

/**
 * This class extends CollisionAction to help developer use momentum law in collision.
 * 
 
 * @author Yi Ding
 *
 */
public class PhysicCollision extends CollisionAction {

	/**
	 * Overrride reaction method to operate momentum law
	 */
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		Element e1 = (Element) s1;
		Element e2 = (Element) s2;

		// momentum law begins
		double dx = e2.getX() - e1.getX();
		double dy = e2.getY() - e1.getY();
		double dist = Math.sqrt(dx * dx + dy * dy);

		double angle = Math.atan2(dy, dx);
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);

		// reverse rotate and treat s1 as rotate center

		double xA = 0; // relatively coordinate is (0,0)
		double yA = 0;

		double xB = dx * cos + dy * sin;
		double yB = dy * cos - dx * sin;

		// reverse rotate speed relative to s1
		double vxA = e1.getHorizontalSpeed() * cos + e1.getVerticalSpeed()
				* sin;
		double vyA = e1.getVerticalSpeed() * cos - e1.getHorizontalSpeed()
				* sin;
		double vxB = e2.getHorizontalSpeed() * cos + e2.getVerticalSpeed()
				* sin;
		double vyB = e2.getVerticalSpeed() * cos - e2.getHorizontalSpeed()
				* sin;

		// after rotate, vx momentum calculate
		double vdx = vxA - vxB;
		double vxAFinal = (e1.getMass() - e2.getMass() * vxA + 2 * e2.getMass()
				* vxB)
				/ (e1.getMass() + e2.getMass());
		double vxBFinal = vxAFinal + vdx;

		// deal with relative location
		xA += vxAFinal;
		xB += vxBFinal;

		// rotate back
		double xAFinal = xA * cos - yA * sin;
		double yAFinal = yA * cos + xA * sin;
		double xBFinal = xB * cos - yB * sin;
		double yBFinal = yB * cos + xB * sin;

		// deal with eventually location change
		e1.setLocation(e1.getX() + xAFinal, e1.getY() + yAFinal);
		e2.setLocation(e1.getX() + xBFinal, e1.getY() + yBFinal);

		// deal with eventually speed change
		e1.setSpeed(vxAFinal * cos - vyA * sin, vyA * cos + vxAFinal * sin);
		e2.setSpeed(vxBFinal * cos - vyB * sin, vyB * cos + vxBFinal * sin);

	}

}
