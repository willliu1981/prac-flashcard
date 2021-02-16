package com.controller.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T> {
	protected final String type;

	protected Dao(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	// CRUD 的read
	public abstract List<T> queryAll() throws SQLException, ClassNotFoundException;

	// CRUD 的read
	public abstract T query(int id) throws ClassNotFoundException, SQLException;

	// CRUD 的Create
	public abstract void add(T t) throws SQLException, ClassNotFoundException;

	// CRUD 的Update
	public abstract void update(T t, int id) throws SQLException, ClassNotFoundException;

	// CRUD 的Delete
	public abstract void delete(int id) throws SQLException, ClassNotFoundException;

}
