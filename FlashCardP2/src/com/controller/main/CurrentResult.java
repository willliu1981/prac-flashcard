package com.controller.main;

import java.util.List;

import com.model.main.Vocabulary;

public abstract class CurrentResult<T> {
	protected  List<T> currentResult;
	public abstract void setResult(List<T> currentResult) ;
	public abstract List<T> getResult();
}
