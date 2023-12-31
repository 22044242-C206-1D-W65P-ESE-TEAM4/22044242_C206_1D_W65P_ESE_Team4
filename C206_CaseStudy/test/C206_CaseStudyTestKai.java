import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTestKai {
	//22003477 - Zay Yar Lin Naing

	private ArrayList<Assessment> assessmentList;
	private Assessment a1;
	private Assessment a2;
	private Assessment a3;

	@Before
	public void setUp() throws Exception {

		a1 = new Assessment(1, "Work Sample Test", "Testing Flights", "Aerospace", "Aeronautical Engineer",
		new File("areo.txt")); 
		a2 = new Assessment(2, "Personality Test", "Repairing Computers", "Computer Technology", "Computer Engineer",
		new File("cs.txt"));
		a3 = new Assessment(3, "Hard Skill Test", "General Construction", "Construction", "Brickmason",
		new File("construction.txt"));
		assessmentList = new ArrayList<Assessment>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	// Kai's code starts here.
	@Test
	public void testAddAssessment() {

		// An ArrayList is here
		assertNotNull("Test if there is a valid arrayList for assessment to add", assessmentList);

		assertEquals("Test if the arrayList is empty at first", 0, assessmentList.size());

		Assessment.AddAssessment(assessmentList, a1);

		assertEquals("Test if the size of arrayList reflect after successful addition", 1, assessmentList.size());

		Assessment.AddAssessment(assessmentList, a2);

		assertEquals("Test if the size of arrayList reflect after another successful addition", 2,
				assessmentList.size());

		// RepetitiveAdding
		Assessment.AddAssessment(assessmentList, a1);

		assertEquals("Test if the size of arrayList stays the same after repetitive addition", 2,
				assessmentList.size());

		// MisisingInfo
		Assessment missinginfo = new Assessment(0, "Personality Test", "Kindergarden Edu", "Education", "",
				new File(""));
		Assessment.AddAssessment(assessmentList, missinginfo);

		assertEquals("Test if the arrayList stays unchanged when assessment with missing info is added", 2,
				assessmentList.size());

	}

	@Test
	public void testViewAssessment() {

		// an ArrayList is here
		assertNotNull("Test if there is an arrayList to view ", assessmentList);

		assertEquals("Test if the arrayList is empty at first", 0, assessmentList.size());

		// nothing to display at first other than titles

		String output = Assessment.ViewAssessment(assessmentList);
		String test = String.format("%-5s %-25s %-25s %-25s %-30s %-30s\n\n", "ID", "TYPE", "TOPIC", "INDUSTRY",
				"CAREER PROSPECT", "FILE NAME");

		assertEquals("Test if there is no data of assessment in the list", output, test);

		// the assessment is shown after it is being added

		Assessment.AddAssessment(assessmentList, a1);
		Assessment.AddAssessment(assessmentList, a2);

		String assessmentdata = Assessment.ViewAssessment(assessmentList);

		test += String.format("%-5d %-25s %-25s %-25s %-30s %-30s\n", 1, "Work Sample Test", "Testing Flights",
				"Aerospace", "Aeronautical Engineer", new File("areo.txt"));
		test += String.format("%-5d %-25s %-25s %-25s %-30s %-30s\n", 2, "Personality Test", "Repairing Computers",
				"Computer Technology", "Computer Engineer", new File("cs.txt"));

		assertEquals(2,assessmentList.size());
		assertEquals("Test if the added assessment data is shown ", assessmentdata, test);

		// the repetitive assessment is not shown in the list after being added.

		Assessment.AddAssessment(assessmentList, a1);
		String assessment = Assessment.ViewAssessment(assessmentList);
		assertEquals(2,assessmentList.size());
		assertEquals("Test if the same assessment is not displayed twice", assessment, test);

	}

	@Test
	public void testDeleteAssessment() {
		// a valid arrayList to delete from
		assertNotNull("Test if there is an arrayList to delete from ", assessmentList);

		assertEquals("Test if the arrayList is empty at first", 0, assessmentList.size());

		Assessment.AddAssessment(assessmentList, a1);

		// available assessment in the list is successfully deleted
		boolean delete = Assessment.DeleteAssessment(assessmentList, 1);

		assertTrue("Test if the available item in the list is successfully deleted ", delete);

		// Test if the assessment which is not in the list cannot be deleted
		delete = Assessment.DeleteAssessment(assessmentList, 2);
		assertFalse("Test if the assessment not in the list cannot be deleted ", delete);

		// delete twice

		delete = Assessment.DeleteAssessment(assessmentList, 1);
		assertFalse("Test if the deleted assessment cannot be deleted again", delete);

		// delete not shown in the list

		Assessment.AddAssessment(assessmentList, a3);
		delete = Assessment.DeleteAssessment(assessmentList, 3);
		String display = Assessment.ViewAssessment(assessmentList);

		String test = String.format("%-5s %-25s %-25s %-25s %-30s %-30s\n\n", "ID", "TYPE", "TOPIC", "INDUSTRY",
				"CAREER PROSPECT", "FILE NAME");

		assertEquals("Test if the deleted assessment is not shown in the list anymore", test, display);

	}
	// Kai's test cases end here.

	@After
	public void tearDown() throws Exception {
		a1 = null;
		a2 = null;
		a3 = null;

		assessmentList = null;

	}

}
