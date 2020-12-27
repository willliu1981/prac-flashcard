package com.command.execute;

import java.sql.SQLException;

import com.controller.dao.Dao;

public abstract class Execute<T> {
	public abstract int execute(Dao<T> dao) throws ClassNotFoundException, SQLException;

	public abstract int execute(Dao<T> dao, String[] datas) throws ClassNotFoundException, SQLException;

	public String getTip() {
		return "指令錯誤!";
	}

}
