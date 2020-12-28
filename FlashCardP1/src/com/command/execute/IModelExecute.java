package com.command.execute;

import java.sql.SQLException;

import com.controller.dao.Dao;

public interface  IModelExecute<T> {
	
	public String getModelName();
	public abstract int execute(Dao<T> dao, int accessCode, String[] datas) throws ClassNotFoundException, SQLException;
	
}
