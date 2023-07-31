import java.util.ArrayList;

public class C206_CaseStudy {
	
	// custom users
	User admin = new User(1, "Admin", "admin@gmail.com", "admin", "lol1");
	User user1 = new User(2, "john doe1", "john1@sgmail.com", "user", "lol123");
	User user2 = new User(3, "john doe2", "john2@gmail.com", "user", "lol123");
	
	ArrayList<User> usersList = new ArrayList<User>();
	
	

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
	
	public static void start() {
		
	}
	
	public static boolean validateEmailAddress(String email) {	
		String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    return email.matches(emailPattern);
	}
	
	public static User register(ArrayList<User> usersList, String email, String password1, String password2) {
		if(password1.equals(password2) && validateEmailAddress(email)) {
			/*
			 * Roles:
			 * 1. user
			 * 2. admin
			 * 3. 
			 * */
			
//			user will be automatically be set to role:user, only "admin" can edit/upgrade the roles
			
			String name = Helper.readString("Enter name:");
			User user = new User(usersList.size() + 1,name,email, "user", password2);
			
			if(user != null) {
				System.out.println("User registered");
				return user;
			}
			// have to redirect to create profile
			
		}		
		// default return false
		return null;
	}
	
	public static User login(ArrayList<User> usersList, String email, String password) {
		
		for(User user: usersList) {
			if(validateEmailAddress(email)) {
				
				if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)){
					System.out.println("Welcome back," + user.getName());
					return user;
				}
				
			}
		}		
		return null;
	} 


}
