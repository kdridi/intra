package eu.epitech.intra.commons;

public enum IntraLocation {

	// @formatter:off
	FRANCE("FR"),
	FRANCE_PARIS("FR/PAR");
	// @formatter:on

	private String name;

	IntraLocation(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}