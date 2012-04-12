package util;


/**
 * @author Ran Zhang
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import configuration.GameParameters;

public class JsonUtil {
	
	public static HashMap<GameParameters, Integer> parse(String fileName) {
		Gson gson = new Gson();
		HashMap<GameParameters, Integer> map = new HashMap<GameParameters, Integer>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fileName));
			String wholeFile = scanner.useDelimiter("\\A").next();
			Type collectionType = new TypeToken<HashMap<GameParameters, Integer>>() {
			}.getType();
			map = gson.fromJson(wholeFile, collectionType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void output(HashMap<GameParameters, Integer> map, String fileName) {

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

}