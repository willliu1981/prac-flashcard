package command;

import java.util.ArrayList;
import java.util.List;

public class CmdBox {
	private static List<Process> list = new ArrayList<>();

	public static void addProcess(Process process) {
		list.add(process);
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
				if (p.getFormat().equalsIgnoreCase(userIns[0])) {
					process = p;
					break;
				}
			}
			
			if (process != null && process.predicate(userIns)) {
				process.execute();
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
