package command;

import java.util.ArrayList;
import java.util.List;

public class CmdBox {
	private static List<Process> list = new ArrayList<>();

	private String userIn;

	public static void addProcess(Process process) {
		list.add(process);
	}

	public static boolean executeCmd(String cmd) {
		String cmds[] = cmd.split(" ");
		for(int i=0;i<cmds.length;i++) {
			cmds[i]=cmds[i].trim();
		}
		boolean boolResult=false;
		if (cmds[0] != "") {
			Process process = null;
			for (Process p : list) {
				if (p.getFormat().equalsIgnoreCase(cmds[0])) {
					process = p;
					break;
				}
			}
			boolean access = process.predicate(cmds);
			if(access) {
				process.execute();
				boolResult= true;
			}else {
				boolResult= false;
			}
		}else {
			boolResult= false;
		}
		return boolResult;
	}

}
