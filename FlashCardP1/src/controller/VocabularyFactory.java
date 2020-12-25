package controller;

import model.Vocabulary;

public class VocabularyFactory {
	
	public static Dao<Vocabulary> instance() {
		
		return new VocabularyDao1();
	}
}
