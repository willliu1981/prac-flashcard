package com.command.process;

import java.sql.SQLException;
import java.util.List;

import com.command.execute.Execute;
import com.command.execute.ModelExecute;
import com.controller.dao.Dao;
import com.model.main.Card;
import com.model.main.Vocabulary;

public class AddProcess extends Process {
	private static final String argument = "add";

	public AddProcess(ModelExecute... executes) {
		super(executes);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean filter(String[] userIn) {
		super.filter(userIn);

		return true;
	}
	
	public int execute() {
		try {
			for (ModelExecute pe : executes) {
				if (pe.getModelName().equalsIgnoreCase(this.dao.getType())) {
					((Execute) pe).execute(this.dao,this.userIn);
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String getArgument() {
		// TODO Auto-generated method stub
		return argument;
	}

}