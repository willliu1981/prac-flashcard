package com.command.deprecate.deprecate1;

public class AddPredicate extends CommandPredicate {

	public AddPredicate(String[] params) {
		super(params);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean getPredicate() {
		// TODO Auto-generated method stub
		return this.parameters.length >= 3 && (this.parameters[1] != null || this.parameters[1].trim() != "")
				&& (this.parameters[2] != null || this.parameters[2].trim() != "");
	}

}
