package com.controller.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T> {
	protected final String type;
	
	protected Dao(String type) {
		this.type=type;
	}
	
	public String getType() {
		return this.type;
	}

	public abstract List<T> queryall() throws SQLException, ClassNotFoundException;

	public abstract T query(int id) throws ClassNotFoundException, SQLException;

	public abstract void add(T t) throws SQLException, ClassNotFoundException;

	public abstract void update(T t, int id) throws SQLException, ClassNotFoundException;

	public abstract void delete(int id) throws SQLException, ClassNotFoundException;
}
