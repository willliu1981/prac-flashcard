package com.command.process;

import java.lang.reflect.Constructor;
import com.command.execute.Execute;
import com.controller.dao.Dao;
import com.controller.main.App;

//取得ProcessFactory實體, 用於取得Process實體
public class ProcessFactory {

	private String processType;
	private String argumentName;
	private Process process;
	private Execute[] executes;
	static private Dao dao;// 有點失敗的存取Dao, 暫時保留, 待改進

	private ProcessFactory(String processType, String argumentName, Execute... executes) {
		this.argumentName = argumentName;
		this.executes = executes;
		this.processType = processType;
	}

	public static ProcessFactory getFactory(String processType, String argumentName, Execute... executes) {
		return new ProcessFactory(processType, argumentName, executes);
	}

	public static ProcessFactory getFactory(String processType, String argumentName) {
		return new ProcessFactory(processType, argumentName);
	}

	// 取得Process實體
	public Process getProcess() {
		try {
			// 從config 取得對應類別名稱, 經由App 取得
			Class<?> c = Class.forName(App.getProcessClassPath(this.processType.toLowerCase()));
			Constructor<?> ctor;
			process = (Process) c.newInstance();
			process.setParameters(this.argumentName, this, executes);
		} catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException e) {
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
