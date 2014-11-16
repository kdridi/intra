package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class UserNotificationMissedIntraURLBuilder extends IntraURLBuilder {

	private UserNotificationMissedIntraURLBuilder(String user) {
		super("/user/" + user + "/notification/missed/", true);
	}

	@Override
	protected void build(Parameters parameters) {
	}

	public static final UserNotificationMissedIntraURLBuilder newBuilder(String user) {
		return new UserNotificationMissedIntraURLBuilder(user);
	}

}
