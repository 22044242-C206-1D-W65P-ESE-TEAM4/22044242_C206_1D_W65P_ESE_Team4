import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class C206_CaseStudyTestJingJie {
	private ArrayList<Skill>skillList;
	private ArrayList<User>usersList;
	Skill s1;
	Skill s2;
	User u1;
	User u2;
	
	@Before
	public void setUp() throws Exception {
		usersList = new ArrayList<User>();
        usersList.add(new User(1, "Admin", "admin@gmail.com", "admin", "lol123"));
        usersList.add(new User(2, "john doe1", "john1@sgmail.com", "user", "lol123"));
        usersList.add(new User(3, "john doe2", "john2@gmail.com", "user", "lol123"));
        usersList.add(new User(4, "Hr1", "Hr1@gmail.com", "HR", "lol123"));
        
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill(2));
        skillList.add(new Skill(3));
        
        System.out.println(skillList.size());

        skillList.get(0).addSkill("Applications Development");
        skillList.get(0).addSkill("Applications Integration");
        skillList.get(1).addSkill("Business innovation");
        skillList.get(1).addSkill("Software Design");
	}
	
	@Test
	public void testViewSkills() {
		
		assertNotNull("Test if there is a valid arrayList for skill to add", skillList);
			
		assertNotEquals("Test if the arrayList is not empty at first", 0, skillList.size());
		
		
	}
	
	@Test
	public void testAddSkill() {
				
		assertNotNull("Test if there is a valid arrayList to add", skillList);

		assertNotEquals("Test if the arrayList is empty at first", 0, skillList.size());
		
		skillList.add(new Skill(4));
		
		assertEquals(3, skillList.size());
		
	}
	
	@Test
	public void testDeleteSkill() {
				
		assertNotNull("Test if there is an arrayList to delete from ", skillList);
		
		assertNotEquals("Test if the arrayList is empty at first", 0, skillList.size());
		
		C206_CaseStudy.deleteSkill(usersList, skillList);

		assertEquals("Test if the available item in the list is successful",1, skillList.get(0).getSkills().size());

	}
	@After
	public void tearDown() throws Exception {
		skillList = null;
		usersList = null;
		
		
		s1 = null;
		s2 = null;
		u1 = null;
		u2 = null;
	}
}

