package com.controller.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//取得config 設定檔 和初始化狀態設定
public class App {
	private static Properties props=new Properties();
	
	public static void LoadConfig(String config) {
		try {
			props.load(new FileInputStream(config));
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
