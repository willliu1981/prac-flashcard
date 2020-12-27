package com.command.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.command.execute.Execute;
import com.command.main.CmdBox;

public abstract class Process {

	protected CmdBox cmdBox;
	protected ProcessFactory processFactory;
	protected Execute[] executes;
	protected Execute currentExecute;

	protected Process(ProcessFactory pFactory,Execute... executes) {
		this.processFactory=pFactory;
		this.executes = executes;
	}
	protected Process(ProcessFactory pFactory) {
		this(pFactory,null);
	}
	
	protected Process(CmdBox cmdBox,Execute... executes) {
		this.cmdBox=cmdBox;
		this.executes = executes;
	}
	protected Process(CmdBox cmdBox) {
		this(cmdBox,null);
	}
	
	protected Process() {}

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
