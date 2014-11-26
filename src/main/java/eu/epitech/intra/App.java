package eu.epitech.intra;

import static eu.epitech.intra.commons.IntraCourseCode.BACHELOR_CLASSIC;
import static eu.epitech.intra.commons.IntraLocation.FRANCE;
import static eu.epitech.intra.commons.IntraLocation.FRANCE_PARIS;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.sf.json.JSON;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.epitech.intra.builders.AdminPromoListIntraURLBuilder;
import eu.epitech.intra.builders.CourseACLIntraURLBuilder;
import eu.epitech.intra.builders.CourseFilterIntraURLBuilder;
import eu.epitech.intra.builders.ModuleBoardIntraURLBuilder;
import eu.epitech.intra.builders.UserCompleteIntraURLBuilder;
import eu.epitech.intra.builders.UserNetsoulStateURLBuilder;
import eu.epitech.intra.builders.UserNotificationMissedIntraURLBuilder;
import eu.epitech.intra.commons.IntraURLBuilder;
import eu.epitech.intra.commons.helpers.HttpClientHelper;
import eu.epitech.intra.domain.IntraACL;
import eu.epitech.intra.domain.IntraACLMember;
import eu.epitech.intra.domain.IntraCourse;
import eu.epitech.intra.domain.IntraUserNetsoulState;
import eu.epitech.intra.domain.IntraUserState;

public class App {
	public static void main(String[] args) throws Exception {
		{
			final CourseACLIntraURLBuilder builder = CourseACLIntraURLBuilder.newBuilder("2014", "B-ANG-050", "PAR-1-1");
			final List<IntraACL> levels = HttpClientHelper.getResponseContentWithTypeReference(builder, new TypeReference<List<IntraACL>>() {
			});
			System.out.println(levels.toString());
		}
		{
			final AdminPromoListIntraURLBuilder builder = AdminPromoListIntraURLBuilder.newBuilder();
			final List<IntraUserState> states = HttpClientHelper.getResponseContentWithTypeReference(builder, new TypeReference<List<IntraUserState>>() {
			});
			System.out.println(states.toString());
		}
		{
			final UserNetsoulStateURLBuilder builder = UserNetsoulStateURLBuilder.newBuilder("lahmi_g");
			final List<IntraUserNetsoulState> states = HttpClientHelper.getResponseContentWithTypeReference(builder, new TypeReference<List<IntraUserNetsoulState>>() {
			});
			System.out.println(states.toString());
		}
	}

	public static void main1(String[] args) throws Exception {
		boolean execute = false;
		if (execute) {
			final CourseACLIntraURLBuilder builder = CourseACLIntraURLBuilder.newBuilder("2014", "B-ANG-050", "PAR-1-1");
			final JSON json = HttpClientHelper.getJSONArray(builder);
			System.out.println(json.toString(4));
		}
		{
			final CourseFilterIntraURLBuilder builder = CourseFilterIntraURLBuilder.newBuilder();

			builder.addLocation(FRANCE);
			builder.addLocation(FRANCE_PARIS);

			// builder.addCourse(SAMSUNG_WAC);
			builder.addCourse(BACHELOR_CLASSIC);
			// builder.addCourse(BACHELOR_TEK1ED);
			// builder.addCourse(BACHELOR_TEK2ED);
			// builder.addCourse(BACHELOR_TEK3S);
			// builder.addCourse(IntraCourseCode.MASTER_CLASSIC);
			// builder.addCourse(IntraCourseCode.MASTER_TEK3SI);
			// builder.addCourse(WEBACADEMIE);
			// builder.addCourse(OTHER);

			// builder.addScolarYear(2013);
			builder.addScolarYear(2014);

			final ExecutorService service = Executors.newFixedThreadPool(10);
			final Map<IntraCourse, Future<Collection<IntraACLMember>>> futures = new HashMap<>();
			final List<IntraCourse> courses = HttpClientHelper.getResponseContentWithTypeReference(builder, new TypeReference<List<IntraCourse>>() {
			});
			int index = 0;
			for (final IntraCourse course : courses) {
				final String message = String.format("%d/%d", ++index, courses.size());
				final Future<Collection<IntraACLMember>> future = service.submit(new Callable<Collection<IntraACLMember>>() {
					@Override
					public Collection<IntraACLMember> call() throws Exception {
						final String scolarYear = course.getScolarYear().toString();
						final String code = course.getCode();
						final String codeInstance = course.getCodeInstance();

						final ThreadLocal<Collection<IntraACLMember>> result = new ThreadLocal<>();
						try {
							result.set(fetchMembers(CourseACLIntraURLBuilder.newBuilder(scolarYear, code, codeInstance)));
						} catch (Exception e) {
							final String title = course.getTitle();
							System.err.println(title);
							System.err.println(String.format("https://intra.epitech.eu/module/%s/%s/%s/#!/all", scolarYear, code, codeInstance));
						}

						// System.out.println(message);

						return result.get();
					}

					private Collection<IntraACLMember> fetchMembers(final CourseACLIntraURLBuilder builder) {
						final ThreadLocal<Collection<IntraACLMember>> result = new ThreadLocal<>();
						final List<IntraACL> acls = HttpClientHelper.getResponseContentWithTypeReference(builder, new TypeReference<List<IntraACL>>() {
						});
						for (IntraACL acl : acls) {
							final String name = acl.getName();
							if (name.startsWith("Pays")) {
							} else if (name.startsWith("Ville")) {
							} else if (name.startsWith("ACL")) {
								result.set(acl.getMembers());
							} else {
							}
						}

						return result.get();
					}
				});
				futures.put(course, future);
			}

			for (Entry<IntraCourse, Future<Collection<IntraACLMember>>> entry : futures.entrySet()) {
				final IntraCourse object = entry.getKey();
				final Collection<IntraACLMember> members = entry.getValue().get();
				boolean hasProf = false;
				for (IntraACLMember member : members) {
					Boolean profInstance = member.getProfInstance();
					if (profInstance != null && profInstance.booleanValue()) {
						hasProf = true;
						System.out.println(String.format("%s[%s][%s] : %s", object.getTitle(), object.getCode(), object.getCodeInstance(), member.getTitle()));
					}
				}
				if (!hasProf) {
					System.out.println(String.format("%s[%s][%s] : %s", object.getTitle(), object.getCode(), object.getCodeInstance(), "???"));
				}
			}
			service.shutdown();
		}
		if (execute) {
			final IntraURLBuilder builder = ModuleBoardIntraURLBuilder.newBuilder();
			final JSON json = HttpClientHelper.getJSONArray(builder);
			System.out.println(json.toString(4));
		}
		if (execute) {
			final IntraURLBuilder builder = UserCompleteIntraURLBuilder.newBuilder("bonnet");
			final JSON json = HttpClientHelper.getJSONArray(builder);
			System.out.println(json.toString(4));
		}
		if (execute) {
			final IntraURLBuilder builder = UserNotificationMissedIntraURLBuilder.newBuilder("bonnet_h");
			final JSON json = HttpClientHelper.getJSONObject(builder);
			System.out.println(json.toString(4));
		}
	}

}
