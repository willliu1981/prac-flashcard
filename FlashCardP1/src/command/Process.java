package command;

import controller.dao.Dao;

public abstract class Process {

	protected String[] userIn;
	protected Dao<?> dao;
	
	public  boolean predicate(String[] userIn) {
		this.userIn=userIn;
		return false;
	}
	
	public void setDao(Dao dao) {
		this.dao=dao;
	}

	public Dao<?> getDao() {
		return this.dao;
	}
	
	public abstract int execute();
	
	public abstract String getFormat() ;
}
