package eu.epitech.intra.tests.domain;

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.epitech.intra.domain.IntraUser;

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

	@Test
	public void onTestMapIntraUserObject() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraUserTestCase_object.json");
		final IntraUser user = IntraTestCaseHelper.readTypeReference(in, new TypeReference<IntraUser>() {
		});
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
		final List<IntraUser> users = IntraTestCaseHelper.readTypeReference(in, new TypeReference<List<IntraUser>>() {
		});
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

}
