package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.google.gson.Gson;

import command.ChangeTableProcess;
import command.CmdBox;
import command.QueryProcess;
import command.deprecate.AddPredicate;
import command.deprecate.CommandPredicate;
import command.deprecate.QueryPredicate;
import command.deprecate.UpdatePredicate;
import controller.dao.Dao;
import controller.dao.DaoFactory;
import controller.dao.VocabularyDao;
import model.Vocabulary;

public class Play {
	private static String help = "[table id] [add en ct] [query-all|q-all|q] [query-id id|q-id id] [update id en ct] [delete id]"
			+ " [help] [exit]";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(help);

		args = new String[] { "query-all" };
		Scanner sc = new Scanner(System.in);
		Dao<?> dao=(Dao<?>)DaoFactory.getDao(App.getDaoSimpleName("vocabulary"));
		CmdBox.addProcess(new QueryProcess( ));
		CmdBox.addProcess(new ChangeTableProcess( ));
		CmdBox.setDao(dao);
		
			System.out.println("請輸入代碼:");
			while (sc.hasNextLine()) {
				String line=sc.nextLine();
				CmdBox.executeCmd(line);
				System.out.println("請輸入代碼:");
			}

		
	}
	
}
