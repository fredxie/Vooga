package util;


import element.Element;
import element.Fighter;
import background.TopDownBackground;
import background.TopDownTileBackground;
import game.TopDownGameEngine;


public class TopDownAreaUtil {

	public static void limitArea(Element ele, TopDownTileBackground background, double height, double width) {
		//when ammunition upgrades or enemies come to the left or right side of screen, bounce it 
		if (ele.getX() < background.getX()) {
			ele.setX(background.getX());
			ele.setHorizontalSpeed(-ele.getHorizontalSpeed());
		}

		if (ele.getX() + ele.getWidth() > background.getX()
				+ width) {
			ele.setX(background.getX() + width
					- ele.getWidth());
			ele.setHorizontalSpeed(-ele.getHorizontalSpeed());
		}
	}
	
	public static void setFighterArea(Fighter fighter, TopDownTileBackground background, double height, double width) {
		// the fighter can't move out of screen boundary
		if (fighter.getX() < background.getX()) {
			fighter.setX(background.getX());
		}
		if (fighter.getY() < background.getY()) {
			fighter.setY(background.getY());
		}
		if (fighter.getY() + fighter.getHeight() > background.getY()
				+ height) {
			fighter.setY(background.getY() + height
					- fighter.getHeight());
		}
		if (fighter.getX() + fighter.getWidth() > background.getX()
				+ width) {
			fighter.setX(background.getX() + width
					- fighter.getWidth());
		}
	}

}
