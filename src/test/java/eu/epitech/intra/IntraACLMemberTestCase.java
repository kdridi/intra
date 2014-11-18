package eu.epitech.intra;

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

import eu.epitech.intra.domain.IntraACLMember;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class IntraACLMemberTestCase {
	@Before
	public void onBeforeTestCase() {
		System.out.println("onBeforeTestCase");
	}

	@After
	public void onAfterTestCase() {
		System.out.println("onAfterTestCase");
	}

	@Test
	public void onTestMapIntraACLMemberObject() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraACLMemberTestCase_object.json");
		final IntraACLMember user = IntraTestCaseHelper.readTypeReference(in, new TypeReference<IntraACLMember>() {
		});
		try {
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println(user);
	}

	@Test
	public void onTestMapIntraACLMemberArray() {
		final InputStream in = getClass().getClassLoader().getResourceAsStream("IntraACLMemberTestCase_array.json");
		final List<IntraACLMember> users = IntraTestCaseHelper.readTypeReference(in, new TypeReference<List<IntraACLMember>>() {
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
