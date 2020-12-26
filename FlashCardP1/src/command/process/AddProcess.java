package command.process;

import java.sql.SQLException;
import java.util.List;

import command.execute.ModelExecute;
import controller.dao.Dao;
import model.Card;
import model.Vocabulary;

public class AddProcess extends Process {
	private static final String argument="add";
	private ModelExecute execute;

	public AddProcess( ModelExecute execute) {
		this.execute = execute  ;
	}

	@Override
	public boolean predicate(String[] userIn) {
		super.predicate(userIn);

		return true;
	}

	@Override
	public int execute() {
		/*
		try {
			switch (this.userIn[0].toLowerCase()) {
			case argument:
				execute.execute(dao);
				break;
			default:
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*///
		return 0;
	}

	@Override
	public String getArgument() {
		// TODO Auto-generated method stub
		return argument;
	}


}
