package api.util;

/**
 * Utility methods for json operations
 * @author Ran Zhang
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import api.configuration.Key;

import com.golden.gamedev.GameObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JsonUtil {

	/**
	 * parse map from a json file
	 */
	public static HashMap<String, Integer> parse(String fileName) {
		Gson gson = new Gson();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fileName));
			String wholeFile = scanner.useDelimiter("\\A").next();
			Type collectionType = new TypeToken<HashMap<String, Integer>>() {
			}.getType();
			map = gson.fromJson(wholeFile, collectionType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * write a map to a json file
	 */
	public static void output(HashMap<String, Integer> map, String fileName) {

		Gson gson = new Gson();
		try {
			FileWriter out = new FileWriter(fileName);
			BufferedWriter bufferedOut = new BufferedWriter(out);
			bufferedOut.write(gson.toJson(map));
			bufferedOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * create key list for the KeyPressedObserver
	 */
	public static List<Key> createKeyList(Object obj, String fileName,
			GameObject myGame) {
		HashMap<String, Integer> keyMap = JsonUtil.parse(fileName);
		List<Key> keyList = new ArrayList<Key>();
		for (String action : keyMap.keySet()) {
			keyList.add(new Key(keyMap.get(action), action, obj, myGame));
		}
		return keyList;
	}
	
	/**
	 * developers may add new functions that relate to key-pressing.
	 * This method registers the new functions.
	 */
	public static void registerKeyAcion(String action, int keyValue) {
		HashMap<String, Integer> map = JsonUtil.parse("json/keyConfig.json");
		map.put(action, keyValue);
		JsonUtil.output(map, "json/keyConfig.json");
	}

}
