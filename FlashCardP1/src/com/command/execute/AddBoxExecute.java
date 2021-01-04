package com.command.execute;

import java.sql.Date;
import java.sql.SQLException;

import com.controller.dao.Dao;
import com.controller.dao.Dao;
import com.controller.main.App;
import com.model.main.Box;
import com.model.main.Card;
import com.model.main.Vocabulary;

public class AddBoxExecute extends Execute<Box> implements IModelExecute {
	private static final String modelName = App.getDaoSimpleName("box");

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

	@Override
	public int execute(Dao dao, int access, String[] datas) throws ClassNotFoundException, SQLException {
		Box m = new Box();
		m.setName(datas[0]);
		m.setDescribe(datas[1]);
		((Dao) dao).add(m);
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
