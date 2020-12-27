package com.command.deprecate.deprecate1;

public class UpdatePredicate extends CommandPredicate {

	public UpdatePredicate(String[] params) {
		super(params);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean getPredicate() {
		return this.parameters.length >= 4 && (this.parameters[1] != null || this.parameters[1].trim() != "")
				&& (this.parameters[2] != null || this.parameters[2].trim() != "")
				&& (this.parameters[3] != null || this.parameters[3].trim() != "");
	}

}
