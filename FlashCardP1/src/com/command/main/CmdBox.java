package com.command.main;

import java.util.ArrayList;
import java.util.List;

import com.command.process.Process;
import com.controller.dao.Dao;

public class CmdBox {
	private Dao dao;

	private static List<Process> list = new ArrayList<>();

	public static void addProcess(Process process) {
		list.add(process);
	}

	public Dao getDao() {
		return this.dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public static boolean executeCmd(String userIn) {
		boolean boolResult = false;
		for (Process p : list) {
			int result = p.execute(userIn);
			if (result != 0) {
				break;
			}
		}

		return boolResult;
	}

}
