package command.execute;

import java.sql.SQLException;

import controller.App;
import controller.dao.Dao;

public class QueryCardExecute extends Execute implements ModelExecute {
	private static final String modelName=App.getDaoSimpleName("card");
	@Override
	public int execute(Dao<?> dao) throws ClassNotFoundException, SQLException {
		dao.queryall().forEach(c-> System.out.println("%card% "+c));
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
