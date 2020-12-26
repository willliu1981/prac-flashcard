package com.command.execute;

import java.sql.SQLException;

import com.controller.dao.Dao;
import com.controller.main.App;
import com.model.main.Card;

public class QueryCardExecute extends Execute<Card> implements ModelExecute {
	private static final String modelName=App.getDaoSimpleName("card");
	@Override
	public int execute(Dao<Card> dao) throws ClassNotFoundException, SQLException {
		dao.queryall().forEach(c-> System.out.println("%card% "+c));
		return 0;
	}

	@Override
	public int execute(Dao<Card> dao,String [] datas) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public  String getModelname() {
		return modelName;
	}

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}
	
	

}
