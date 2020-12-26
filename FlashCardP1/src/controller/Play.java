package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.google.gson.Gson;

import command.deprecate.deprecate.AddPredicate;
import command.deprecate.deprecate.CommandPredicate;
import command.deprecate.deprecate.QueryPredicate;
import command.deprecate.deprecate.UpdatePredicate;
import command.execute.QueryCardExecute;
import command.execute.QueryVocabularyExecute;
import command.main.CmdBox;
import command.process.ChangeTableProcess;
import command.process.QueryProcess;
import controller.dao.Dao;
import controller.dao.DaoFactory;
import controller.dao.VocabularyDao;
import model.Vocabulary;

public class Play {
	private static String help = "[query] [table id]";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(help);

		Scanner sc = new Scanner(System.in);
		CmdBox.addProcess(new QueryProcess(new QueryVocabularyExecute(),new QueryCardExecute()));
		CmdBox.addProcess(new ChangeTableProcess());
		Dao<?> dao = (Dao<?>) DaoFactory.getDao(App.getDaoSimpleName("vocabulary"));
		CmdBox.setDao(dao);

		System.out.println("請輸入代碼:");
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			CmdBox.executeCmd(line);
			System.out.println("請輸入代碼:");
		}

	}

}
