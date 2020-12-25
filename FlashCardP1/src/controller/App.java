package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class App {
	private static Properties props=new Properties();
	static {
		try {
			props.load(new FileInputStream("resource\\config.cfg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getBasePath() {
		return props.getProperty("basepath");
	}
	
	public static String getTable(String name) {
		return props.getProperty(name.toLowerCase().trim());
	}
}
