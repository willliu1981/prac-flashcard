package com.command.execute;

import java.sql.Date;
import java.sql.SQLException;

import com.controller.dao.Dao;
import com.controller.dao.Dao;
import com.controller.main.App;
import com.model.main.Vocabulary;

public class AddVocabularyExecute extends Execute<Vocabulary> implements IModelExecute {
	private static final String modelName = App.getDaoSimpleName("vocabulary");

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

	@Override
	public int execute(Dao dao, int access, String[] datas) throws ClassNotFoundException, SQLException {
		if (access == 1) {
			Vocabulary m = new Vocabulary();
			m.setEn_word(datas[0]);
			m.setCt_word(datas[1]);
			((Dao) dao).add(m);
		}
		return 0;
	}

	@Override
	public int execute(int accessCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int execute(int accessCode, String[] datas) {
		// TODO Auto-generated method stub
		return 0;
	}

}
