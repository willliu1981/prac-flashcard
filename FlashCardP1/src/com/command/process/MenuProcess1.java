package com.command.process;

import com.command.execute.Execute;
import com.command.execute.IModelExecute;

//處理主選單的Process
public class MenuProcess1 extends MenuProcess {

	public MenuProcess1() {
		super();
	}

	@Override
	public Execute setCurrentExecute() {
		return null;
	}

	@Override
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (this.argument.equalsIgnoreCase(argument)) {
			if (params.length == 0) {
				access = 1;
			} else {
				access = -1;
			}
		}
		return access;
	}

	@Override
	public int execute(Execute currExecute, String[] params, int access) {
		if (access == 1) {
			switch (this.argument) {
			case Exit:
				System.out.println("掰掰");
				System.exit(0);
				break;
			case Help:
				System.out.println("[query|query id] [add v1 v2] [table name]");
				break;
			}
		}
		return access;
	}

}
