package com.model.main;

import java.io.Serializable;
import java.sql.Date;

import com.google.gson.Gson;



public abstract class Model implements Serializable {

	public String toString() {
		Gson g=new Gson();
		String s=g.toJson(this);
		return "json: "+s;
	}
}
