package com.command.process;

import com.command.execute.Execute;
import com.command.main.CmdBox;
import com.controller.dao.DaoFactory;
import com.controller.main.App;

public abstract class ChangeTableProcess extends Process {
	public ChangeTableProcess(CmdBox cmdBox) {
		super(cmdBox);
		// TODO Auto-generated constructor stub
	}


	public ChangeTableProcess(ProcessFactory pFactory, Execute... executes) {
		super(pFactory, executes);
		// TODO Auto-generated constructor stub
	}



}
