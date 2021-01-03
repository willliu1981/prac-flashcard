package com.controller.conn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.controller.main.App;

public class Conn {
	static private Conn conn=new Conn();
	//初始化連線相關資料
	static {
		try {
			conn.init(App.getDatabaseInitPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private Conn() {}
	
	public static Conn instance() {
		return conn;
	}
	
	
	public Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	//初始化連線相關資料
	public void init(String settingPath) throws FileNotFoundException, IOException {
		Properties props=new Properties();
		props.load(new FileInputStream(settingPath));
		driver=props.getProperty("driver");
		url=props.getProperty("url");
		user=props.getProperty("user");
		password=props.getProperty("password");
	}

}
