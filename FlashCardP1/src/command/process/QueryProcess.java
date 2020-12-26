package command.process;

import java.sql.SQLException;
import java.util.List;

import command.execute.Execute;
import command.execute.ModelExecute;
import controller.dao.Dao;
import model.Card;
import model.Vocabulary;

public class QueryProcess extends Process {
	private static final String argument = "query";
	private ModelExecute[] executes;

	public QueryProcess(ModelExecute... executes) {
		this.executes = executes;
	}

	@Override
	public boolean predicate(String[] userIn) {
		super.predicate(userIn);

		return true;
	}

	@Override
	public int execute() {
		try {
			for (ModelExecute pe : executes) {
				if (pe.getModelName().equalsIgnoreCase(this.dao.getType())) {
					((Execute) pe).execute(this.dao);
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
