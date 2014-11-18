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
import eu.epitech.intra.domain.IntraACL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class IntraACLTestCase {
	@Before
	public void onBeforeTestCase() {
		System.out.println("onBeforeTestCase");
	}

	@After
	public void onAfterTestCase() {
		System.out.println("onAfterTestCase");
	}

	@Test
	public void onTestMapIntraACLObject() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraACLTestCase_object.json");
		final IntraACL object = IntraJSONHelper.readTypeReference(in, new TypeReference<IntraACL>() {
		});
		try {
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		assertEquals(IntraACL.class, object.getClass());
	}

	@Test
	public void onTestMapIntraACLArray() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraACLTestCase_array.json");
		final List<IntraACL> objects = IntraJSONHelper.readTypeReference(in, new TypeReference<List<IntraACL>>() {
		});
		try {
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		for (Object object : objects) {
			assertEquals(IntraACL.class, object.getClass());
		}
		System.out.println(objects.size());
	}
}
