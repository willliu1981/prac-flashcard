package com.command.process;

import java.sql.SQLException;

import com.command.execute.ModelExecute;
import com.controller.dao.Dao;
import com.controller.dao.DaoFactory;
import com.controller.main.App;

public class ChangeTableProcess extends Process {


	@Override
	public boolean filter(String[] userIn) {
		super.filter(userIn);

		return true;
	}

	@Override
	public int execute() {
		this.dao = DaoFactory.getDao(this.userIn[1].toLowerCase());
		System.out.println("table 切換為 " + App.getDaoSimpleName(this.userIn[1].toLowerCase()));
		return 1;
	}

	@Override
	public String getArgument() {
		// TODO Auto-generated method stub
		return "table";
	}

}
