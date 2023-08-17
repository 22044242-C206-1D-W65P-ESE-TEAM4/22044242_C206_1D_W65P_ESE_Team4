import static org.junit.Assert.*;

import org.junit.After;
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
		assertTrue("C206_CaseStudy_SampleTest",true);
	}

	@Test
	public void testViewCareerPath() {
		// list was initially empty (1st test)
		assertNotNull("Test that the list was initially null", cpList);
		assertEquals("Test of the arrayList is empty initially", 0, cpList.size());

		// the career path is being added
		// cpList.add(c1);
		C206_CaseStudy.addNewCareerPath(admin, cpList);
		assertEquals("Test that the values increased", 1, cpList.size());

		// when viewing the career path
		careerdata = C206_CaseStudy.viewCareerPath(admin, cpList);
		assertEquals("Test that the values increased",1, cpList.size());
		careerdata = C206_CaseStudy.viewCareerPath(admin, cpList);
		

	}

	@Test
	public void testaddNewCareerPath() {

		// list was initially empty
		assertNotNull("Test that the list was initially null", cpList);
		assertEquals("Test of the arrayList is empty initially", 0, cpList.size());

		// when size of list is 1:
		C206_CaseStudy.addNewCareerPath(admin, cpList);
		assertEquals("Test that the values increased", 1, cpList.size());

		assertEquals("Test if the size of arrayList reflect after successful addition", 1, cpList.size());

		// when size of the list is 2:
		C206_CaseStudy.addNewCareerPath(admin, cpList);
		assertEquals("Test that the values increased", 2, cpList.size());

		assertEquals("Test if the size of arrayList reflect after another successful addition", 2, cpList.size());
		
		
		 
		
		

	}

	@Test
	public void testDeleteCareerPath() {
	    // Create CareerPath objects
	    CareerPath c1 = new CareerPath(1, 1, "Software Engineer", "Develops software applications",
	            "High growth potential", "Programming skills");
	    CareerPath c2 = new CareerPath(1, 2, "UI Designer", "Design user interface", "Understanding user behaviour",
	            "communication skills");

	    // Initialize the list and add elements
	    cpList = new ArrayList<>();
	    cpList.add(c1);
	    cpList.add(c2);

	    // Check that the list is initially not null and has the expected size
	    assertNotNull("Test that the list was initially not null", cpList);
	    assertEquals("Test if the list has the expected size", 2, cpList.size());

	    // Create a CareerPath that is not in the list
	    CareerPath c3 = new CareerPath(1, 3, "Data Analyst", "Analyzes data", "Statistical analysis", "Data skills");

	    // Call deleteCareerPath method to remove an element from the list
	    C206_CaseStudy.deleteCareerPath(cpList);

	    // Check if the size of the list decreases by 1 after deletion
	    assertEquals("Test if the list decreases by 1 after deletion", 1, cpList.size());

	    // Call deleteCareerPath method to remove a CareerPath not in the list
	    C206_CaseStudy.deleteCareerPath(cpList);

	    // Check that the list size remains unchanged since the CareerPath was not in the list
	    assertEquals("Test if the list size remains unchanged", 1, cpList.size());
	}
	
	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2= null;
		
		cpList = null;
	}
}
