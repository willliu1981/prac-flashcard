package command;

public abstract class CommandPredicate {
	protected String[] parameters;
	
	public CommandPredicate(String[] params) {
		this.parameters=params;
	}
	
	public static boolean predicate(CommandPredicate comm) {
		return comm.getPredicate();
	}
	
	
	protected abstract boolean getPredicate();
}
