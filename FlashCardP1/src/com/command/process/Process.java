package com.command.process;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.command.execute.Execute;
import com.command.execute.ModelExecute;
import com.command.main.CmdBox;
import com.controller.dao.Dao;

public abstract class Process {

	protected CmdBox cmdBox;
	protected Execute[] executes;
	protected Execute currentExecute;

	protected Process(CmdBox cmdBox,Execute... executes) {
		this.cmdBox=cmdBox;
		this.executes = executes;
	}
	protected Process(CmdBox cmdBox) {
		this(cmdBox,null);
	}

	protected abstract int filter(String argument, String[] params);

	public int execute(String userIn) {
		String[] userIns = userIn.split(" ");
		List<String> list = new ArrayList<>(Arrays.asList(userIns));
		String argument = list.remove(0);
		String[] params = new String[list.size()];
		params =  list.toArray(params);
		return execute(params, filter(argument, params));
	}

	public abstract int execute(String[] params, int access);

	public abstract String getArgument();

	public abstract void setCurrentExecute();

	public String getTip() {
		// TODO Auto-generated method stub
		return this.currentExecute.getTip();
	}
}
