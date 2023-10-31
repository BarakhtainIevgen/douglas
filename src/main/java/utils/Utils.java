package utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Utils {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
    public static String getCurrentTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

	public static String getFrameworkProperty(String section, String property) {

		String propertyValue = "";

		System.out.println(ANSI_GREEN + String.format("Read property '%s' from section '%s' in configuration", property, section) + ANSI_RESET);

		try {
			FileReader json = new FileReader(System.getProperty("user.dir") + "/config.json");

			JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
			propertyValue = jsonObject.getAsJsonObject(section).get(property).getAsString();

		} catch (FileNotFoundException e) {
			System.out.println(ANSI_RED + "Configuration file (config.json) not found" + ANSI_RESET);
		} catch (Exception e) {
			System.out.println(ANSI_RED + "Property not found!" + ANSI_RESET);
		}

		return propertyValue;
	}
}
