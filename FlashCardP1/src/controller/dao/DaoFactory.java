package controller.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import controller.App;

public class DaoFactory {
	
	
	public static Dao getDao(String name) {
		Dao d=null;
		Properties props=new Properties();
		try {
			props.load(new FileInputStream(App.getBasePath()+"config.cfg"));
			Class<?> c=Class.forName(props.getProperty(name));
			Constructor<?>  ctor=c.getConstructor(String.class);
			d=(Dao<?>)ctor.newInstance(props.getProperty(name));
			//d=(Dao)c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}
}
