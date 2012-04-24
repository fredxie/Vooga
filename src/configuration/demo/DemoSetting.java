package configuration.demo;

import configuration.api.Setting;

/**
 * @author Ran Zhang
 */

public class DemoSetting extends Setting {

	@Override
	public void setList() {
		keySettingList.add("UP");
		keySettingList.add("DOWN");
		keySettingList.add("LEFT");
		keySettingList.add("RIGHT");
		keySettingList.add("FIRE");
		// keySettingList.add("BOMB");

		paraSettingList.add("ENEMY_NUM");
		paraSettingList.add("BOMB_NUM");
		paraSettingList.add("lifeNum");
		paraSettingList.add("FIGHTER_HP");
		paraSettingList.add("BACKGROUND_SPEED");
	}

}
