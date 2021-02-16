package com.command.execute;

import java.sql.SQLException;

import com.controller.dao.Dao;

public abstract class Execute<T> {
	public abstract int execute(int accessCode);

	public abstract int execute(int accessCode, String[] datas);

	public String getTip() {
		return "未知錯誤";
	}

}
