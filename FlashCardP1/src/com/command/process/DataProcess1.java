package com.command.process;

import java.sql.SQLException;

import com.command.execute.Execute;
import com.command.execute.IModelExecute;
import com.command.process.deprecate.QueryProcess;
import com.controller.dao.DaoFactory;
import com.controller.dao.Dao;
import com.controller.main.App;

//處理CRUD的Process
public class DataProcess1 extends DataProcess {

	public DataProcess1() {
		super();
	}
	
	@Override
	public Execute setCurrentExecute() {
		// 取得對應Model的Execute實體
		for (Execute execute : this.executes) {
			if (((IModelExecute) execute).getModelName()
					.equalsIgnoreCase(((Dao) this.processFactory.getDao()).getType())) {
				return execute;
			}
		}
		return null;
	}

	// 實作filter 規則
	@Override
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (this.argument.equalsIgnoreCase(argument)) {
			//以下使用自訂比較規則 ,實作於 Process 的內部類 PredicateParameter
			switch (this.argument.toLowerCase()) {
			case Query:
				access = new PredicateParameter().predicate(params, EQUAL, 0, 1).predicate(params, EQUAL, 1, 2)
						.getResult();
				break;
			case Add:
				access = new PredicateParameter().predicate(params, EQUAL, 2, 1).getResult();
				break;
			case Table:
				access = new PredicateParameter().predicate(params, EQUAL, 1, 1).getResult();
				break;
			default:
				access = -1;
				break;
			}
		}
		return access;
	}

	@Override
	public int execute(Execute currExecute, String[] params, int access) {
		try {

			switch (this.argument.toLowerCase()) {
			case Query:
			case Add:
				if (currExecute != null) {
					// 執行對應的Execute類的 execute
					((IModelExecute<?>) currExecute).execute(ProcessFactory.getDao(), access, params);
				}
				break;
			case Table:
				if (access == 1) {
					this.processFactory.setDao(DaoFactory.getDao(params[0].toLowerCase()));
					System.out.println("table 切換為 " + App.getDaoSimpleName(params[0].toLowerCase()));
				}
				break;
			default:
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return access;
	}

}
