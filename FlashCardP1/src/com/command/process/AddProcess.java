package com.command.process;

import java.sql.SQLException;

import com.command.execute.Execute;
import com.command.execute.IModelExecute;
import com.command.main.CmdBox;
import com.controller.dao.Dao;

public abstract class AddProcess extends Process {
	public AddProcess(CmdBox cmdBox,Execute... executes) {
		super(cmdBox,executes);
		// TODO Auto-generated constructor stub
	}

	protected AddProcess(ProcessFactory pFactory, Execute... executes) {
		super(pFactory, executes);
		// TODO Auto-generated constructor stub
	}

}
