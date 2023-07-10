import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	    public void testRetrieveAllChromeBook() {
	    	
	    	
	    	assertNotNull(users);
	    	
	    	assertEquals(0,users.size());
	    	
	    	
	    	assertEquals(0,users.size());
	    	
	    	UserRegistration.addChromeBook(users, new User("CB0011","My Google Chromebook 1st OS","MacOs");
	    	UserRegistration.addChromeBook(users, new User("CB0012","SAMSUNG Chromebook 4+ OS","Win 10");
	    	
	    	assertEquals(2,users.size());
	    	
	}

}
