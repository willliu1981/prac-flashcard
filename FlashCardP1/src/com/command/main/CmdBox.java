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

	public static void setDao(Dao<?> dao) {
		list.forEach(p -> p.setDao(dao));
	}

	public static boolean executeCmd(String userIn) {
		boolean boolResult = false;
		for (Process p : list) {

			int result = p.execute(userIn);
			switch (result) {
			case 0:
				break;
			case 1:
				CmdBox.setDao(p.getDao());
				break;
			default:
				break;
			}

			boolResult = true;
			break;

		}

		return boolResult;
	}

}
