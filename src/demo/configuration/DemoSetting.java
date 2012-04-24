package demo.configuration;

import api.configuration.Setting;

/**
 * @author Ran Zhang
 */

@SuppressWarnings("serial")
public class DemoSetting extends Setting {

	@Override
	public void setList() {
		keySettingList.add("UP");
		keySettingList.add("DOWN");
		keySettingList.add("LEFT");
		keySettingList.add("RIGHT");
		keySettingList.add("FIRE");

		paraSettingList.add("ENEMY_NUM");
		paraSettingList.add("BOMB_NUM");
		paraSettingList.add("lifeNum");
		paraSettingList.add("FIGHTER_HP");
		paraSettingList.add("BACKGROUND_SPEED");
	}

}
