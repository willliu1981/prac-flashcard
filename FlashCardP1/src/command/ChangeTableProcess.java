package command;

import controller.App;
import controller.dao.Dao;
import controller.dao.DaoFactory;

public class ChangeTableProcess extends Process {
	private Dao dao;

	protected ChangeTableProcess(String format, Dao dao) {
		super(format);
		// TODO Auto-generated constructor stub
	}

	public Dao getDao() {
		return this.dao;
	}

	@Override
	public boolean predicate(String[] userIn) {
		super.predicate(userIn);

		return true;
	}

	@Override
	public void execute() {
		String table = this.userIn[0].toLowerCase();
		this.dao = DaoFactory.getDao(App.getTable(table));
		System.out.println("table 切換為 " + table);
	}

}
