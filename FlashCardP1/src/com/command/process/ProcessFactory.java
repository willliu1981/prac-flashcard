package com.command.process;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.command.execute.Execute;
import com.controller.dao.Dao;
import com.controller.main.App;

public  class ProcessFactory {
	public final String queryProcess=App.getDaoClassPath("");
	public final String addProcess=App.getDaoClassPath("");
	public final String tableProcess=App.getDaoClassPath("");
	
	private String processName;
	private Process process;
	private Execute[] executes;
	static private Dao dao;
	
	
	private ProcessFactory(String processName,Execute ...executes) {
		this.executes=executes;
		this.processName=processName;
	}
	
	public static ProcessFactory getFactory(String processName,Execute ...executes) {
		return new ProcessFactory(processName,executes);
	}
	public static ProcessFactory getFactory(String processName) {
		return getFactory(processName,null);
	}
	
	public Process getProcess() {
		try {
			Class<?> c=Class.forName(App.getProcessClassPath(this.processName.toLowerCase()));
			Constructor<?> ctor = c.getConstructor(ProcessFactory.class,Execute[].class);
			process=(Process)ctor.newInstance(this,this.executes);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return process;
	}

	
	public static Dao getDao() {
		return dao;
	}

	public static void setDao(Dao dao) {
		ProcessFactory.dao = dao;
	}
}
