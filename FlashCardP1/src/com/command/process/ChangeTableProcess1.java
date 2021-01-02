package com.command.process;

import com.command.execute.Execute;
import com.command.main.CmdBox;
import com.controller.dao.DaoFactory;
import com.controller.main.App;

public class ChangeTableProcess1 extends ChangeTableProcess {

	public ChangeTableProcess1(ProcessFactory pFactory, Execute... es) {
		super(pFactory);
		// TODO Auto-generated constructor stub
	}

	private static final String argument = "table";

	@Override
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (this.argument.equalsIgnoreCase(argument)) {
			if (params.length == 1) {
				access = 1;
			} else {
				access = -1;
			}
		}
		return access;
	}

	@Override
	public String getArgumentType() {
		// TODO Auto-generated method stub
		return this.argument;
	}

	@Override
	public int execute(Execute currExecute, String[] params, int access) {
		if (access == 1) {
			this.processFactory.setDao(DaoFactory.getDao(params[0].toLowerCase()));
			System.out.println("table 切換為 " + App.getDaoSimpleName(params[0].toLowerCase()));
		}
		return access;
	}

	@Override
	protected Execute<?> setCurrentExecute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String setErrorTip() {
		// TODO Auto-generated method stub
		return "找不到 table 名稱";
	}

}
