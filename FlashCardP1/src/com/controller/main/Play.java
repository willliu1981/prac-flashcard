package com.controller.main;

import java.util.Scanner;

import com.command.execute.AddCardExecute;
import com.command.execute.AddVocabularyExecute;
import com.command.execute.QueryCardExecute;
import com.command.execute.QueryVocabularyExecute;
import com.command.main.CmdBox;
import com.command.process.AddProcess;
import com.command.process.ChangeTableProcess;
import com.command.process.QueryProcess;
import com.controller.dao.Dao;
import com.controller.dao.DaoFactory;

public class Play {
	private static String help = "[query] [table id]";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(help);
		
		CmdBox cmdBox=new CmdBox();
		Scanner sc = new Scanner(System.in);
		CmdBox.addProcess(new QueryProcess(cmdBox,new QueryVocabularyExecute(),new QueryCardExecute()));
		CmdBox.addProcess(new AddProcess(cmdBox,new AddVocabularyExecute(),new AddCardExecute()));
		CmdBox.addProcess(new ChangeTableProcess(cmdBox));
		Dao<?> dao = (Dao<?>) DaoFactory.getDao(App.getDaoSimpleName("vocabulary"));
		cmdBox.setDao(dao);

		System.out.println("請輸入代碼:");
		while (sc.hasNextLine()) {
			String userIn = sc.nextLine();
			CmdBox.executeCmd(userIn);
			System.out.println("請輸入代碼:");
		}

	}

}
