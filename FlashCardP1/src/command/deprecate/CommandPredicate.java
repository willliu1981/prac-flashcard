package command.deprecate;

import command.Process;

public abstract class CommandPredicate {
	protected String[] parameters;
	
	public CommandPredicate(String[] params) {
		this.parameters=params;
	}
	
	public static boolean predicate(CommandPredicate comm) {
		return comm.getPredicate();
	}
	
	public static void process(Process process) {
		
		
	}
	
	
	protected abstract boolean getPredicate();
}
