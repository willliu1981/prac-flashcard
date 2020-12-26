package com.command.main;

import java.util.ArrayList;
import java.util.List;

import com.command.process.Process;
import com.controller.dao.Dao;

public class CmdBox {
	
	private static List<Process> list = new ArrayList<>();

	public static void addProcess(Process process) {
		list.add(process);
	}
	
	public static  void setDao(Dao<?> dao) {
		list.forEach(p->p.setDao(dao));
	}

	public static boolean executeCmd(String userIn) {
		String userIns[] = userIn.split(" ");
		for (int i = 0; i < userIns.length; i++) {
			userIns[i] = userIns[i].trim();
		}
		boolean boolResult = false;
		if (userIns[0] != "") {
			Process process = null;
			for (Process p : list) {
				if (p.getArgument().equalsIgnoreCase(userIns[0])) {
					process = p;
					break;
				}
			}

			if (process != null && process.filter(userIns)) {
				int result = process.execute();
				switch (result) {
				case 0:
					break;
				case 1:
					CmdBox.setDao(process.getDao());
					break;
				default:
					break;
				}
				boolResult = true;
			} else {
				boolResult = false;
			}
		} else {
			boolResult = false;
		}
		return boolResult;
	}

}
