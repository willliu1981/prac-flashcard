package com.command.process;

import java.sql.SQLException;

import com.command.execute.Execute;
import com.command.execute.ModelExecute;
import com.command.main.CmdBox;
import com.controller.dao.Dao;

public class AddProcess extends Process {
	private static final String argument = "add";

	public AddProcess(CmdBox cmdBox,Execute... executes) {
		super(cmdBox,executes);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (!(argument == "")) {
			if (this.argument.equalsIgnoreCase(argument)) {
				this.setCurrentExecute();
				if (params.length >= 1) {
					access = 1;
				} else {
					System.out.println("指令錯誤: "+this.currentExecute.getTip());
				}
			}
		}
		return access;
	}

	@Override
	public String getArgument() {
		// TODO Auto-generated method stub
		return argument;
	}

	@Override
	public void setCurrentExecute() {
		for (Execute execute : executes) {
			if (((ModelExecute) execute).getModelName().equalsIgnoreCase(this.cmdBox.getDao().getType())) {
				this.currentExecute = execute;
			}
		}
	}

	@Override
	public int execute(String[] params, int access) {
		try {
			if(access==1) {
				this.currentExecute.execute((Dao) this.cmdBox.getDao(),params);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access;
	}

}
