package eu.epitech.intra;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class IntraUserTestCase {
	@Before
	public void onBeforeTestCase() {
		System.out.println("onBeforeTestCase");
	}

	@After
	public void onAfterTestCase() {
		System.out.println("onAfterTestCase");
	}

	public static enum IntraUserType {
		user;
	}

	public static class IntraUser implements Serializable {
		private static final long serialVersionUID = 7678311136075358488L;

		private String title;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		private IntraUserType type;

		public IntraUserType getType() {
			return type;
		}

		public void setType(IntraUserType type) {
			this.type = type;
		}

		private String login;

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		private String picture;

		public String getPicture() {
			return picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}

		private String course_code;

		public String getCourse_code() {
			return course_code;
		}

		public void setCourse_code(String course_code) {
			this.course_code = course_code;
		}

		private String promo;

		public String getPromo() {
			return promo;
		}

		private String course;

		public void setPromo(String promo) {
			this.promo = promo;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		private String picture_fun;

		public String getPicture_fun() {
			return picture_fun;
		}

		public void setPicture_fun(String picture_fun) {
			this.picture_fun = picture_fun;
		}

	}

	@Test
	public void onTestMapIntraUserObject() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraUserTestCase_object.json");
		final IntraUser user = readObject(in, IntraUser.class);
		try {
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println(user);
	}

	@Test
	public void onTestMapIntraUserArray() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraUserTestCase_array.json");
		final List<IntraUser> users = readList(in, IntraUser.class);
		try {
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		for (Object user : users) {
			System.out.println(user);
		}
		System.out.println(users.size());
	}

	private static <T> T readObject(InputStream in, Class<T> type) {
		return readObject(new BufferedReader(new InputStreamReader(in)), type);
	}

	private static <T> T readObject(Reader reader, Class<T> type) {
		T result = null;
		try {

			final ObjectMapper mapper = new ObjectMapper();
			final JsonFactory factory = mapper.getFactory();
			final JsonParser parser = factory.createParser(reader);
			parser.enable(Feature.ALLOW_COMMENTS);
			result = parser.readValueAs(type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private static <T> List<T> readList(InputStream in, Class<T> type) {
		return readList(new BufferedReader(new InputStreamReader(in)), type);
	}

	private static <T> List<T> readList(final Reader reader, Class<T> type) {
		List<T> result = null;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final JsonFactory factory = mapper.getFactory();
			final JsonParser parser = factory.createParser(reader);
			parser.enable(Feature.ALLOW_COMMENTS);
			result = parser.readValueAs(new TypeReference<List<T>>() {
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

}
