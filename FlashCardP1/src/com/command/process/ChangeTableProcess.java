package com.command.process;

import java.sql.SQLException;

import com.command.execute.ModelExecute;
import com.command.main.CmdBox;
import com.controller.dao.Dao;
import com.controller.dao.DaoFactory;
import com.controller.main.App;

public class ChangeTableProcess extends Process {
	public ChangeTableProcess(CmdBox cmdBox) {
		super(cmdBox);
		// TODO Auto-generated constructor stub
	}

	private static final String argument = "table";

	@Override
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (!(argument == "")) {
			if (this.argument.equalsIgnoreCase(argument)) {
				this.setCurrentExecute();
				if (params.length == 1) {
					access = 1;
				} else {
					System.out.println("指令錯誤: " + this.currentExecute.getTip());
				}
			}
		}
		return access;
	}

	@Override
	public String getArgument() {
		// TODO Auto-generated method stub
		return this.argument;
	}

	@Override
	public void setCurrentExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public int execute(String[] params, int access) {
		if (access == 1) {
			this.cmdBox.setDao(DaoFactory.getDao(params[0].toLowerCase()));
			System.out.println("table 切換為 " + App.getDaoSimpleName(params[0].toLowerCase()));
		}
		return access;
	}

}
