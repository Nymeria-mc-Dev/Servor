package fr.nymeria.servor.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.nymeria.servor.App;

public class FileHelper {

	private static final double CONFIGVERSION = 0.02;
	
	private static boolean startFileExist;

	private static File servorFolder;
	private static File serversFolder;
	private static File starterFile;
	private static File serversConfig;
	private static File servers;
	private static File config;

	@SuppressWarnings("unchecked")
	public static void init() {
		servorFolder = new File(System.getenv("APPDATA") + "\\.Servor");
		if (!servorFolder.exists()) {
			servorFolder.mkdir();
		}

		config = new File(servorFolder + "\\config.json");
		if(!config.exists() || JsonHelper.getDoubleValue(read(getConfig()), "version") < CONFIGVERSION) {
			String fileUrl = App.getResource("/json/config.json").toExternalForm();

			try {
				URL url = new URL(fileUrl);
				InputStream inputStream = url.openStream();

				String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
				Path targetPath = Path.of(servorFolder.toString(), fileName);

				Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
				
				String serversPath = JsonHelper.getStringValue(read(config), "Servers Path");
				
				if(serversPath != "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.Servor\\Servers") {
					JSONObject object = read(config);
					
					object.put("Servers Path", "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.Servor\\Servers");
					
					write(config, object);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String serversPath = JsonHelper.getStringValue(read(config), "Servers Path");
		
		
		
		serversFolder = new File(serversPath);
		if(!serversFolder.exists()) {
			serversFolder.mkdir();
		}

		starterFile = new File(servorFolder + "\\Start.json");
		if(!starterFile.exists()) {
			startFileExist = false;
			try {
				starterFile.createNewFile();
			} catch (IOException e) {
				e.fillInStackTrace();
			}
		}else {
			startFileExist = true;
		}
		serversConfig = new File(serversFolder + "\\Configs");
		if(!serversConfig.exists()) {
			serversConfig.mkdir();
		}
		servers = new File(serversFolder + "\\Servers");
		if(!servers.exists()) {
			servers.mkdir();
		}
		
		config = new File(servorFolder + "\\config.json");
		if(!config.exists() || JsonHelper.getDoubleValue(Objects.requireNonNull(read(getConfig())), "version") < CONFIGVERSION) {
			String fileUrl = App.getResource("/json/config.json").toExternalForm();

			try {
				URL url = new URL(fileUrl);
				InputStream inputStream = url.openStream();

				String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
				Path targetPath = Path.of(servorFolder.toString(), fileName);

				Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.fillInStackTrace();
			}
		}

		File[] files = Objects.requireNonNull(serversFolder.listFiles());

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

	public static File getServorFolder() {
		return servorFolder;
	}
	
	public static File getConfig() {
		return config;
	}

	public static void write(File FileToWrite, JSONObject object) {
		try (FileWriter file = new FileWriter(FileToWrite)) {
			file.write(object.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.fillInStackTrace();
		}
	}

	public static JSONObject read(File FileToRead) {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(FileToRead)){
			JSONObject obj = (JSONObject) jsonParser.parse(reader);

			return obj;
		} catch (IOException | ParseException e) {
			e.fillInStackTrace();
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
			e.fillInStackTrace();
		}
	}

	public static double[] getAppLoc() {

		if(startFileExist) {
			JSONParser jsonParser = new JSONParser();

			try (FileReader reader = new FileReader(starterFile)){

                JSONObject obj = (JSONObject) jsonParser.parse(reader);
                double[] loc = {(double) obj.get("x"), (double) obj.get("y")};

                return loc;
            } catch (IOException | ParseException e) {
				e.fillInStackTrace();
			}
        }
		
		double[] loc = {};
		
		return loc;
	}


}
