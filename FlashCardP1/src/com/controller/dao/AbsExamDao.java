package com.controller.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class AbsExamDao<T> {
	protected final String type;
	protected AbsExamDao(String type) {
		this.type=type;
	}

	public abstract void add(T t) throws ClassNotFoundException, SQLException;

	public abstract List<T> queryAll()throws ClassNotFoundException, SQLException;

	public abstract T queryId(int id)throws ClassNotFoundException, SQLException;

	public abstract T queryBox(int id)throws ClassNotFoundException, SQLException;

	public abstract T queryCard(int id)throws ClassNotFoundException, SQLException;

	public abstract void update(T t, int id)throws ClassNotFoundException, SQLException;

}
