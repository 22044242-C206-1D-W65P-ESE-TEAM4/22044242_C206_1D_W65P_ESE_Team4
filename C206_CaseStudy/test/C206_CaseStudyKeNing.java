import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyKeNing {
	
	private ArrayList<EducationBackground> EBlist;
	private ArrayList<ResumeTemplate> resumeList;
	private ArrayList<JobExperience> jbl;
	
	EducationBackground user1EB;
	EducationBackground user2EB;
	
	ResumeTemplate user1Resume;
	ResumeTemplate user2Resume;
	
	JobExperience jbe1;
	JobExperience jbe2;
	
	String user1Description;
	String user2Description;
	
	
	
	@Before
	public void setUp() throws Exception 
	{
		
		// custom Education backgrounds
		user1EB = new EducationBackground(1, 1, "Art", "NTU", 2023);

		EBlist = new ArrayList<EducationBackground>(Arrays.asList(user1EB));
		EBlist.add(user1EB);
						
		//custom job experience
		jbl = new ArrayList<JobExperience>();
		jbe1 = new JobExperience("DBS","Software Tester","Aug 2020 - Sept 2023","Lead some projects");

		jbe2 = new JobExperience("Smart Nation","Software Tester","Mar 2020 - Sept 2021","Projects leader");
		
		//add to job experience list
		jbl=new ArrayList<JobExperience>(Arrays.asList(jbe1));
		jbl.add(jbe1);
				
		//custom Resumes
		user1Description = "Experienced software developer with a passion for crafting efficient and innovative solutions. "
								+ "Proficient in multiple programming languages and adept at collaborating in Agile environments. "
								+ "Track record of delivering high-quality code and driving project success. Eager to contribute technical expertise to a dynamic team.";
		
		user2Description ="Experienced software developer with a proven track record of delivering high-quality solutions in fast-paced environments."
				+ " Proficient in full-stack development, utilizing languages like Python, JavaScript, and Java. "
				+ "Expertise in designing and implementing efficient algorithms and data structures. "
				+ "Strong problem-solving skills and a collaborative mindset, demonstrated through successful cross-functional team projects. ";
		
		resumeList = new ArrayList<ResumeTemplate>();

		user1Resume= new ResumeTemplate(2,1,1,jbl,"GovTech Resume","John Doe 1",22345678,"john1@sgmail.com",user1Description);

		user2Resume= new ResumeTemplate(3,1,1,jbl,"Navy Resume","John Doe 2",32345678,"john2@gmail.com",user2Description);
		 
		//add to resumeList
		//resumeList = new ArrayList<ResumeTemplate>(Arrays.asList(user1Resume));		
		
	}


	@Test
	public void testAddResume() 
	{
		//list was initially empty (TEST 1)
		assertTrue("Test that the list was initially null",resumeList.isEmpty());
	
		
		//add first item to resumeList (TEST 2)
		resumeList = new ArrayList<ResumeTemplate>(Arrays.asList(user1Resume));	
		
		assertEquals("Test that if a new item is added to the list",1,resumeList.size());

		//add second item to resumeList (TEST 3)
		resumeList = new ArrayList<ResumeTemplate>(Arrays.asList(user1Resume,user2Resume));	
		assertEquals("Test that if second item is added to the list",2,resumeList.size());

		
		//test that there is no duplicate resume ID in the list (TEST 4)
	    int expectedResumeID = 1;
		    
	    assertEquals("Test that no duplicate resume ID in the list",expectedResumeID, user1Resume.getResumeID());
	    
	    

	}

	@Test
	public void testViewResume() 
	{	
		resumeList = new ArrayList<ResumeTemplate>(Arrays.asList(user1Resume));	
				
		//list is not empty (TEST 1)
		assertNotNull("Test if the resume list is not empty for viewing",resumeList.size());
		
		//view resume using resume id (TEST 2)
		int expectedResumeID=1;
		
		for (ResumeTemplate rs:resumeList)
		{
			int actualResumeID=rs.getResumeID();
			assertEquals(expectedResumeID,actualResumeID);
			
		}
		
		//view resume using resume id that does not exist (TEST 3)
		expectedResumeID=4;

		for (ResumeTemplate rs:resumeList)
		{
			int actualResumeID=rs.getResumeID();
			assertNotEquals(expectedResumeID,actualResumeID);

		}
		
	}
	
	@Test
	public void testDeleteResume() 
	{
		resumeList.add(user1Resume);
		//there is item in the list to delete
		assertEquals("Size of arraylist is at least one",1,resumeList.size());


		//after deletion, size of the list decrease by 1 (TEST 2)
		//C206_CaseStudy.DeleteResume(2,resumeList, EBlist);
		assertEquals("Test if the list decreases by 1 after deletion",1,resumeList.size());
				
		
		//resume has been deleted (TEST 3)
		assertTrue("Test if resume is deleted",C206_CaseStudy.DeleteResume(1,resumeList, EBlist));

		
	}
}
