package com.command.process;

import java.sql.SQLException;

import com.command.execute.Execute;
import com.command.execute.IModelExecute;
import com.command.process.deprecate.QueryProcess;

//處理CRUD的Process
public class DataProcess1 extends QueryProcess {

	public DataProcess1() {
		super();
	}

	@Override
	public Execute setCurrentExecute() {
		//取得對應Model的Execute實體
		for (Execute execute : this.executes) {
			if (((IModelExecute) execute).getModelName().equalsIgnoreCase(this.processFactory.getDao().getType())) {
				return execute;
			}
		}
		return null;
	}

	//實作filter 規則
	@Override 
	protected int filter(String argument, String[] params) {
		int access = 0;
		if (this.argument.equalsIgnoreCase(argument)) {
			if (params.length == 0) {
				//通用無參數,如query 即為 query 全部資料 ,但在add 時會出錯
				//舊版本時 query 和 add 規則是分開實作, 暫時保留,待修改
				access = 1;
			} else if (params.length == 1) {
				access = 2;//query 時, 用於 query id
			} else if (params.length > 1) {
				access = 3;//add 時, 新增資料
			} else {
				access = -1;//指令錯誤時, 目前此邏輯有誤,待修改
			}
		}
		return access;
	}

	@Override
	public int execute(Execute currExecute, String[] params, int access) {
		try {
			//執行對應的Execute類的 execute
			((IModelExecute<?>) currExecute).execute(ProcessFactory.getDao(), access, params);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return access;
	}




}
