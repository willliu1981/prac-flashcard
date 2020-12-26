package com.command.execute;

import java.sql.SQLException;

import com.controller.dao.Dao;
import com.controller.main.App;
import com.model.main.Vocabulary;

public class QueryVocabularyExecute extends Execute<Vocabulary> implements ModelExecute {
	private static final String modelName=App.getDaoSimpleName("vocabulary");
	@Override
	public int execute(Dao<Vocabulary> dao) throws ClassNotFoundException, SQLException {
		dao.queryall().forEach(System.out::println);
		return 0;
	}

	@Override
	public int execute(Dao<Vocabulary> dao,String [] datas) throws ClassNotFoundException, SQLException {
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