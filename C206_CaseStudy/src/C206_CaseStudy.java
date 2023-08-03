import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class C206_CaseStudy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
	
	public static void start() {
		// custom users
		User admin = new User(1, "Admin", "admin@gmail.com", "admin", "lol1");
		User user1 = new User(2, "john doe1", "john1@sgmail.com", "user", "lol123");
		User user2 = new User(3, "john doe2", "john2@gmail.com", "user", "lol123");
		
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

		ArrayList<EducationBackground> EducationBackgroundList = new ArrayList<EducationBackground>(Arrays.asList(adminEB,user1EB,user2EB));
		
		// custom Assessments
		
		Assessment a1 = new Assessment("Work Sample Test","Testing Flights","Aerospace","Aeronautical Engineer",new File("areo.txt"));
		Assessment a2 = new Assessment("Personality Test","Repairing Computers","Computer Technology","Computer Engineer",new File("cs.txt"));
		Assessment a3 = new Assessment("Hard Skill Test","General Construction","Construction","Brickmason",new File("construction.txt"));
		
		ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();
		
		assessmentList.add(a1);
		assessmentList.add(a2);
		assessmentList.add(a3);
		
	}
	
	public static boolean validateEmailAddress(String email) {	
		String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    return email.matches(emailPattern);
	}
	
	
	public static boolean register(ArrayList<User> usersList, String email, String password1, String password2, ArrayList<Profile> profileList) {
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
				// have to redirect to create profile

				createProfile(user.getUser_id(), profileList);
				return true;
			}
			
		}else {
			System.out.println("Password or email is invalid.");
		}
		// default return false
		return false;
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
	
	public static Profile createProfile(int user_id, ArrayList<Profile> profileList) {
		System.out.println("Redirecting to Profile creation...");
		
		Helper.line(70, "*");
		System.out.println("Let's create your profile");
		Helper.line(70, "*");
		
		
		int profile_id = profileList.size() + 1;
		int contact_info = Helper.readInt("Enter your contact information > ");
		String dob = Helper.readString("Enter your Date of Birth(dd/mm/yyyy) > ");
		
		Profile newProfile = new Profile(profile_id, user_id, contact_info, dob);
		
		
		System.out.println("Profile created successfully");
		
		return newProfile;
	}
	
	
	// user only
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
				
			}
		}
		return (found == 1) ? true : false;

	}
	
	public static boolean createEducationBackground(int user_id, ArrayList<EducationBackground> EBlist ) {
		
		if(EBlist.size() == 0) {
			
			return false;
		}
		else {
			int educationBackground_id = EBlist.size() + 1;
			String degree = Helper.readString("Degree given > ");
			String institution = Helper.readString("Education institution > ");
			int year_graduated = Helper.readInt("Year graduated > ");
			
			EducationBackground EB = new EducationBackground(educationBackground_id,  user_id, degree, institution, year_graduated);
		}
		return true;
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
				
			}
		}
		
		return (found == 1) ? true : false;
		
		
	}

	public void AddAssessment(ArrayList<Assessment> a) {
		
		
	}
}


