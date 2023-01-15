package fr.nymeria.servor.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileHelper {

	private static File servorFolder;
	private static File serversFolder;
	private static File starterFile;

	public static void init() {
		servorFolder = new File(System.getenv("APPDATA") + "\\.Servor");
		if (!servorFolder.exists()) {
			servorFolder.mkdir();
		}

		serversFolder = new File(servorFolder + "\\Servers");
		if(!serversFolder.exists()) {
			serversFolder.mkdir();
		}

		starterFile = new File(servorFolder + "\\Start.json");
		if(!starterFile.exists()) {
			try {
				starterFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void setAppLoc(double x, double y) {

		JSONObject obj = new JSONObject();
		obj.put("x", x);
		obj.put("y", y);

		try (FileWriter file = new FileWriter(starterFile)) {
			file.write(obj.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static double[] getAppLoc() {

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(starterFile)){
			JSONObject obj = (JSONObject) jsonParser.parse(reader);
			double[] loc = {(double) obj.get("x"), (double) obj.get("y")};

			return loc;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static File getServersFolder() {
		return serversFolder;
	}

}
