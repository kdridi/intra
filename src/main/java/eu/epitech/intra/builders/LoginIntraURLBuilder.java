package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class LoginIntraURLBuilder extends IntraURLBuilder {
	private static final String PATH = "/";

	private LoginIntraURLBuilder() {
		super(PATH);
	}

	@Override
	protected void build(Parameters parameters) {
	}

	public static LoginIntraURLBuilder newBuilder() {
		final LoginIntraURLBuilder builder = new LoginIntraURLBuilder();
		return builder;
	}

}
