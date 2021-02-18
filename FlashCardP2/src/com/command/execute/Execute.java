package com.command.execute;

import java.util.List;

public abstract class Execute<T> {
	
	
	public abstract int execute(int accessCode);

	public abstract int execute(int accessCode, String[] datas);

	public String getTip() {
		return "未知錯誤";
	}

}
