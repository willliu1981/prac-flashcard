package command;

import java.sql.SQLException;
import java.util.List;

import controller.dao.Dao;
import model.Card;
import model.Vocabulary;

public class QueryProcess extends Process {
	private static final String format="query";
	

//	public QueryProcess( Dao<?> dao) {
//		this.dao = dao  ;
//	}

	@Override
	public boolean predicate(String[] userIn) {
		super.predicate(userIn);

		return true;
	}

	@Override
	public int execute() {
		try {
			switch (this.userIn[0].toLowerCase()) {
			case format:
				switch (dao.getType()) {
				case "Vocabulary":
					List<Vocabulary> vlst = (List<Vocabulary>) dao.queryall();
					vlst.forEach(System.out::println);
					break;
				case "Card":
					List<Card> clst = (List<Card>) dao.queryall();
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
		return 0;
	}

	@Override
	public String getFormat() {
		// TODO Auto-generated method stub
		return format;
	}

}
