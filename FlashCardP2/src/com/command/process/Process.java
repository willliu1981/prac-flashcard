package com.command.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.command.execute.Execute;

public abstract class Process {

	protected String argument;
	protected ProcessFactory processFactory;
	protected Execute[] executes;
	public static final int MORE = 1;
	public static final int EQUAL = 0;
	public static final int LESS = -1;

	protected Process() {
	}

	public void setParameters(String argument, ProcessFactory pFactory, Execute<?>... executes) {
		this.argument = argument;
		this.processFactory = pFactory;
		this.executes = executes;
	}

	protected abstract int filter(String argument, String[] params);

	// CmdBox 執行 Process list 的入口
	public int execute(String userIn) {
		int execResult = 0;
		String[] userIns = userIn.split(" ");
		List<String> list = new ArrayList<>(Arrays.asList(userIns));
		String argument = list.remove(0);
		String[] params = new String[list.size()];
		params = list.toArray(params);
		// 以上為從使用者輸入指令取得argument 指令和parameter 參數

		// 從實作filter後取得 通過的access代碼
		// 目前兩者(DataProcess 和MenuProcess)完全一樣,
		// 但在之前版本Process實作的方式不同,是有一些不一樣的邏輯運算
		// 目前暫時保留用法
		int access = (!argument.equals("")) ? filter(argument, params) : 0;
		Execute currExecute = null;
		if (access != 0) {
			currExecute = this.setCurrentExecute();
		} else {
			return execResult;// 目前意義同 access 值(為0),暫時保留用法
		}
		// 取得錯誤說明
		if (access == -1) {
			String tip = setErrorTip();
			// 覆寫錯誤回應訊息
			if (currExecute != null) {
				tip = currExecute.getTip();
			}
			System.out.println("指令錯誤: " + tip);
		}
		return execute(currExecute, params, access);
	}

	protected abstract int execute(Execute currExecute, String[] params, int access);

	// 於舊版本,暫時保留用法
	protected String getArgumentType() {
		return null;
	}

	protected abstract Execute<?> setCurrentExecute();

	// 預設錯誤回應的訊息
	protected String setErrorTip() {
		return "未知";
	}

	// 自訂驗證規則
	protected static class PredicateParameter {
		private int access;
		private final int defaultAccess;

		protected PredicateParameter() {
			this.defaultAccess = -1;// 預設為-1
		}

		protected PredicateParameter(int defaultAccess) {
			this.defaultAccess = defaultAccess;// 指定預設值
		}

		/*
		 * 自訂規則,參數 parameters 是傳入的使用者parameters condition 是比較子 , 值域 -1~1 compareTo 比較的對象
		 * access 比較成立時則設置為 access
		 *///
		protected PredicateParameter predicate(String[] parameters, int condition, int compareTo, int access) {
			switch (condition) {
			case MORE:
				if (parameters.length > compareTo) {
					this.access = access;
				}
				break;
			case EQUAL:
				if (parameters.length == compareTo) {
					this.access = access;
				}
				break;
			case LESS:
				if (parameters.length < compareTo) {
					this.access = access;
				}
				break;
			default:
				this.access = defaultAccess;
				break;
			}
			return this;
		}

		protected int getResult() {
			return this.access;
		}

	}
}
