package eu.epitech.intra.builders;

import eu.epitech.intra.commons.IntraURLBuilder;

public class AnnuelInstanceIntraURLBuilder extends IntraURLBuilder {
	private static final String PATH = "/annuel/instance";

	private String scolarYear;

	public AnnuelInstanceIntraURLBuilder setScolarYear(String scolarYear) {
		this.scolarYear = scolarYear;
		return this;
	}

	private String code;

	public AnnuelInstanceIntraURLBuilder setCode(String code) {
		this.code = code;
		return this;
	}

	private String instanceLocation;

	public AnnuelInstanceIntraURLBuilder setInstanceLocation(String instanceLocation) {
		this.instanceLocation = instanceLocation;
		return this;
	}

	private AnnuelInstanceIntraURLBuilder() {
		super(PATH);
	}

	@Override
	protected void build(Parameters parameters) {
		parameters.add("semester", "");
		parameters.add("city", instanceLocation);
		parameters.add("codemodule", code);
		parameters.add("year", scolarYear);
	}

	public static AnnuelInstanceIntraURLBuilder newBuilder(String scolarYear, String code, String instanceLocation) {
		final AnnuelInstanceIntraURLBuilder builder = new AnnuelInstanceIntraURLBuilder().setCode(code).setScolarYear(scolarYear).setInstanceLocation(instanceLocation);
		return builder;
	}

}
