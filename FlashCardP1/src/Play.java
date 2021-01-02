
import java.util.Scanner;

import com.command.execute.AddCardExecute;
import com.command.execute.AddVocabularyExecute;
import com.command.execute.QueryCardExecute;
import com.command.execute.QueryVocabularyExecute;
import com.command.main.CmdBox;
import com.command.process.MenuProcess;
import com.command.process.ProcessFactory;
import com.controller.dao.DaoFactory;
import com.controller.main.App;

public class Play {

	public static void main(String[] args) {
		App.LoadConfig("resource\\config\\config.cfg");

		Scanner sc = new Scanner(System.in);
		ProcessFactory.setDao(DaoFactory.getDao("vocabulary"));//預設Dao
		//設置指令
		ProcessFactory exitFactory = ProcessFactory.getFactory("menu", MenuProcess.Exit);
		ProcessFactory testexitFactory = ProcessFactory.getFactory("menu", MenuProcess.Help);
		ProcessFactory queryFactory = ProcessFactory.getFactory("data", "query", new QueryVocabularyExecute(),
				new QueryCardExecute());
		ProcessFactory addFactory = ProcessFactory.getFactory("data", "add", new AddVocabularyExecute(),
				new AddCardExecute());
		ProcessFactory tableFactory = ProcessFactory.getFactory("data", "table");

		CmdBox.addProcess(queryFactory);
		CmdBox.addProcess(addFactory);
		CmdBox.addProcess(tableFactory);
		CmdBox.addProcess(exitFactory);
		CmdBox.addProcess(testexitFactory);

		//程式開始
		System.out.println("請輸入代碼: (輸入help取得說明)");
		while (sc.hasNextLine()) {
			String userIn = sc.nextLine();
			CmdBox.executeCmd(userIn);
			System.out.println("請輸入代碼:");
		}

	}

}
