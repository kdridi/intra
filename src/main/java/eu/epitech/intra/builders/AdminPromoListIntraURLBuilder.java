package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class AdminPromoListIntraURLBuilder extends IntraURLBuilder {
	private static final String PARAM_SCHOOL = "school";
	private static final String PARAM_SCOLARYEAR = "scolaryear";
	private static final String PARAM_COURSE = "course";
	private static final String PARAM_SEMESTER = "semester";
	private static final String PARAM_LOCATION = "location";

	private static final String PATH = "/admin/promo/list";

	private AdminPromoListIntraURLBuilder() {
		super(PATH);
	}

	@Override
	protected void build(Parameters parameters) {
		parameters.add(PARAM_SCHOOL, "epitech");
		parameters.add(PARAM_SCOLARYEAR, "2014");
		parameters.add(PARAM_COURSE, "bachelor/classic");
		parameters.add(PARAM_SEMESTER, "B1");
		parameters.add(PARAM_LOCATION, "FR/PAR");
	}

	public static final AdminPromoListIntraURLBuilder newBuilder() {
		return new AdminPromoListIntraURLBuilder();
	}

}
