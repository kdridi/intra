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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import eu.epitech.intra.builders.CourseACLIntraURLBuilder;
import eu.epitech.intra.builders.CourseFilterIntraURLBuilder;
import eu.epitech.intra.builders.ModuleBoardIntraURLBuilder;
import eu.epitech.intra.builders.UserCompleteIntraURLBuilder;
import eu.epitech.intra.builders.UserNotificationMissedIntraURLBuilder;
import eu.epitech.intra.commons.IntraURLBuilder;
import eu.epitech.intra.commons.helpers.HttpClientHelper;

public class App {
	public static void main(String[] args) throws Exception {
		final CourseACLIntraURLBuilder builder = CourseACLIntraURLBuilder.newBuilder("2014", "B-ANG-050", "PAR-1-1");
		final JSON json = HttpClientHelper.getJSONArray(builder);
		System.out.println(json.toString(4));
	}

	public static void main2(String[] args) throws Exception {
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

			final ExecutorService service = Executors.newFixedThreadPool(10);
			final Map<JSONObject, Future<JSONArray>> futures = new HashMap<>();
			final JSONArray json = HttpClientHelper.getJSONArray(builder);
			for (int index = 0; index < json.size(); index++) {
				final String message = String.format("%d/%d", index + 1, json.size());
				final JSONObject object = json.getJSONObject(index);
				final Future<JSONArray> future = service.submit(new Callable<JSONArray>() {
					@Override
					public JSONArray call() throws Exception {
						final String scolarYear = Integer.valueOf(object.getInt("scolaryear")).toString();
						final String code = object.getString("code");
						final String codeInstance = object.getString("codeinstance");

						final ThreadLocal<JSONArray> result = new ThreadLocal<>();
						try {
							result.set(fetchMembers(CourseACLIntraURLBuilder.newBuilder(scolarYear, code, codeInstance)));
						} catch (Exception e) {
							final String title = object.getString("title");
							System.err.println(title);
							System.err.println(String.format("https://intra.epitech.eu/module/%s/%s/%s/#!/all", scolarYear, code, codeInstance));
						}

						System.out.println(message);

						return result.get();
					}

					private JSONArray fetchMembers(final CourseACLIntraURLBuilder builder) {
						final ThreadLocal<JSONArray> result = new ThreadLocal<>();
						final JSONArray array = HttpClientHelper.getJSONArray(builder);
						for (int index = 0; index < array.size(); index++) {
							JSONObject object = array.getJSONObject(index);
							final String name = object.getString("name");
							if (name.startsWith("Pays")) {
							} else if (name.startsWith("Ville")) {
							} else if (name.startsWith("ACL")) {
								result.set(object.getJSONArray("members"));
							} else {
							}
						}
						return result.get();
					}
				});
				futures.put(object, future);
			}

			for (Entry<JSONObject, Future<JSONArray>> entry : futures.entrySet()) {
				final JSONObject object = entry.getKey();
				final JSONArray members = entry.getValue().get();
				if (members != null) {
					object.put("acl", members);
				}
			}
			service.shutdown();

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
