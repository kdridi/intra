package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class CourseACLIntraURLBuilder extends IntraURLBuilder {
	private static final String PATH = "/course/filter";

	private CourseACLIntraURLBuilder(String scolarYear, String code, String codeInstance) {
		super(String.format("/module/%s/%s/%s/acl", scolarYear, code, codeInstance), true);
	}

	@Override
	protected void build(Parameters parameters) {
	}

	public static CourseACLIntraURLBuilder newBuilder(String scolarYear, String code, String codeInstance) {
		final CourseACLIntraURLBuilder builder = new CourseACLIntraURLBuilder(scolarYear, code, codeInstance);
		return builder;
	}

}
