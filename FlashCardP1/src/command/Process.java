package command;

public abstract class Process {

	protected String[] userIn;

	
	public  boolean predicate(String[] userIn) {
		this.userIn=userIn;
		return false;
	}

	public abstract void execute();
	
	public abstract String getFormat() ;
}
