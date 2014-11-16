package eu.epitech.intra.builders;

import java.util.Set;
import java.util.TreeSet;

import eu.epitech.intra.commons.IntraCourse;
import eu.epitech.intra.commons.IntraLocation;
import eu.epitech.intra.commons.IntraURLBuilder;

public class CourseFilterIntraURLBuilder extends IntraURLBuilder {
	private static final String PATH = "/course/filter";

	private Set<IntraCourse> courses = new TreeSet<>();

	public CourseFilterIntraURLBuilder addCourse(IntraCourse course) {
		courses.add(course);
		return this;
	}

	private Set<IntraLocation> locations = new TreeSet<>();

	public CourseFilterIntraURLBuilder addLocation(IntraLocation location) {
		locations.add(location);
		return this;
	}

	private Set<Integer> scolarYears = new TreeSet<>();

	public CourseFilterIntraURLBuilder addScolarYear(Integer scolarYear) {
		scolarYears.add(scolarYear);
		return this;
	}

	private CourseFilterIntraURLBuilder() {
		super(PATH);
	}

	@Override
	protected void build(Parameters parameters) {
		for (IntraLocation location : locations) {
			parameters.add("location[]", location.toString());
		}
		for (IntraCourse course : courses) {
			parameters.add("course[]", course.toString());
		}
		for (Integer scolarYear : scolarYears) {
			parameters.add("scolaryear[]", scolarYear.toString());
		}
	}

	public static CourseFilterIntraURLBuilder newBuilder() {
		final CourseFilterIntraURLBuilder builder = new CourseFilterIntraURLBuilder();
		return builder;
	}

}
