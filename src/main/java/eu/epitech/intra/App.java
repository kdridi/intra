package eu.epitech.intra;

import static eu.epitech.intra.commons.IntraCourse.BACHELOR_CLASSIC;
import static eu.epitech.intra.commons.IntraCourse.BACHELOR_TEK1ED;
import static eu.epitech.intra.commons.IntraCourse.BACHELOR_TEK2ED;
import static eu.epitech.intra.commons.IntraCourse.BACHELOR_TEK3S;
import static eu.epitech.intra.commons.IntraCourse.MASTER_CLASSIC;
import static eu.epitech.intra.commons.IntraCourse.MASTER_TEK3SI;
import static eu.epitech.intra.commons.IntraCourse.OTHER;
import static eu.epitech.intra.commons.IntraCourse.SAMSUNG_WAC;
import static eu.epitech.intra.commons.IntraCourse.WEBACADEMIE;
import static eu.epitech.intra.commons.IntraLocation.FRANCE;
import static eu.epitech.intra.commons.IntraLocation.FRANCE_PARIS;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import eu.epitech.intra.builders.AnnuelInstanceIntraURLBuilder;
import eu.epitech.intra.builders.CourseACLIntraURLBuilder;
import eu.epitech.intra.builders.CourseFilterIntraURLBuilder;
import eu.epitech.intra.builders.ModuleBoardIntraURLBuilder;
import eu.epitech.intra.builders.UserCompleteIntraURLBuilder;
import eu.epitech.intra.builders.UserNotificationMissedIntraURLBuilder;
import eu.epitech.intra.commons.IntraURLBuilder;
import eu.epitech.intra.commons.helpers.HttpClientHelper;

public class App {
	public static void main(String[] args) throws Exception {
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

			builder.addCourse(SAMSUNG_WAC);
			builder.addCourse(BACHELOR_CLASSIC);
			builder.addCourse(BACHELOR_TEK1ED);
			builder.addCourse(BACHELOR_TEK2ED);
			builder.addCourse(BACHELOR_TEK3S);
			builder.addCourse(MASTER_CLASSIC);
			builder.addCourse(MASTER_TEK3SI);
			builder.addCourse(WEBACADEMIE);
			builder.addCourse(OTHER);

			// builder.addScolarYear(2013);
			builder.addScolarYear(2014);

			final JSONArray json = HttpClientHelper.getJSONArray(builder);
			for (int index = 0; index < json.size(); index++) {
				System.out.println(String.format("%d/%d", index + 1, json.size()));
				JSONObject object = json.getJSONObject(index);

				final String scolarYear = Integer.valueOf(object.getInt("scolaryear")).toString();
				final String code = object.getString("code");
				final String codeInstance = object.getString("codeinstance");
				final String instanceLocation = object.getString("instance_location");

				final CourseACLIntraURLBuilder aclBuilder = CourseACLIntraURLBuilder.newBuilder(scolarYear, code, codeInstance);
				try {
					final JSONArray acl = HttpClientHelper.getJSONArray(aclBuilder);
					for (int i = 0; i < acl.size(); i++) {
						JSONObject o = acl.getJSONObject(i);
						final String name = o.getString("name");
						if (name.startsWith("Pays")) {
						} else if (name.startsWith("Ville")) {
						} else if (name.startsWith("ACL")) {
							object.put("acl", o.getJSONArray("members"));
						} else {
						}
					}
				} catch (Exception e) {
					final String title = object.getString("title");
					System.err.println(title);
					System.err.println(String.format("https://intra.epitech.eu/module/%s/%s/%s/#!/all", scolarYear, code, codeInstance));
				}

				final AnnuelInstanceIntraURLBuilder annuelBuilder = AnnuelInstanceIntraURLBuilder.newBuilder(scolarYear, code, instanceLocation);
				try {
					// final JSON annuel = HttpClientHelper.getJSONArray(annuelBuilder);
					// object.put("annuel", annuel);
				} catch (Exception e) {
					final String title = object.getString("title");
					System.err.println(title);
					System.err.println(String.format("https://intra.epitech.eu/module/%s/%s/%s/#!/all", scolarYear, code, codeInstance));
				}
			}
			System.out.println(json.toString(4));
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
