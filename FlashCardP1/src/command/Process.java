package command;

public abstract class Process {

	protected String format;
	protected String[] userIn;
	
	protected Process(String format) {
		this.format=format;
	}
	
	public  boolean predicate(String[] userIn) {
		this.userIn=userIn;
		return false;
	}

	public abstract void execute();
	
	public String getFormat() {
		return format;
	}
}
