package fr.nymeria.servor.helpers;

import org.json.simple.JSONObject;

public class JsonHelper {

	public static boolean getBooleanValue(JSONObject object, String value) {
		return (boolean) object.get(value);
	}
	
	public static double getDoubleValue(JSONObject object, String value) {
		return (double) object.get(value);
	}
	
	public static String getStringValue(JSONObject object, String value) {
		return (String) object.get(value);
	}
	
}
