package com.command.execute;

import java.sql.SQLException;

import com.controller.dao.Dao;

public interface  IMenuExecute<T> {

	public abstract int execute(int accessCode, String[] datas) ;
	
}
