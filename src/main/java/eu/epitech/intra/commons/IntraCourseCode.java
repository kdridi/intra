package eu.epitech.intra.commons;

public enum IntraCourseCode {

	// @formatter:off
	SAMSUNG_WAC("Samsung-WAC"),
	BACHELOR_CLASSIC("bachelor/classic"),
	BACHELOR_TEK1ED("bachelor/tek1ed"),
	BACHELOR_TEK2ED("bachelor/tek2ed"),
	BACHELOR_TEK3S("bachelor/tek3s"),
	MASTER_CLASSIC("master/classic"),
	MASTER_TEK3SI("master/tek3si"),
	WEBACADEMIE("webacademie"),
	OTHER("other");
	// @formatter:on

	private String name;

	IntraCourseCode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}