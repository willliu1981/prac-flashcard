package com.command.process;

import java.sql.SQLException;

import com.command.execute.Execute;
import com.command.execute.ModelExecute;
import com.controller.dao.Dao;

public abstract class Process  {

	protected String[] userIn;
	protected Dao<?> dao;
	protected ModelExecute[] executes;

	protected Process( ModelExecute... executes) {
		this.executes = executes  ;
	}
	
	public  boolean filter(String[] userIn) {
		this.userIn=userIn;
		return false;
	}
	
	public void setDao(Dao<?> dao) {
		this.dao=dao;
	}

	public Dao<?> getDao() {
		return this.dao;
	}

	public abstract int execute();
	
	public abstract String getArgument() ;
}
