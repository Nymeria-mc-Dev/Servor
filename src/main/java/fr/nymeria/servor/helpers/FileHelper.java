package fr.nymeria.servor.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileHelper {

	private static File servorFolder;
	private static File serversFolder;
	private static File starterFile;
	private static File serversConfig;
	private static File servers;

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
		serversConfig = new File(serversFolder + "\\Configs");
		if(!serversConfig.exists()) {
			serversConfig.mkdir();
		}
		servers = new File(serversFolder + "\\Servers");
		if(!servers.exists()) {
			servers.mkdir();
		}

		File[] files = serversFolder.listFiles();

		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File f1, File f2) {
				return Long.compare(f2.lastModified(), f1.lastModified());
			}
		});

		for (File file : files) {
			System.out.println(file.getName() + " : " + file.lastModified());
		}
	}

	public static File getServersConfigFolder() {
		return serversConfig;
	}

	public static File getServersFolder() {
		return servers;
	}

	public static void write(File FileToWrite, JSONObject object) {
		try (FileWriter file = new FileWriter(FileToWrite)) {
			file.write(object.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject read(File FileToRead) {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(starterFile)){
			JSONObject obj = (JSONObject) jsonParser.parse(reader);

			return obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
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


}
