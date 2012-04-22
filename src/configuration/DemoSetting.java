package configuration;

/**
 * @author Ran Zhang
 */

public class DemoSetting extends Setting {

	@Override
	public void setList() {
		keySettingList.add(GameParameters.UP);
		keySettingList.add(GameParameters.DOWN);
		keySettingList.add(GameParameters.LEFT);
		keySettingList.add(GameParameters.RIGHT);
		keySettingList.add(GameParameters.FIRE);
		keySettingList.add(GameParameters.BOMB);

		paraSettingList.add(GameParameters.ENEMY_NUM);
		paraSettingList.add(GameParameters.BOMB_NUM);
		paraSettingList.add(GameParameters.lifeNum);
		paraSettingList.add(GameParameters.FIGHTER_HP);
		paraSettingList.add(GameParameters.BACKGROUND_SPEED);
	}

}
