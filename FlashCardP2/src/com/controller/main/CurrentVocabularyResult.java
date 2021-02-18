package com.controller.main;

import java.util.List;

import com.model.main.Vocabulary;

public class CurrentVocabularyResult extends CurrentResult<Vocabulary> {

	@Override
	public void setResult(List<Vocabulary> currentResult) {
		this.currentResult=currentResult;
		
	}

	@Override
	public List<Vocabulary> getResult() {
		return this.currentResult;
	}

}
