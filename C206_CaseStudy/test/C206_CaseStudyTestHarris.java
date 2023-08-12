import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author 22044242
 *
 */
public class C206_CaseStudyTestHarris {

	//variable setup
	User currentUser;
	User admin,user1,user2;
	ArrayList<User> usersList;
	ArrayList<Profile> profileList;
	ArrayList<EducationBackground> educationBackgroundList;

	
	// custom profiles
	Profile adminProfile;
	Profile user1Profile;
	Profile user2Profile;
	
	// custom Education backgrounds
	EducationBackground adminEB;
	EducationBackground user1EB;
	EducationBackground user2EB;
	
	@Before
	public void setUp() throws Exception {
		// custom users
		admin = new User(1, "Admin", "admin@gmail.com", "admin", "lol123");
		usersList = new ArrayList<User>(Arrays.asList(admin));

	    
		// custom profiles
		adminProfile = new Profile(1, 1, 12345678, "02/02/2002");
		profileList = new ArrayList<Profile>(Arrays.asList(adminProfile));

		// custom education background
		EducationBackground adminEB = new EducationBackground(1,1,"Computer science", "NUS", 2022);
		educationBackgroundList = new ArrayList<EducationBackground>(Arrays.asList(adminEB));

	}
	
//	@Test
//	public void testRegister() {
//		// Users List is not null or not empty (cause have admin credentials)
//		assertNotNull("Test if there is a valid User arrayList to add to", usersList);
//		assertEquals("Test that the Users list is not empty",1,usersList.size());
//		
//		//Given a user is registered and the profile is setup, the arrayList increase in size by 1
//		user1 = new User(2, "john doe1", "john1@sgmail.com", "user", "lol123");
//		usersList.add(user1);
//		
//		assertEquals("Test that the new user is inserted",2,usersList.size());
//		
//		//Given a user has entered an invalid email address
//		C206_CaseStudy.register(usersList,"user1","2cw.c","lol123", "lol123", profileList, currentUser);
//		assertEquals("Test that the new user is not inserted",2,usersList.size());
//	
//		//Given a user has entered a similar email address
//		C206_CaseStudy.register(usersList,"user2","admin@gmail.com","lol123", "lol123", profileList, currentUser);
//		assertEquals("Test that the new user is not inserted",2,usersList.size());
//	}
	
//	@Test
//	public void testLogin(){
//		
//		//Test that the currentUser variable to store the login user is initially empty/null.
//		assertNull("Test if currentUser variable is null", currentUser);
//		
//		//Given that the user has successfully login, the currentUser is not null
//		currentUser = C206_CaseStudy.login(usersList, "admin@gmail.com", "lol123");
//		assertNotNull("Test if currentUser variable has a user stored", currentUser);
//		
//		//Given a user has entered an invalid email address
//		currentUser = null;
//		currentUser = C206_CaseStudy.login(usersList, "2d.@.", "lol123");
//		assertNull("Test if currentUser variable has a user stored", currentUser);
//		
//		//Given that the user account does not exist
//		currentUser = null;
//		currentUser = C206_CaseStudy.login(usersList, "doesnotexist@gmail.com", "doesnotexist");
//		assertNull("Test if currentUser variable has a user stored", currentUser);
//	}
//	
//	@Test
//	public void testProfileManagement() {
//		// Profile List is not null or not empty (cause have admin profile info)
//		assertNotNull("Test if there is a valid Profile arrayList to add to", profileList);
//		assertEquals("Test that the Profile list is not empty",1,profileList.size());
//		
//		//Given a user has created a profile, the arrayList increase in size by 1
//		user1Profile = C206_CaseStudy.createProfileTest(2,profileList, 22345678, "03/03/2003");
//		profileList.add(user1Profile);
//		
//		assertEquals("Test that the new profile is inserted",2,profileList.size());
//		
//		//Given a user has attempted to create a profile with invalid phone number
//		user1Profile = C206_CaseStudy.createProfileTest(2, profileList, 12345, "20/02/2002");
//		assertNull("Test that the new profile is null",user1Profile);
//	
//		//Given that the user is updating the profile with no changes
//		// Input 0 as default values
//		assertTrue(C206_CaseStudy.updateProfileTest(1, profileList, usersList, "0", "0", "0", 0));
//		
//		//Given that the user is updating the profile with different valid values
//	
//		assertTrue(C206_CaseStudy.updateProfileTest(1, profileList, usersList, "AdminHarris", "admin2@gmail.com", "20/02/2002"
//				, 98761234));
//		//Given that the user is updating the profile with invalid values such as email address and contact info
//		
//		assertFalse(C206_CaseStudy.updateProfileTest(1, profileList, usersList, "AdminHarris", "2", "20/02/2002", 987));
//		
//	}
//	
	@Test
	public void testEducationBackgroundManagement() {
		// Education background List is not null or not empty (cause have admin profile info)
		assertNotNull("Test if there is a valid Education background arrayList to add to", educationBackgroundList);
		assertEquals("Test that the Education background list is not empty",1,educationBackgroundList.size());
		
		//Given a user has created a EB, the arrayList increase in size by 1
		
		user1 = new User(2, "john doe1", "john1@sgmail.com", "user", "lol123");
		usersList.add(user1);
		
		
		user1EB = C206_CaseStudy.createEducationBackgroundTest(2, usersList, educationBackgroundList, "Art", "NTU",2023);
		educationBackgroundList.add(user1EB);
		assertEquals("Test that the new Education Background is inserted",2,educationBackgroundList.size());
		
		//Given a user has attempted to create a background with invalid user id
		user1EB = C206_CaseStudy.createEducationBackgroundTest(5, usersList, educationBackgroundList, "Art", "NTU",2023);
		assertNull("Test that the the value returned will be null rather than en educationBackground",user1EB);
		
		//Given that the user is updating the profile with no changes
		// Input 0 as default values
		assertTrue(C206_CaseStudy.updateEducationBackgroundTest(1, educationBackgroundList, "0", "0", 0));
		
		//Given that the user is updating the profile with different valid values
		assertTrue(C206_CaseStudy.updateEducationBackgroundTest(1, educationBackgroundList, "Food sciences", "SIT", 2021));
		
		//Given that the user is updating the profile with invalid user id
		assertFalse(C206_CaseStudy.updateEducationBackgroundTest(10, educationBackgroundList, "Food sciences", "SIT", 2021));	
	}
	
	
	@After
	public void tearDown() throws Exception {
		//variable setup
		currentUser=null;
		admin=null;user1=null;user2=null;
		
		// custom profiles
		adminProfile=null;
		user1Profile=null;
		user2Profile=null;
		
		// custom Education backgrounds
		adminEB=null;
		user1EB=null;
		user2EB=null;
		 
		 //ArrayLists
		usersList=null;
		profileList=null;
		educationBackgroundList=null;
	}

	
	

}
