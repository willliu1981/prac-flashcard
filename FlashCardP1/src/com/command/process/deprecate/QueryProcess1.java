package com.command.process.deprecate;

import java.sql.SQLException;

import com.command.execute.Execute;
import com.command.execute.IModelExecute;
import com.command.main.CmdBox;
import com.command.process.ProcessFactory;
import com.controller.dao.Dao;
import com.controller.dao.Dao;

public class QueryProcess1 extends QueryProcess {

	public QueryProcess1(ProcessFactory pFactory, Execute<?>... executes) {
		super(pFactory, executes);
	}

	public QueryProcess1() {
		super();
	}

	private static final String argument = "query";

	@Override
	public Execute setCurrentExecute() {
		for (Execute execute : this.executes) {
			if (((IModelExecute) execute).getModelName().equalsIgnoreCase(((Dao)this.processFactory.getDao()).getType())) {
				return execute;
			}
		}
		return null;
	}

	@Override
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (this.argument.equalsIgnoreCase(argument)) {
			if (params.length == 0) {
				access = 1;
			} else if (params.length == 1) {
				access = 2;
			} else {
				access = -1;
			}
		}
		return access;
	}

	@Override
	public int execute(Execute currExecute, String[] params, int access) {
		try {
			((IModelExecute<?>) currExecute).execute(ProcessFactory.getDao(), access, params);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access;
	}

	@Override
	public String getArgumentType() {
		// TODO Auto-generated method stub
		return argument;
	}

	@Override
	protected String setErrorTip() {
		// TODO Auto-generated method stub
		return null;
	}

}
