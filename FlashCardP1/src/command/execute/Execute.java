package command.execute;

import java.sql.SQLException;

import controller.dao.Dao;

public abstract class Execute{

	public abstract int execute(Dao<?> dao) throws ClassNotFoundException, SQLException;
	public abstract int execute(Dao<?> dao, String[] datas) throws ClassNotFoundException, SQLException;

}
