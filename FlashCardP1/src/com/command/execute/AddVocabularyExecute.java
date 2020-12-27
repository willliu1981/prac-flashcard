package com.command.execute;

import java.sql.Date;
import java.sql.SQLException;

import com.controller.dao.Dao;
import com.controller.main.App;
import com.model.main.Vocabulary;

public class AddVocabularyExecute extends Execute<Vocabulary> implements ModelExecute {
	private static final String modelName=App.getDaoSimpleName("vocabulary");

	@Override
	public int execute(Dao<Vocabulary> dao,String [] datas) throws ClassNotFoundException, SQLException {
		Vocabulary m=new Vocabulary();
		m.setEn_word(datas[0]);
		m.setCt_word(datas[1]);
		m.setCreate_time(new Date(new java.util.Date().getTime()));
		dao.add(m);
		return 0;
	}

	@Override
	public int execute(Dao<Vocabulary> dao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

}
