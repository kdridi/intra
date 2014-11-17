package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class UserNotificationMissedIntraURLBuilder extends IntraURLBuilder {
	private static final String PATH = "/user/%s/notification/missed/";

	private UserNotificationMissedIntraURLBuilder(String user) {
		super(String.format(PATH, user), true);
	}

	@Override
	protected void build(Parameters parameters) {
	}

	public static final UserNotificationMissedIntraURLBuilder newBuilder(String user) {
		return new UserNotificationMissedIntraURLBuilder(user);
	}
}
