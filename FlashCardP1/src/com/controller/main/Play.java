package com.controller.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.command.deprecate.deprecate1.AddPredicate;
import com.command.deprecate.deprecate1.CommandPredicate;
import com.command.deprecate.deprecate1.QueryPredicate;
import com.command.deprecate.deprecate1.UpdatePredicate;
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
import com.controller.dao.VocabularyDao;
import com.google.gson.Gson;
import com.model.main.Vocabulary;

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
		CmdBox.setDao(dao);

		System.out.println("請輸入代碼:");
		while (sc.hasNextLine()) {
			String userIn = sc.nextLine();
			CmdBox.executeCmd(userIn);
			System.out.println("請輸入代碼:");
		}

	}

}
