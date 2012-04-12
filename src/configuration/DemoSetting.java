package configuration;

/**
 * @author Ran Zhang
 */


public class DemoSetting extends Setting{

	@Override
	public void setList() {
		keySettingList.add(GameParameters.UP);
		keySettingList.add(GameParameters.DOWN);
		keySettingList.add(GameParameters.LEFT);
		keySettingList.add(GameParameters.RIGHT);
		keySettingList.add(GameParameters.FIRE);
		
		paraSettingList.add(GameParameters.ENEMY_NUM);
		paraSettingList.add(GameParameters.BOMB_NUM);
		paraSettingList.add(GameParameters.BLOCK_NUM);
		paraSettingList.add(GameParameters.lifeNum);
		paraSettingList.add(GameParameters.BONUS_NUM);
		paraSettingList.add(GameParameters.BACKGROUND_SPEED);
	}

	
//	
//	public static void main(String[] args) {
//
//		DemoSetting s = new DemoSetting();
//	}

}
