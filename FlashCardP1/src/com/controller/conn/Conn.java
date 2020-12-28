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
	static {
		try {
			conn.init(App.getDatabaseInit());
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
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Conn conn= new Conn();
		conn.init("resource\\mysql.ini");
		System.out.println("test:"+conn.driver);
		conn.getConn();
		
	}
	
	public Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url, user, password);
		//System.out.println("Connect successfully");
		return conn;
	}
	
	
	public void init(String setting) throws FileNotFoundException, IOException {
		Properties props=new Properties();
		props.load(new FileInputStream(setting));
		driver=props.getProperty("driver");
		url=props.getProperty("url");
		user=props.getProperty("user");
		password=props.getProperty("password");
	}

}
