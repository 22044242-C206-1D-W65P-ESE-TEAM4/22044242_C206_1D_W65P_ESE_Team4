import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class C206_CaseStudyTestHanLin {

	private ArrayList<CareerPath> cpList;

	private CareerPath c1;
	private CareerPath c2;

	User currentUser;
	User admin;

	private String careerdata;

	@Before
	public void setUp() throws Exception {
		// custom Career Path
		CareerPath c1 = new CareerPath(1, 1, "Software Engineer", "Develops software applications",
				"High growth potential", "Programming skills");
		CareerPath c2 = new CareerPath(1, 2, "UI Designer", "Design user interface", "Understanding user behaviour",
				"communication skills");

		cpList = new ArrayList<CareerPath>();
		admin = new User(1, "Admin", "admin@gmail.com", "admin", "lol123");

		

//		//add to cpList
//		cpList = new ArrayList<CareerPath>(Arrays.asList(currentUser));
//		cpList.add(currentUser);

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testViewCareerPath() {
		// list was initially empty (1st test)
		assertNotNull("Test that the list was initially null", cpList);
		assertEquals("Test of the arrayList is empty initially", 0, cpList.size());

		// the career path is being added
		//cpList.add(c1);
		C206_CaseStudy.addNewCareerPath(admin, cpList);
		assertEquals("Test that the values increased",1, cpList.size());
//		careerdata = C206_CaseStudy.viewCareerPath(admin, cpList);
		

	}

	@Test
	public void testaddNewCareerPath() {
		
	}
	@Test
	public void testDeleteCareerPath() {
		
		//delete a careerpath in admin
		//(C206_CaseStudy.deleteCareerPath(cpList));

	}
}
