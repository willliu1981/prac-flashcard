package command;

import controller.App;
import controller.dao.Dao;
import controller.dao.DaoFactory;

public class ChangeTableProcess extends Process {
	private Dao<?> dao;

	public ChangeTableProcess( Dao<?> dao) {
		this.dao=dao;
	}

	public Dao<?> getDao() {
		return this.dao;
	}

	@Override
	public boolean predicate(String[] userIn) {
		super.predicate(userIn);

		return true;
	}

	@Override
	public void execute() {
		this.dao = DaoFactory.getDao( this.userIn[1].toLowerCase());
		System.out.println("table 切換為 " + App.getDaoSimpleName( this.userIn[1].toLowerCase()));
	}

	@Override
	public String getFormat() {
		// TODO Auto-generated method stub
		return "table";
	}

}
