import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class C206_CaseStudy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
		
	// Code starts from here
	public static void start() {
		User currentUser = null;
		
		// custom users
		User admin = new User(1, "Admin", "admin@gmail.com", "admin", "lol123");
		User user1 = new User(2, "john doe1", "john1@sgmail.com", "user", "lol123");
		User user2 = new User(3, "john doe2", "john2@gmail.com", "user", "lol123");
		
//		currentUser = admin;
		
		ArrayList<User> usersList = new ArrayList<User>(Arrays.asList(admin, user1, user2));
       
		// custom profiles
		Profile adminProfile = new Profile(1, 1, 12345678, "02/02/2002");
		Profile user1Profile = new Profile(2, 1, 22345678, "03/03/2003");
		Profile user2Profile = new Profile(3, 1, 32345678, "04/04/2004");
		
		ArrayList<Profile> profileList = new ArrayList<Profile>(Arrays.asList(adminProfile, user1Profile, user2Profile));
		
		// custom Education backgrounds
		EducationBackground adminEB = new EducationBackground(1,1,"Computer science", "NUS", 2022);
		EducationBackground user1EB = new EducationBackground(1,1,"Art", "NTU", 2023);
		EducationBackground user2EB = new EducationBackground(1,1,"Food sciences", "SIT", 2024);

		// Sprint 2 - haven't do yet
		ArrayList<EducationBackground> educationBackgroundList = new ArrayList<EducationBackground>(Arrays.asList(adminEB,user1EB,user2EB));
		
		
		int res = 10000;	
		
		//res = 0, means cancel
		while(res != 0) {
			res = Menu(currentUser);
			
			if(res == 0) {
				System.out.println("Thank for using the application, Goodbye!");
				break;
			}
			
			if(currentUser != null) {
				if(res == 0) {
					System.out.println("Thank for using the application, Goodbye!");
					break;
				}
				else if(res == 1) {
					ProfileManagement(currentUser, profileList, usersList);
				}
				else if(res == 2) {
					EducationBackgroundManagement(educationBackgroundList, currentUser.getUser_id());
				}
				else if(res == 3) {
					deleteAccount(currentUser.getUser_id(),usersList, profileList, educationBackgroundList);
					currentUser = null;
					res = Menu(currentUser);
					
				}
			}
			
			
			
			if(currentUser == null) {
				String email = "";
				if(res==1) {
					email = FormEmail(usersList,"register");
					String password1 = Helper.readString("Enter password >");
					String password2 = Helper.readString("Enter repeat-password>");
					String name = Helper.readString("What should we call you> ");
					currentUser = register(usersList, name, email,password1,password2, profileList,currentUser);	
					
					educationBackgroundList.add(createEducationBackground(currentUser.getUser_id(), usersList,educationBackgroundList));
				}
				else if(res == 2) {
					email = FormEmail(usersList,"login");
					String password1 = Helper.readString("Enter password >");
					currentUser = login(usersList, email, password1);
				}
				
			}
		}	
	}
	
	public static String FormEmail( ArrayList<User> usersList, String type) {
		// Email check
		boolean isEmailValid = false;
		String email = "";
		
		while(isEmailValid == false) {	
			email = Helper.readString("Enter email > ");
			isEmailValid = validateEmailAddress(email, usersList,type);
			
			if(isEmailValid == false) {
				System.out.println("\nPLease enter a valid email");
			}
		}
		
		return email;
	}
	
	
	// menu based on the USER role
	public static int Menu(User user) {
		
		Helper.line(70, "=");
		System.out.println("CPA Application");
		Helper.line(70, "=");
		
		if(user == null) {
			System.out.println("1. Register");
			System.out.println("2. Login");
		}
		
		else {
			System.out.println("1. Profile Management");
			System.out.println("2. Education Background Management");
			System.out.println("3. Disable account");
		}
		
		Helper.line(70, "=");
		int ans = Helper.readInt("Welcome to CPA, What would you like to do? ");
		Helper.line(70, "=");
		
		return ans;
	}
	
	public static void ProfileManagement(User user, ArrayList<Profile> profileList, ArrayList<User> usersList) {
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		
		int ans = Helper.readInt("Profile Management > ");
		
		if(ans == 1) {
			System.out.println(user.getEmail());
//			String output = user.displayUserInfo() + String.format("%9s ", profileList.get(user.getUser_id()).getContact_info()); 
//			System.out.println(output);
			
		}else if(ans == 2) {
			boolean isValid = updateProfile(user.getUser_id(), profileList, usersList);
		}
	}
	
	public static void EducationBackgroundManagement(ArrayList<EducationBackground> EducationBackgroundList, int id) {
		System.out.println("1. View Education Background");
		System.out.println("2. Update Education Background");
		
		int ans = Helper.readInt("Education Management > ");
		
		if(ans == 1) {
			viewEducationBackground(id,EducationBackgroundList);	
		}
		else if(ans == 2) {
			updateEducationBackground(id, EducationBackgroundList);
		}

	}	
	
	
	
	// Register a user
	public static User register(ArrayList<User> usersList,String name, String email, String password1, String password2, ArrayList<Profile> profileList,User currentUser) {
		if(password1.equals(password2)) {
			/*
			 * Roles:
			 * 1. user
			 * 2. admin
			 * 3. 
			 * */	
			//String name = "user101";
			User user = new User(usersList.size() + 1,name,email, "user", password2);
			
			if(user != null) {
			
				System.out.println("\nUser registered successfully\n");
				
				// have to redirect to create profile
				
				//createProfile(user.getUser_id(), profileList);
				
				return user;
			}
			
		}else {
			System.out.println("Password is similar.");
		}
		// default return false
		return null;
	}
	
	
	// Login user
	public static User login(ArrayList<User> usersList, String email, String password) {
		int found = 0;
		for(User user: usersList) {
			if(validateEmailAddress(email, usersList, "login")) {
				//System.out.println(user.getEmail());
				
				if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)){
					System.out.println("\nWelcome back," + user.getName() + "\n");
					found = 1;
					return user;
				}
				
			}
		}
		System.out.println("Unfortunately, Your account was not found");
		return null;
	}
	
	// Profile management - Create
	public static Profile createProfile(int user_id, ArrayList<Profile> profileList) {
		System.out.println("Redirecting to Profile creation...");
		
		Helper.line(70, "*");
		System.out.println("Let's create your profile");
		Helper.line(70, "*");
		
		
		int profile_id = profileList.size() + 1;
		boolean isValid = false;
		int contact_info = 0;
		
		while(isValid == false) {
			contact_info = Helper.readInt("Enter your contact information > ");
			isValid = validatePhoneNumber(contact_info);
			
			if(isValid == false) {
				System.out.println("Please input 8 characters");
			}
			
		}
		
		String dob = Helper.readString("Enter your Date of Birth(dd/mm/yyyy) > ");
		Profile newProfile = new Profile(profile_id, user_id, contact_info, dob);
		
		System.out.println("Profile created successfully");
		
		return newProfile;
	}
	
	// Profile management - Create
		public static Profile createProfileTest(int user_id, ArrayList<Profile> profileList, int contact_info,String dob) {
			int profile_id = profileList.size() + 1;
			boolean isValid = validatePhoneNumber(contact_info);			
			int errors = 0;
			
			isValid = validatePhoneNumber(contact_info);
			if(isValid == false) {
				System.out.println("Please input 8 characters");
				errors += 1;
			}
			
			
			if(errors < 0) {
				Profile newProfile = new Profile(profile_id, user_id, contact_info, dob);
				System.out.println("Profile created successfully");			
				return newProfile;
			}
			
			return null;
			
		}
	
    // Profile management - UPDATE
	public static boolean updateProfile(int user_id, ArrayList<Profile> profileList, ArrayList<User> userList) {
		Helper.line(70, "*");
		System.out.println("Update your profile");
		Helper.line(70, "*");
		
		int found = 0;
		
		for(Profile profile: profileList) {
			if(profile.getUser_id() == user_id) {
				User user = userList.get(user_id - 1);
				
				String name = Helper.readString(String.format("Name(%s) *type '0' to unchange > ", user.getName()));
				user.setName(name.equals("0") ? user.getName() : name);
				
				String email = Helper.readString(String.format("Email(%s) *type '0' to unchange > ", user.getEmail()));
				user.setEmail(email.equals("0") ? user.getEmail() : email);

				int contact_info = Helper.readInt(String.format("Contact Number(%d) *type '0' to unchange > ", profile.getContact_info()));
				profile.setContact_info(contact_info == 0 ? profile.getContact_info() : contact_info);
				
				String dob = Helper.readString(String.format("Dob(%s) *type '0' to unchange > ", profile.getDob()));
				profile.setDob(dob.equals("0") ? profile.getDob() : dob);
				
				System.out.println("Updated successfully.");
				
				found = 1;
				
				if(found == 1) {
					break;				
				}
				
			}
		}
		return (found == 1) ? true : false;

	}
		
	
	public static boolean updateProfileTest(int user_id, ArrayList<Profile> profileList, ArrayList<User> userList,
		String name, String email, String dob, int contact_info) {
		Helper.line(70, "*");
		System.out.println("Update your profile");
		Helper.line(70, "*");
		
		if(!email.equals("0") || contact_info != 0) {
			if(validateEmailAddress(email, userList,"login") == false || validatePhoneNumber(contact_info) == false) {
				return false;
			}
		}
		
		int found = 0;
		
		for(Profile profile: profileList) {
			if(profile.getUser_id() == user_id) {
				User user = userList.get(user_id - 1);
				
				user.setName(name.equals("0") ? user.getName() : name);
				user.setEmail(email.equals("0") ? user.getEmail() : email);
				profile.setContact_info(contact_info == 0 ? profile.getContact_info() : contact_info);
				profile.setDob(dob.equals("0") ? profile.getDob() : dob);
				
				System.out.println("Updated successfully.");
				
				found = 1;
				
				if(found == 1) {
					break;				
				}
				
			}
		}
		return (found == 1) ? true : false;

	}
	
	
	// Email Address validation
	public static boolean validateEmailAddress(String email, ArrayList<User> userList,String type) {	
		
		String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    
		if(type.equalsIgnoreCase("register")){
			for(User user: userList) {
				if(user.getEmail().equalsIgnoreCase(email)) {
					System.out.println("The email has already been used");
					return false;
				}
			}
		}
		
		return email.matches(emailPattern);	  
		
	}
	
	//Password validation
	public static boolean validatePhoneNumber(int phone) {			
		boolean phoneValid = Integer.toString(phone).length() == 8;
		return phoneValid;
	}
		
	public static void viewEducationBackground( int user_id,ArrayList<EducationBackground> EBList) {
		String output = String.format("\n%-10s %-20s %-20s\n", "Degree", "Institution", "Year Graduated");
		EducationBackground eb = EBList.get(user_id - 1);
		output += String.format("%-10s %-20s %-20d", eb.getDegree(), eb.getInstitution(), eb.getYear_graduated());
		System.out.println(output);
	}
	
	public static EducationBackground createEducationBackground(int user_id, ArrayList<User> userList,ArrayList<EducationBackground> EBlist ) {
		
		Helper.line(70, "*");
		System.out.println("Tell us more about your education background");
		Helper.line(70, "*");
		
		if(EBlist.size() == 0) {
			
			return null;
		}
		
		else {
			int educationBackground_id = EBlist.size() + 1;
			String degree = Helper.readString("Degree given > ");
			String institution = Helper.readString("Education institution > ");
			int year_graduated = Helper.readInt("Year graduated > ");
			
			EducationBackground EB = new EducationBackground(educationBackground_id,  user_id, degree, institution, year_graduated);
			System.out.println("\nThank you for your cooperation");
			
			return EB;
		}
		
	}
	
	public static EducationBackground createEducationBackgroundTest(int user_id, ArrayList<User> userList,ArrayList<EducationBackground> EBlist, String degree, String institution, int year_graduated) {
		
		Helper.line(70, "*");
		System.out.println("Tell us more about your education background");
		Helper.line(70, "*");
		EducationBackground EB = null;
		
		int educationBackground_id = EBlist.size() + 1;
		
		if(user_id == userList.size()) {
			EB = new EducationBackground(educationBackground_id,  user_id, degree, institution, year_graduated);
			return EB;
		}
		
		System.out.println("\nThank you for your cooperation");
		
		return null;
		
		
	}
		
	
	public static boolean updateEducationBackground(int user_id, ArrayList<EducationBackground> EBlist ) {
		
		int found = 0;
		
		for(EducationBackground EB : EBlist) {
			if(EB.getUser_id() == user_id) {
				
				String degree = Helper.readString(String.format("Degree given(%s) *type '0' to unchange > ", EB.getDegree()));
				EB.setDegree(degree.equals("0") ? EB.getDegree() : degree);
				
				String institution = Helper.readString(String.format("Education institution(%s) *type '0' to unchange > ", EB.getInstitution()));
				EB.setInstitution(institution.equals("0") ? EB.getInstitution() : institution);
				
				int year_graduated = Helper.readInt(String.format("Year graduated(%d) *type '0' to unchange > ", EB.getYear_graduated()));
				EB.setYear_graduated((year_graduated == 0) ? EB.getYear_graduated() : year_graduated);
				
				found = 1;
				if(found == 1) {
					System.out.println("\nUpdated successfully");
					break;
				}
			}
		}
		
		return (found == 1) ? true : false;
		

	}
	
	
	public static boolean updateEducationBackgroundTest(int user_id,ArrayList<EducationBackground> EBlist,String degree, String institution, int year_graduated ) {
		
		int found = 0;
		
		for(EducationBackground EB : EBlist) {
			if(EB.getUser_id() == user_id) {
				
				EB.setDegree(degree.equals("0") ? EB.getDegree() : degree);
				EB.setInstitution(institution.equals("0") ? EB.getInstitution() : institution);				
				EB.setYear_graduated((year_graduated == 0) ? EB.getYear_graduated() : year_graduated);
				
				found = 1;
				if(found == 1) {
					System.out.println("\nUpdated successfully");
					break;
				}
			}
		}
		
		return (found == 1) ? true : false;
		

	}
	
	public static void deleteAccount(int user_id,ArrayList<User> userList, ArrayList<Profile> profileList, ArrayList<EducationBackground> EBList) {
		
		userList.remove(user_id - 1);
		profileList.remove(user_id -1);
		
		if(EBList.get(user_id - 1) != null) {
			EBList.remove(user_id -1);
		}
		
		
		System.out.println("Deleted successfully");
		System.out.println("Redirecting to Registration page...");
	}
	
	public static void AssessmentMenu() {
		System.out.println("-Management Assessment-");
		Helper.line(150, "-");
		System.out.println("1. Add Assessment");
		System.out.println("2. View Assessment");
		System.out.println("1. Delete Assessment");
		Helper.line(150, "-");
	}

	public static Assessment getInputOfAssessment() {
		String filePattern = "\\w*(\\.(txt))";
		Assessment newassessment = null;

		Integer id = Helper.readInt("Enter the ID of the assessment > ");
		String type = Helper.readString("Enter the type of assessment > ");
		String topic = Helper.readString("Enter the topic related to assessment > ");
		String industry = Helper.readString("Enter the related industry > ");
		String career = Helper.readString("Enter the related career prospect > ");
		String fileName = Helper.readStringRegEx("Enter the complete name of the file > ", filePattern);

		newassessment = new Assessment(id, type, topic, industry, career, new File(fileName));

		return newassessment;

	}

	public static void AddAssessment(ArrayList<Assessment> assessmentList, Assessment at) {

		Assessment ass;

		Helper.line(150, "=");
		System.out.println("Addition of Assessment");
		Helper.line(150, "=");
		System.out.println("");

		for (int i = 0; i < assessmentList.size(); i++) {
			ass = assessmentList.get(i);

			if (ass.getAssessment_id() == at.getAssessment_id()) {
				System.out.println("The Assessment is already existed");
				return;
			}

		}
		if ((at.getAssessmentType().isEmpty()) || (at.getTopic().isEmpty()) || (at.getIndustry().isEmpty())
				|| (at.getCareer_path().isEmpty())) {
			System.out.println("The Info of Assessment is missing!");
			return;

		}

		assessmentList.add(at);

		System.out.println("The new assessment is successfully added");
		at.display();

	}

	public static String ViewAssessment(ArrayList<Assessment> assessmentList) {
		Helper.line(150, "=");
		System.out.println("List of Assessments");
		Helper.line(150, "=");
		System.out.println("");

		String output = String.format("%-5s %-25s %-25s %-25s %-30s %-30s\n\n", "ID", "TYPE", "TOPIC", "INDUSTRY",
				"CAREER PROSPECT", "FILE NAME");

		for (Assessment a : assessmentList) {
			output += String.format("%-5d %-25s %-25s %-25s %-30s %-30s\n", a.getAssessment_id(), a.getAssessmentType(),
					a.getTopic(), a.getIndustry(), a.getCareer_path(), a.getAssessment());
		}

		System.out.println(output);
		return output;
	}

	public static boolean DeleteAssessment(ArrayList<Assessment> assessmentList, Integer id) {

		Helper.line(150, "=");
		System.out.println("Deletion of Assessment");
		Helper.line(150, "=");
		System.out.println("");

		boolean success = false;
		int deletedAssessment = 0;

		for (int i = 0; i < assessmentList.size(); i++) {
			if (id == assessmentList.get(i).getAssessment_id()) {
				success = true;
				deletedAssessment = i;
			}
		}

		if (success) {
			assessmentList.remove(deletedAssessment);
			System.out.println("\nThe Assessment is successfully deleted!\n");

		} else {
			System.out.println("\nThe Assessment ID entered is Invalid.\n");
}

		

		return success;
	}


}


