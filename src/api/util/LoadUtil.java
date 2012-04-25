package api.util;

/**
 * Utility methods for load levels in json files
 * @author Ran Zhang
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LoadUtil {

	/**
	 * LevelEditor can save edited levels into json files using this method
	 */
	public static void saveJson(List<List<Object>> list, String fileName) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		// System.out.println("Generated json text: " + jsonString);

		FileWriter fileOut;
		try {
			fileOut = new FileWriter("json/" + fileName + ".json");
			BufferedWriter out = new BufferedWriter(fileOut);
			out.write(jsonString);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * load the json file of game level
	 */
	public static List<List<Object>> loadJson(File file) {
		Scanner scanner;
		List<List<Object>> outList = null;
		try {
			scanner = new Scanner(file);
			String wholeFile = scanner.useDelimiter("\\A").next();
			Type collectionType = new TypeToken<List<List<Object>>>() {
			}.getType();
			Gson gson = new Gson();
			outList = gson.fromJson(wholeFile, collectionType);
			System.out.println(outList.get(1));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return outList;
	}

}
