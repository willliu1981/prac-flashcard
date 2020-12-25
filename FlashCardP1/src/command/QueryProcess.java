package command;

import java.sql.SQLException;
import java.util.List;

import controller.App;
import controller.dao.Dao;
import model.Card;
import model.Vocabulary;

public class QueryProcess extends Process {
	private Dao dao;

	protected QueryProcess(String format, Dao dao) {
		super(format);
		this.dao = dao;
	}

	@Override
	public boolean predicate(String[] userIn) {
		super.predicate(userIn);

		return true;
	}

	@Override
	public void execute() {
		try {
			switch (this.userIn[0].toLowerCase()) {
			case "q":
				switch (dao.getType()) {
				case "Vocabulary":
					List<Vocabulary> vlst = dao.queryall();
					vlst.forEach(System.out::println);
					break;
				case "Card":
					List<Card> clst = dao.queryall();
					clst.forEach(System.out::println);
					break;
				default:
					break;
				}

				break;
			default:
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
