package menu;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import element.Element;

/*
 * Class provide load and save method for TopDownMenu to store and get edited level
 */
public class GameSL {
	private static final String Inteval = "ok";

	public GameSL() {
	}

	public String saveLevel(ArrayList<Element> ele,
			HashMap<Integer, String> map, String levelname) throws IOException {
		Gson gson = new Gson();
		String jsonString_list = gson.toJson(ele);
		String jsonString_map = gson.toJson(map);
		String jsonString = jsonString_list + Inteval + jsonString_map;
		System.out.println("Generated json text: " + jsonString);

		// Write JSON string to a file
		String add = levelname + ".jason";
		FileWriter fileOut = new FileWriter(add);
		BufferedWriter out = new BufferedWriter(fileOut);
		out.write(jsonString);
		out.close();

		return add;
	}

	public ArrayList<Element> loadElement(String add)
			throws FileNotFoundException {
		Gson gson = new Gson();
		Scanner scanner = new Scanner(new File(add));
		String wholeFile = scanner.useDelimiter("\\A").next();
		System.out.println(wholeFile);
		String[] whole = wholeFile.split(Inteval);

		Type collectionType = new TypeToken<ArrayList<Element>>() {
		}.getType();
		ArrayList<Element> target = gson.fromJson(whole[0], collectionType);

		return target;
	}

	public HashMap<Integer, String> loadMap(String add)
			throws FileNotFoundException {
		Gson gson = new Gson();
		Scanner scanner = new Scanner(new File(add));
		String wholeFile = scanner.useDelimiter("\\A").next();
		String[] whole = wholeFile.split(Inteval);

		Type collectionType = new TypeToken<HashMap<Integer, String>>() {
		}.getType();
		HashMap<Integer, String> target = gson.fromJson(whole[1],
				collectionType);

		return target;

	}
}
