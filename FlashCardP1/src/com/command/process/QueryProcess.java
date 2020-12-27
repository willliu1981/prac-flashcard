package com.command.process;

import java.sql.SQLException;
import java.util.List;

import com.command.execute.Execute;
import com.command.execute.ModelExecute;
import com.command.main.CmdBox;
import com.controller.dao.Dao;
import com.model.main.Card;
import com.model.main.Vocabulary;

public class QueryProcess extends Process {
	public QueryProcess(CmdBox cmdBox,Execute... executes) {
		super(cmdBox,executes);
		// TODO Auto-generated constructor stub
	}

	private static final String argument = "query";

	@Override
	public void setCurrentExecute() {
		for (Execute execute : executes) {
			if (((ModelExecute) execute).getModelName().equalsIgnoreCase(this.cmdBox.getDao().getType())) {
				this.currentExecute = execute;
			}
		}
	}

	@Override
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (!(argument == "")) {
			if (this.argument.equalsIgnoreCase(argument)) {
				this.setCurrentExecute();
				if (params.length == 0) {
					access = 1;
				} else if (params.length == 1) {
					access = 2;
				} else {
					System.out.println("指令錯誤: "+this.currentExecute.getTip());
				}
			}
		}
		return access;
	}

	@Override
	public int execute(String[] params,int access) {
		
		try {
			if(access==1) {
				this.currentExecute.execute((Dao) this.cmdBox.getDao());
			}else if(access==2) {
				this.currentExecute.execute((Dao) this.cmdBox.getDao(),params);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access;
	}

	@Override
	public String getArgument() {
		// TODO Auto-generated method stub
		return argument;
	}

}
