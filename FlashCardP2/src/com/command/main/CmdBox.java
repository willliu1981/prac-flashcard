package com.command.main;

import java.util.ArrayList;
import java.util.List;

import com.command.process.Process;
import com.command.process.ProcessFactory;
import com.controller.dao.Dao;

public class CmdBox {
	private Dao dao;

	private static List<Process> processList = new ArrayList<>();

	public static void addProcess(Process process) {
		processList.add(process);
	}

	public static void addProcess(ProcessFactory processFactory) {
		processList.add(processFactory.getProcess());
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public static boolean executeCmd(String userIn) {
		boolean boolResult = false;
		for (Process p : processList) {
			int result = p.execute(userIn);
			// result是實作Process的execute(String)的結果回傳值
			// 亦經由Process的 filter 處理後的access 值
			// 非零表示有結果,包含-1為指令錯誤
			// 有結果即離開此次輸入的指令
			if (result != 0) {
				break;
			}
		}

		return boolResult;
	}

}
