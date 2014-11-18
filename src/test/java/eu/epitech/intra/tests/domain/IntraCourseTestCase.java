package eu.epitech.intra.tests.domain;

import static org.junit.Assert.assertEquals;

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

import eu.epitech.intra.IntraJSONHelper;
import eu.epitech.intra.domain.IntraCourse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class IntraCourseTestCase {
	@Before
	public void onBeforeTestCase() {
		System.out.println("onBeforeTestCase");
	}

	@After
	public void onAfterTestCase() {
		System.out.println("onAfterTestCase");
	}

	@Test
	public void onTestMapIntraCourseObject() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraCourseTestCase_object.json");
		final IntraCourse object = IntraJSONHelper.readTypeReference(in, new TypeReference<IntraCourse>() {
		});
		try {
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		assertEquals(IntraCourse.class, object.getClass());

	}

	@Test
	public void onTestMapIntraCourseArray() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraCourseTestCase_array.json");
		final List<IntraCourse> objects = IntraJSONHelper.readTypeReference(in, new TypeReference<List<IntraCourse>>() {
		});
		try {
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		for (Object object : objects) {
			assertEquals(IntraCourse.class, object.getClass());
		}
		System.out.println(objects.size());
	}

}
