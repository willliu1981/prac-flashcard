package command.deprecate.deprecate;

public class QueryPredicate extends CommandPredicate {

	public QueryPredicate(String[] params) {
		super(params);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean getPredicate() {
		return this.parameters.length > 1 && (this.parameters[1] != null || this.parameters[1].trim() != "");
	}

}
