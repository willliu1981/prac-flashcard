package com.command.process;

import java.sql.SQLException;

import com.command.execute.Execute;
import com.command.execute.IModelExecute;
import com.command.main.CmdBox;
import com.controller.dao.Dao;

public abstract class QueryProcess extends Process {
	public QueryProcess(CmdBox cmdBox,Execute<?>... executes) {
		super(cmdBox,executes);
		// TODO Auto-generated constructor stub
	}
	
	protected QueryProcess(ProcessFactory pFactory, Execute<?>[] executes) {
		super(pFactory,executes);
	}
	
	public QueryProcess() {
		super();
	}


}
