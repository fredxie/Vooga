package menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import element.Element;

/*
 * Class provide load and save method for TopDownMenu to store and get edited level
 */
public class GameSL {
	
	public GameSL() {}
	
	public String saveLevel(ArrayList<Element> ele, String levelname) throws IOException {
		Gson gson = new Gson();
        String jsonString = gson.toJson(ele);
        System.out.println("Generated json text: " + jsonString);
        
        //Write JSON string to a file
        String add = levelname + ".jason";
        FileWriter fileOut = new FileWriter(add);
        BufferedWriter out = new BufferedWriter(fileOut);
        out.write(jsonString);
        out.close();
        
        return add;
	}
	
	public ArrayList<Element> loadLevel(String add) throws FileNotFoundException {
		Gson gson = new Gson();
		Scanner scanner = new Scanner(new File(add));
        String wholeFile = scanner.useDelimiter("\\A").next();

        Type collectionType = new TypeToken<ArrayList<Element>>(){}.getType();
        ArrayList<Element> target = gson.fromJson(wholeFile, collectionType);
        
        return target;
	}
}
