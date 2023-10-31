package utils;

import enums.DriverType;

import java.nio.file.Path;
import java.util.Optional;

public class ProjectData {
    public static String browserPath;
    public static String env = System.getProperty("Environment");
    public static String appUrl = Utils.getFrameworkProperty(env, "appUrl");
    public static DriverType browser = DriverType.valueOf(System.getProperty("browser").toUpperCase());
    public static String suitName = Utils.getFrameworkProperty(env,"suitName");
}
