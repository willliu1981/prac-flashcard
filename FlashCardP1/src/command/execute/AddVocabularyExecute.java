package command.execute;

import java.sql.SQLException;

import controller.dao.Dao;

public class AddVocabularyExecute extends Execute implements ModelExecute {
	


	@Override
	public int execute(Dao<?> dao,String [] datas) throws ClassNotFoundException, SQLException {
		
		dao.add(null);
		return 0;
	}

	@Override
	public int execute(Dao<?> dao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getModelName() {
		// TODO Auto-generated method stub
		return null;
	}

}
