package hud;

import java.util.HashMap;

public class InfoFactory {
	private String infoType;
	private Object myObject;
	private HashMap<String, HUDInfo> myMap;
	
	public InfoFactory (String type, Object obj) {
		infoType = type;
		myObject = obj;	
		constructMap();
	}
	
	private void constructMap() {
		myMap = new HashMap<String, HUDInfo>();
		myMap.put("level", new LevelInfo());
		myMap.put("score", new ScoreInfo());
		myMap.put("hp", new HPInfo());
		myMap.put("weapon", new WeaponInfo());
		myMap.put("life", new LifeInfo());
	}
	
	public void addIntoMap(String str, HUDInfo hdInfo) {
		myMap.put(str, hdInfo);
	}
	
	public String getInfo() {
		return myMap.get(infoType).getString(myObject);
	}
}