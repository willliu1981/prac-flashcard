package com.controller.main;

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
	
	public static String getDaoClassPath(String name) {
		return props.getProperty(name.toLowerCase()+"-dao");
	}
	
	public static String getProcessClassPath(String name) {
		return props.getProperty(name.toLowerCase()+"-process");
	}
	
	public static String getDaoSimpleName(String name) {
		return props.getProperty(name.toLowerCase()+"-name");
	}
	
	public static String getDatabaseInit() {
		return App.getBasePath()+"\\"+ props.getProperty("database")+".ini";
	}
}
