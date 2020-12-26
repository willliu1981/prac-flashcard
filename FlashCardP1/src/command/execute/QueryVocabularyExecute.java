package command.execute;

import java.sql.SQLException;

import controller.App;
import controller.dao.Dao;

public class QueryVocabularyExecute extends Execute implements ModelExecute {
	private static final String modelName=App.getDaoSimpleName("vocabulary");
	@Override
	public int execute(Dao<?> dao) throws ClassNotFoundException, SQLException {
		dao.queryall().forEach(System.out::println);
		return 0;
	}

	@Override
	public int execute(Dao<?> dao,String [] datas) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public  String getModelname() {
		return modelName;
	}

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}
	
	

}
