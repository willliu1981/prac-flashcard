package com.model.main;

import java.io.Serializable;
import java.sql.Date;

import com.google.gson.Gson;

public abstract class Model implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3242564430268552913L;
	protected Integer id;
	protected Date create_time;
	protected Date update_time;
	protected String describe;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	public String toString() {
		Gson g=new Gson();
		String s=g.toJson(this);
		return "json: "+s;
	}
}
