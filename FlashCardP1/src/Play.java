
import java.util.Scanner;

import com.command.execute.AddCardExecute;
import com.command.execute.AddVocabularyExecute;
import com.command.execute.QueryCardExecute;
import com.command.execute.QueryVocabularyExecute;
import com.command.main.CmdBox;
import com.command.process.AddProcess;
import com.command.process.ChangeTableProcess;
import com.command.process.ProcessFactory;
import com.command.process.QueryProcess1;
import com.controller.dao.DaoFactory;
import com.command.process.Process;

public class Play {
	private static String help = "[query] [table id]";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(help);

		Scanner sc = new Scanner(System.in);
		ProcessFactory.setDao(DaoFactory.getDao("vocabulary"));
		ProcessFactory queryFactory = ProcessFactory.getFactory("query", new QueryVocabularyExecute(),
				new QueryCardExecute());
		ProcessFactory addFactory = ProcessFactory.getFactory("add", new AddVocabularyExecute(), new AddCardExecute());
		ProcessFactory tableFactory = ProcessFactory.getFactory("table");

		CmdBox.addProcess(queryFactory);
		CmdBox.addProcess(addFactory);
		CmdBox.addProcess(tableFactory);

		System.out.println("請輸入代碼:");
		while (sc.hasNextLine()) {
			String userIn = sc.nextLine();
			CmdBox.executeCmd(userIn);
			System.out.println("請輸入代碼:");
		}

	}

}
