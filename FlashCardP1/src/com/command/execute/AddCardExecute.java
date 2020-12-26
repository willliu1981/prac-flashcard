package com.command.execute;

import java.sql.Date;
import java.sql.SQLException;

import com.controller.dao.Dao;
import com.controller.main.App;
import com.model.main.Card;
import com.model.main.Vocabulary;

public class AddCardExecute extends Execute<Card> implements ModelExecute {
	private static final String modelName = App.getDaoSimpleName("card");

	@Override
	public int execute(Dao<Card> dao, String[] datas) throws ClassNotFoundException, SQLException {
		
		Card m = new Card();
		m.setName(datas[1]);
		m.setV_id(Integer.valueOf(datas[2]));
		m.setCreate_time(new Date(new java.util.Date().getTime()));
		dao.add(m);
		return 0;
	}

	@Override
	public int execute(Dao<Card> dao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

}
