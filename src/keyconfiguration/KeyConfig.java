package keyconfiguration;
/**
 * 
 * @author Ran Zhang
 * 
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.JsonUtil;

import com.golden.gamedev.GameObject;

import configuration.GameParameters;

import element.Fighter;

public class KeyConfig {
	public static HashMap<GameParameters, Integer> keyMap = new HashMap<GameParameters, Integer>();
	private List<Key> keyList = new ArrayList<Key>();
	private Fighter player;
	private GameObject myGame;

	public KeyConfig(Fighter player, GameObject game) {
		myGame = game;
		this.player = player;
	}

	public void initialization() {

	}

	public HashMap<GameParameters, Integer> getKeyMap() {
		return keyMap;
	}

	public List<Key> getKeyList() {
		return keyList;
	}

	public void parseKeyConfig(String fileName) {
		keyMap = JsonUtil.parse(fileName);
		for (GameParameters action : keyMap.keySet()) {
			keyList.add(new Key(keyMap.get(action), action, player, myGame));
		}
	}

	public void setCustomKey(String fileName, int customKey, GameParameters action)
			throws FileNotFoundException {
		keyMap.put(action, customKey);
	}

	public static void outputJsonFile(String fileName) throws IOException {
		JsonUtil.output(keyMap, fileName);
	}
}