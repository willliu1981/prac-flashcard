package com.command.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.command.execute.Execute;
import com.command.main.CmdBox;

public abstract class Process {

	protected CmdBox cmdBox;
	protected ProcessFactory processFactory;
	protected Execute[] executes;

	protected Process(ProcessFactory pFactory, Execute... executes) {
		this.processFactory = pFactory;
		this.executes = executes;
	}

	protected Process(ProcessFactory pFactory) {
		this(pFactory, null);
	}

	protected Process(CmdBox cmdBox, Execute... executes) {
		this.cmdBox = cmdBox;
		this.executes = executes;
	}

	protected Process(CmdBox cmdBox) {
		this(cmdBox, null);
	}

	protected Process() {
	}

	protected abstract int filter(String argument, String[] params);

	// CmdBox 執行 Process list 的入口
	public int execute(String userIn) {
		int execResult=0;
		String[] userIns = userIn.split(" ");
		List<String> list = new ArrayList<>(Arrays.asList(userIns));
		String argument = list.remove(0);
		String[] params = new String[list.size()];
		params = list.toArray(params);
		int access = argument != "" ? filter(argument, params) : 0;
		Execute currExecute = null;
		if (access != 0) {
			currExecute = this.setCurrentExecute();
		}else {
			return execResult;
		}
		if (access == -1) {
			String tip = setErrorTip();
			if (tip == null && currExecute != null) {
				tip = currExecute.getTip();
			}
			System.out.println("指令錯誤: " + tip);
		}
		return execute(currExecute, params, access);
	}

	protected abstract int execute(Execute currExecute, String[] params, int access);

	protected abstract String getArgument();

	protected abstract Execute<?> setCurrentExecute();

	protected String setErrorTip() {
		return "";
	}
}
