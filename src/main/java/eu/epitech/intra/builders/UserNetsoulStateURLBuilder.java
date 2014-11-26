package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class UserNetsoulStateURLBuilder extends IntraURLBuilder {
	private static final String PATH = "/user/%s/netsoul/";

	private UserNetsoulStateURLBuilder(String user) {
		super(String.format(PATH, user), true);
	}

	@Override
	protected void build(Parameters parameters) {
	}

	public static final UserNetsoulStateURLBuilder newBuilder(String user) {
		return new UserNetsoulStateURLBuilder(user);
	}
}
