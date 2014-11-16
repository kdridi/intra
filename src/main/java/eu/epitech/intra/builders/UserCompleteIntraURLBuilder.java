package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class UserCompleteIntraURLBuilder extends IntraURLBuilder {
	private static final String PARAM_SEARCH = "search";

	private static final String PATH = "/user/complete";

	private String search;

	public UserCompleteIntraURLBuilder setSearch(String search) {
		this.search = search;
		return this;
	}

	private UserCompleteIntraURLBuilder() {
		super(PATH);
	}

	@Override
	protected void build(Parameters parameters) {
		parameters.add(PARAM_SEARCH, search);
	}

	public static final UserCompleteIntraURLBuilder newBuilder(String search) {
		return new UserCompleteIntraURLBuilder().setSearch(search);
	}

	public static final UserCompleteIntraURLBuilder newBuilder() {
		return newBuilder("");
	}
}
