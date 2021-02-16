package com.command.execute;

import java.sql.SQLException;

import com.controller.dao.Dao;
import com.controller.dao.Dao;
import com.controller.main.App;
import com.model.main.Vocabulary;

public class QueryVocabularyExecute extends Execute<Vocabulary> implements IModelExecute {
	private static final String modelName = App.getDaoSimpleName("vocabulary");

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

	@Override
	public int execute(Dao dao, int access, String[] datas) throws ClassNotFoundException, SQLException {
		if (access == 1) {
			((Dao) dao).queryAll().forEach(System.out::println);
		} else if (access == 2) {
			boolean isNumber = false;
			int id = 0;
			try {
				id = Integer.valueOf(datas[0]);
				isNumber = true;
			} catch (NumberFormatException e) {
			}
			if (isNumber) {
				System.out.println(((Dao) dao).query(id));
			} else {
				// other logic
			}
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
