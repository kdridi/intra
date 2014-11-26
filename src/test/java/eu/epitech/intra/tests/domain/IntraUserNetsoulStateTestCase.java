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

import eu.epitech.intra.commons.helpers.IntraJSONHelper;
import eu.epitech.intra.domain.IntraUserNetsoulState;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class IntraUserNetsoulStateTestCase {
	@Before
	public void onBeforeTestCase() {
		System.out.println("onBeforeTestCase");
	}

	@After
	public void onAfterTestCase() {
		System.out.println("onAfterTestCase");
	}

	@Test
	public void onTestMapIntraUserNetsoulStateObject() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraUserNetsoulStateTestCase_object.json");
		final IntraUserNetsoulState object = IntraJSONHelper.readTypeReference(in, new TypeReference<IntraUserNetsoulState>() {
		});
		try {
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		assertEquals(IntraUserNetsoulState.class, object.getClass());
		System.out.println(object.getDate());
		System.out.println(object.getDateAsString());
		System.out.println(object.getTimeInActive());
		System.out.println(object.getTimeInIdle());
		System.out.println(object.getTimeOutActive());
		System.out.println(object.getTimeOutIdle());
		System.out.println(object.getTimeAverage());
	}

	@Test
	public void onTestMapIntraUserNetsoulStateArray() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraUserNetsoulStateTestCase_array.json");
		final List<IntraUserNetsoulState> objects = IntraJSONHelper.readTypeReference(in, new TypeReference<List<IntraUserNetsoulState>>() {
		});
		try {
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		for (Object object : objects) {
			assertEquals(IntraUserNetsoulState.class, object.getClass());
		}
		System.out.println(objects.size());
	}

}
