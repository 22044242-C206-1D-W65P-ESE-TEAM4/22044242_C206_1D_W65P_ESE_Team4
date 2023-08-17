import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class C206_CaseStudy {

	private static final int PROFILEMANAGEMENT = 1;
	private static final int VIEWPROFILE = 1;
	private static final int UPDATEPROFILE = 2;


	
	private static final int EDUCATIONBACKGROUNDMANAGEMENT = 2;
	private static final int VIEWEDUCATIONBACKGROUND = 1;
	private static final int UPDATEEDUCATIONBACKGROUND = 2;
	
	private static final int DELETEACCOUNTMANAGEMENT = 3;	
	
	
	
	// Refactoring
	private static final int ASSESSMENT_DELETE = 3;
	private static final int ASSESSMENT_VIEW = 2;
	private static final int ASSESSMENT_ADD = 1;
	private static final int ASSESSMENT_QUIT = 0;
	public static final int OPTION_ASSESSMENT = 4;
	public static final int OPTION_QUIT = 0;

	public static final int CAREERPATH_OPTION = 6;
	private static final int CAREERPATH_VIEW = 1;
	private static final int CAREERPATH_ADD = 2;
	private static final int CAREERPATH_DELETE = 3;

	//Refactoring (Xaviera Ong Ke Ning)
	private static final int OPTION_RESUME = 5;
	private static final int RESUME_ADD = 1;
	private static final int RESUME_VIEW = 2;
	private static final int RESUME_DELETE = 3;
	
	private static final int TEMPLATE1 = 1;
	private static final int TEMPLATE2 = 2;
	private static final int TEMPLATE3 = 3;

	

	public static final int CareerPathManagement = 6;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

	// Code starts from here
	public static void start() {

		  User currentUser = null;
		  ArrayList<Job_Opportunity> jobList = new ArrayList<>();
		  Job_Opportunity jobOpportunity = new Job_Opportunity(
				    "Software Engineer", // JobTitle
				    "Singapore",         // Location
				    5000.0,              // Min_Salary
				    8000.0,              // Max_Salary
				    "Java, Python",      // skills
				    "Develop software applications", // JobDetails
				    "XYZ Tech Solutions", // CompanyDetails
				    "Bachelor's degree in Computer Science", // qualifications
				    "2023-08-31"         // deadline
				);
		  jobList.add(jobOpportunity);

	
		// custom users
		User admin = new User(1, "Admin", "admin@gmail.com", "admin", "lol123");
		User user1 = new User(2, "john doe1", "john1@sgmail.com", "user", "lol123");
		User user2 = new User(3, "john doe2", "john2@gmail.com", "user", "lol123");
		User HR1 = new User(4, "Hr1", "Hr1@gmail.com", "HR", "lol123");

		//currentUser = admin;

		ArrayList<User> usersList = new ArrayList<User>(Arrays.asList(admin, user1, user2, HR1));

		// custom profiles
		Profile adminProfile = new Profile(1, 1, 12345678, "02/02/2002");
		Profile user1Profile = new Profile(2, 1, 22345678, "03/03/2003");
		Profile user2Profile = new Profile(3, 1, 32345678, "04/04/2004");
		Profile HR1Profile = new Profile(4, 1, 42345678, "05/05/2005");

		ArrayList<Profile> profileList = new ArrayList<Profile>(
				Arrays.asList(adminProfile, user1Profile, user2Profile));

		// custom Education backgrounds
		EducationBackground adminEB = new EducationBackground(1, 1, "Computer science", "NUS", 2022);
		EducationBackground user1EB = new EducationBackground(1, 1, "Art", "NTU", 2023);
		EducationBackground user2EB = new EducationBackground(1, 1, "Food sciences", "SIT", 2024);

		// Sprint 2 - haven't do yet
		ArrayList<EducationBackground> educationBackgroundList = new ArrayList<EducationBackground>(
				Arrays.asList(adminEB, user1EB, user2EB));

		// custom Assessments
		Assessment a1 = new Assessment(1, "Work Sample Test", "Testing Flights", "Aerospace", "Aeronautical Engineer",
				new File("areo.txt"));
		Assessment a2 = new Assessment(2, "Personality Test", "Repairing Computers", "Computer Technology",
				"Computer Engineer", new File("cs.txt"));
		Assessment a3 = new Assessment(3, "Hard Skill Test", "General Construction", "Construction", "Brickmason",
				new File("construction.txt"));

		ArrayList<Assessment> assessmentList = new ArrayList<Assessment>(Arrays.asList(a1, a2, a3));

		ViewAssessment(assessmentList);
		
		//custom Resumes
		String user1Description="Experienced software developer with a passion for crafting efficient and innovative solutions. "
						+ "Proficient in multiple programming languages and adept at collaborating in Agile environments. "
						+ "Track record of delivering high-quality code and driving project success. Eager to contribute technical expertise to a dynamic team.";
				
		String user2Description="Experienced software developer with a proven track record of delivering high-quality solutions in fast-paced environments."
						+ " Proficient in full-stack development, utilizing languages like Python, JavaScript, and Java. "
						+ "Expertise in designing and implementing efficient algorithms and data structures. "
						+ "Strong problem-solving skills and a collaborative mindset, demonstrated through successful cross-functional team projects. ";

		ArrayList<JobExperience> jbl = new ArrayList<JobExperience>();
		JobExperience jbe1 = new JobExperience("DBS","Software Tester","Aug 2020 - Sept 2023","Lead some projects");
		JobExperience jbe2 = new JobExperience("Smart Nation","Software Tester","Mar 2020 - Sept 2021","Projects leader");

		jbl=new ArrayList<JobExperience>(Arrays.asList(jbe1,jbe2));
		
		ResumeTemplate user1Resume= new ResumeTemplate(2,1,1,jbl,"GovTech Resume","John Doe 1",22345678,"john1@sgmail.com",user1Description);
		ResumeTemplate user2Resume= new ResumeTemplate(3,2,2,jbl,"Navy Resume","John Doe 2",32345678,"john2@gmail.com",user2Description);

		//add to resumeList
		ArrayList<ResumeTemplate> resumeList = new ArrayList<ResumeTemplate>(Arrays.asList(user1Resume,user2Resume));		

		
		// Career path list!!!
		CareerPath c1 = new CareerPath(1, 1, "Software Engineer", "Develops software applications",
				"High growth potential", "Programming skills");
		CareerPath c2 = new CareerPath(1, 2, "UI Designer", "Design user interface", "Understanding user behaviour",
				"communication skills");

		ArrayList<CareerPath> cpList = new ArrayList<>(Arrays.asList(c1, c2));
	
		int res = 10000;
		int AssessmentOption = 10000;

		// res = 0, means cancel
		while (res != OPTION_QUIT) {
			res = Menu(currentUser);

			if (res == OPTION_QUIT) {
				System.out.println("Thank for using the application, Goodbye!");
				break;
			}

			if (currentUser != null) {
				if (res == OPTION_QUIT) {
					System.out.println("Thank for using the application, Goodbye!");
					break;
				} else if (res == PROFILEMANAGEMENT) {
					
					ProfileManagement(currentUser, profileList, usersList);
				} else if (res == EDUCATIONBACKGROUNDMANAGEMENT) {
					EducationBackgroundManagement(educationBackgroundList, currentUser.getUser_id());
				} else if (res == DELETEACCOUNTMANAGEMENT) {
					deleteAccount(currentUser.getUser_id(), usersList, profileList, educationBackgroundList);
					currentUser = null;
					res = Menu(currentUser);

				} else if (res == OPTION_ASSESSMENT) {
					if (currentUser.getRole().equalsIgnoreCase("admin")) {

						// Refactoring
						Assessment.AssessmentMenu();
						AssessmentOption = Helper.readInt("Enter the option for managing Assessment > ");
						while (AssessmentOption != ASSESSMENT_QUIT) {

							if (AssessmentOption == ASSESSMENT_ADD) {

								Assessment.AddAssessment(assessmentList, Assessment.getInputOfAssessment());

							} else if (AssessmentOption == ASSESSMENT_VIEW) {
								Assessment.ViewAssessment(assessmentList);
							} else if (AssessmentOption == ASSESSMENT_DELETE) {
								Assessment.ViewAssessment(assessmentList);
								Integer ID = Helper.readInt("Enter the ID of the Assessment you wish to delete > ");
								Assessment.DeleteAssessment(assessmentList, ID);
							} else if (AssessmentOption == ASSESSMENT_QUIT) {
								System.out.println("Existing Assessment Management!");
							} else {
								System.out.println("Invalid Input!");
							}
							Assessment.AssessmentMenu();
							AssessmentOption = Helper.readInt("Enter the option for managing Assessment > ");

						}
					}
					// Handle HR options
					else if (currentUser.getRole().equalsIgnoreCase("HR")) {
						Job_Application_Menu();
						int hrRes = Helper.readInt("Enter an option > ");
						if (hrRes == 1) {
							CreateNewJob(jobList);
						} else if (hrRes == 2) {
							ManageAddedJob(jobList);
						} else if (hrRes == 3) {
							ViewAllJobOpportunities(jobList);
						} else if (hrRes == 0) {
							System.out.println("Exiting Job Application Menu.");
						} else {
							System.out.println("Invalid choice.");
						}
					} else {
						Assessment.ViewAssessment(assessmentList);
					}
				}
				else if (res == OPTION_RESUME )//resume
				{
					ResumeMenu();
					int resumeOption=Helper.readInt("Welcome to Resume Management, What would you like to do?> ");
					if (resumeOption==RESUME_ADD)
					{
						AddResume(currentUser.getUser_id(),resumeList,educationBackgroundList);
					}
					else if (resumeOption==RESUME_VIEW)
					{
						ViewResume(currentUser.getUser_id(),resumeList,educationBackgroundList);
					}
					else if (resumeOption==RESUME_DELETE)
					{
						DeleteResume(currentUser.getUser_id(),resumeList,educationBackgroundList);
					}
				}
				
				//refactoring
				else if(res == CAREERPATH_OPTION ) {
					CareerPathManagement(currentUser, cpList);

				}
			}

			if (currentUser == null) {
				String email = "";
				if (res == 1) {
					email = FormEmail(usersList, "register");
					String password1 = Helper.readString("Enter password >");
					String password2 = Helper.readString("Enter repeat-password>");
					String name = Helper.readString("What should we call you> ");
					currentUser = register(usersList, name, email, password1, password2, profileList, currentUser);

					educationBackgroundList.add(
							createEducationBackground(currentUser.getUser_id(), usersList, educationBackgroundList));
				} else if (res == 2) {
					email = FormEmail(usersList, "login");
					String password1 = Helper.readString("Enter password >");
					currentUser = login(usersList, email, password1);
				}
			}
			
		}
			
	}

	public static String FormEmail(ArrayList<User> usersList, String type) {
		// Email check
		boolean isEmailValid = false;
		String email = "";

		while (isEmailValid == false) {
			email = Helper.readString("Enter email > ");
			isEmailValid = validateEmailAddress(email, usersList, type);

			if (isEmailValid == false) {
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

		if (user == null) {
			System.out.println("1. Register");
			System.out.println("2. Login");
		}

		else {
			System.out.println("1. Profile Management");
			System.out.println("2. Education Background Management");
			System.out.println("3. Disable account");
			if (user.getRole().equalsIgnoreCase("admin")) {
				System.out.println("4. Manage Assessments");
			} else if (user.getRole().equalsIgnoreCase("HR")) {
				System.out.println("4. Manage Jobs");
			} else {
				System.out.println("4. View Assessments");
				
			}
			System.out.println("5. Resume Management");
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

		if (ans == VIEWPROFILE) {
			// System.out.println(user.getEmail());
			String output = user.displayUserInfo()
					+ String.format("%9s ", profileList.get(user.getUser_id()).getContact_info());
			System.out.println(output);

		} else if (ans == UPDATEPROFILE) {
			boolean isValid = updateProfile(user.getUser_id(), profileList, usersList);
		}
	}

	public static void EducationBackgroundManagement(ArrayList<EducationBackground> EducationBackgroundList, int id) {
		System.out.println("1. View Education Background");
		System.out.println("2. Update Education Background");

		int ans = Helper.readInt("Education Management > ");

		if (ans == 1) {
			viewEducationBackground(id, EducationBackgroundList);
		} else if (ans == 2) {
			updateEducationBackground(id, EducationBackgroundList);
		}

	}

	// Register a user
	public static User register(ArrayList<User> usersList, String name, String email, String password1,
			String password2, ArrayList<Profile> profileList, User currentUser) {
		if (password1.equals(password2)) {
			/*
			 * Roles: 1. user 2. admin 3.
			 */
			// String name = "user101";
			User user = new User(usersList.size() + 1, name, email, "user", password2);

			if (user != null) {

				System.out.println("\nUser registered successfully\n");

				// have to redirect to create profile

//				createProfile(user.getUser_id(), profileList);

				return user;
			}

		} else {
			System.out.println("Password is similar.");
		}
		// default return false
		return null;
	}

	// Login user
	public static User login(ArrayList<User> usersList, String email, String password) {
		int found = 0;
		for (User user : usersList) {
			if (validateEmailAddress(email, usersList, "login")) {
				// System.out.println(user.getEmail());

				if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
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

		while (isValid == false) {
			contact_info = Helper.readInt("Enter your contact information > ");
			isValid = validatePhoneNumber(contact_info);

			if (isValid == false) {
				System.out.println("Please input 8 characters");
			}

		}

		String dob = Helper.readString("Enter your Date of Birth(dd/mm/yyyy) > ");
		Profile newProfile = new Profile(profile_id, user_id, contact_info, dob);

		System.out.println("Profile created successfully");

		return newProfile;
	}

	// Profile management - Create
	public static Profile createProfileTest(int user_id, ArrayList<Profile> profileList, int contact_info, String dob) {
		int profile_id = profileList.size() + 1;
		boolean isValid = validatePhoneNumber(contact_info);
		int errors = 0;

		isValid = validatePhoneNumber(contact_info);
		if (isValid == false) {
			System.out.println("Please input 8 characters");
			errors += 1;
		}

		if (errors < 0) {
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

		for (Profile profile : profileList) {
			if (profile.getUser_id() == user_id) {
				User user = userList.get(user_id - 1);

				String name = Helper.readString(String.format("Name(%s) *type '0' to unchange > ", user.getName()));
				user.setName(name.equals("0") ? user.getName() : name);

				String email = Helper.readString(String.format("Email(%s) *type '0' to unchange > ", user.getEmail()));
				user.setEmail(email.equals("0") ? user.getEmail() : email);

				int contact_info = Helper.readInt(
						String.format("Contact Number(%d) *type '0' to unchange > ", profile.getContact_info()));
				profile.setContact_info(contact_info == 0 ? profile.getContact_info() : contact_info);

				String dob = Helper.readString(String.format("Dob(%s) *type '0' to unchange > ", profile.getDob()));
				profile.setDob(dob.equals("0") ? profile.getDob() : dob);

				System.out.println("Updated successfully.");

				found = 1;

				if (found == 1) {
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

		if (!email.equals("0") || contact_info != 0) {
			if (validateEmailAddress(email, userList, "login") == false || validatePhoneNumber(contact_info) == false) {
				return false;
			}
		}

		int found = 0;

		for (Profile profile : profileList) {
			if (profile.getUser_id() == user_id) {
				User user = userList.get(user_id - 1);

				user.setName(name.equals("0") ? user.getName() : name);
				user.setEmail(email.equals("0") ? user.getEmail() : email);
				profile.setContact_info(contact_info == 0 ? profile.getContact_info() : contact_info);
				profile.setDob(dob.equals("0") ? profile.getDob() : dob);

				System.out.println("Updated successfully.");

				found = 1;

				if (found == 1) {
					break;
				}

			}
		}
		return (found == 1) ? true : false;

	}

	// Email Address validation
	public static boolean validateEmailAddress(String email, ArrayList<User> userList, String type) {

		String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

		if (type.equalsIgnoreCase("register")) {
			for (User user : userList) {
				if (user.getEmail().equalsIgnoreCase(email)) {
					System.out.println("The email has already been used");
					return false;
				}
			}
		}

		return email.matches(emailPattern);

	}

	// Password validation
	public static boolean validatePhoneNumber(int phone) {
		boolean phoneValid = Integer.toString(phone).length() == 8;
		return phoneValid;
	}

	public static void viewEducationBackground(int user_id, ArrayList<EducationBackground> EBList) {
		String output = String.format("\n%-10s %-20s %-20s\n", "Degree", "Institution", "Year Graduated");
		EducationBackground eb = EBList.get(user_id - 1);
		output += String.format("%-10s %-20s %-20d", eb.getDegree(), eb.getInstitution(), eb.getYear_graduated());
		System.out.println(output);
	}

	public static EducationBackground createEducationBackground(int user_id, ArrayList<User> userList,
			ArrayList<EducationBackground> EBlist) {

		Helper.line(70, "*");
		System.out.println("Tell us more about your education background");
		Helper.line(70, "*");

		if (EBlist.size() == 0) {

			return null;
		}

		else {
			int educationBackground_id = EBlist.size() + 1;
			String degree = Helper.readString("Degree given > ");
			String institution = Helper.readString("Education institution > ");
			int year_graduated = Helper.readInt("Year graduated > ");

			EducationBackground EB = new EducationBackground(educationBackground_id, user_id, degree, institution,
					year_graduated);
			System.out.println("\nThank you for your cooperation");

			return EB;
		}

	}

	public static EducationBackground createEducationBackgroundTest(int user_id, ArrayList<User> userList,
			ArrayList<EducationBackground> EBlist, String degree, String institution, int year_graduated) {

		Helper.line(70, "*");
		System.out.println("Tell us more about your education background");
		Helper.line(70, "*");
		EducationBackground EB = null;

		int educationBackground_id = EBlist.size() + 1;

		if (user_id == userList.size()) {
			EB = new EducationBackground(educationBackground_id, user_id, degree, institution, year_graduated);
			return EB;
		}

		System.out.println("\nThank you for your cooperation");

		return null;

	}

	public static boolean updateEducationBackground(int user_id, ArrayList<EducationBackground> EBlist) {

		int found = 0;

		for (EducationBackground EB : EBlist) {
			if (EB.getUser_id() == user_id) {

				String degree = Helper
						.readString(String.format("Degree given(%s) *type '0' to unchange > ", EB.getDegree()));
				EB.setDegree(degree.equals("0") ? EB.getDegree() : degree);

				String institution = Helper.readString(
						String.format("Education institution(%s) *type '0' to unchange > ", EB.getInstitution()));
				EB.setInstitution(institution.equals("0") ? EB.getInstitution() : institution);

				int year_graduated = Helper
						.readInt(String.format("Year graduated(%d) *type '0' to unchange > ", EB.getYear_graduated()));
				EB.setYear_graduated((year_graduated == 0) ? EB.getYear_graduated() : year_graduated);

				found = 1;
				if (found == 1) {
					System.out.println("\nUpdated successfully");
					break;
				}
			}
		}

		return (found == 1) ? true : false;

	}

	public static boolean updateEducationBackgroundTest(int user_id, ArrayList<EducationBackground> EBlist,
			String degree, String institution, int year_graduated) {

		int found = 0;

		for (EducationBackground EB : EBlist) {
			if (EB.getUser_id() == user_id) {

				EB.setDegree(degree.equals("0") ? EB.getDegree() : degree);
				EB.setInstitution(institution.equals("0") ? EB.getInstitution() : institution);
				EB.setYear_graduated((year_graduated == 0) ? EB.getYear_graduated() : year_graduated);

				found = 1;
				if (found == 1) {
					System.out.println("\nUpdated successfully");
					break;
				}
			}
		}

		return (found == 1) ? true : false;

	}

	public static boolean deleteAccount(int user_id, ArrayList<User> userList, ArrayList<Profile> profileList,
			ArrayList<EducationBackground> EBList) {

		userList.remove(user_id - 1);
		profileList.remove(user_id - 1);

		if (EBList.get(user_id - 1) != null) {
			EBList.remove(user_id - 1);
		}

		System.out.println("Deleted successfully");
		System.out.println("Redirecting to Registration page...");

		return true;
	}


//	// -----------Job Application (HR) -------------
//	public static void Job_Application_Menu() {
//		Helper.line(70, "=");
//		System.out.println("Job Application Menu");
//		Helper.line(70, "=");
//		System.out.println("1. Add Job");
//		System.out.println("2. Manage Added Job");
//		System.out.println("3. View All Job Opportunities");
//
//		System.out.println("0. Quit");
//		Helper.line(70, "=");
//	}

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

		Assessment.setHeader("Addition of Assessment");

		System.out.println("");

		for (int i = 0; i < assessmentList.size(); i++) {

			// Refactoring
			int assessment_id = assessmentList.get(i).getAssessment_id();

			if (assessment_id == at.getAssessment_id()) {
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

		Assessment.setHeader("List of Assessments");

		System.out.println("");

		String output = String.format("%-5s %-25s %-25s %-25s %-30s %-30s\n\n", "ID", "TYPE", "TOPIC", "INDUSTRY",
				"CAREER PROSPECT", "FILE NAME");

		for (Assessment a : assessmentList) {
			// Refactroing
			output += String.format("%-140s\n", a.toString());
		}

		System.out.println(output);
		return output;
	}

	public static boolean DeleteAssessment(ArrayList<Assessment> assessmentList, Integer id) {

		Assessment.setHeader("Deletion of Assessment");

		System.out.println("");

		boolean success = false;
		int deletedAssessment = 0;

		for (int i = 0; i < assessmentList.size(); i++) {
			// Refactoring
			int assessment_id = assessmentList.get(i).getAssessment_id();
			if (id == assessment_id) {
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
	
	//-----------Job Application (HR) -------------
		public static void Job_Application_Menu() {
			Helper.line(70, "=");
		    System.out.println("Job Application Menu");
		    Helper.line(70, "=");
		    System.out.println("1. Add Job");
		    System.out.println("2. Manage Added Job");
		    System.out.println("3. View All Job Opportunities");

		    System.out.println("0. Quit");
		    Helper.line(70, "=");
			}
		
		
	

	public static Job_Opportunity CreateNewJob(ArrayList<Job_Opportunity> JobList) {
		try {
			Helper.line(50, "=");
			System.out.println("Please enter the following information");
			Helper.line(50, "=");

			String JobTitle = Helper.readString("Please enter your JobTitle: ");
			String Location = Helper.readString("Please enter your company's Location: ");
			double Min_Salary = Helper.readDouble("Enter the minimum salary: ");
			double Max_Salary = Helper.readDouble("Enter Maximum salary: ");
			String skills = Helper.readString("Enter the skills needed: ");
			String JobDetails = Helper.readString("Enter Job Details: ");
			String CompanyDetails = Helper.readString("Enter the company's details: ");
			String qualifications = Helper.readString("Enter the qualification needed for this job: ");
			String deadline = Helper.readString("Enter the deadline of this job Application: ");

			for (Job_Opportunity job : JobList) {
				if (job.getJobTitle().equalsIgnoreCase(JobTitle)) {
					System.out.println("Job opportunity already exists.");
					return null; // Return here if the job opportunity already exists
				}
			}

			Job_Opportunity newJob = new Job_Opportunity(JobTitle, Location, Min_Salary, Max_Salary, skills, JobDetails,
					CompanyDetails, qualifications, deadline);
			JobList.add(newJob);
			System.out.println("Job opportunity successfully added.");
			return newJob; // Return the newly created job opportunity

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			return null; // Return null if an error occurs
		}
	}
	public static void ViewAllJobOpportunities(ArrayList<Job_Opportunity> jobList) {
		System.out.println("List of All Job Opportunities:");
		for (Job_Opportunity job : jobList) {
			job.displayJobInfo();
		}
	}
	public static void deleteJob(ArrayList<Job_Opportunity> jobList, String jobTitle) {
		for (int i = 0; i < jobList.size(); i++) {
			if (jobList.get(i).getJobTitle().equalsIgnoreCase(jobTitle)) {
				String confirm = Helper
						.readString("Are you sure you want to delete job opportunity '" + jobTitle + "'? (yes/no): ");
				if (confirm.equalsIgnoreCase("yes")) {
					jobList.remove(i);
					System.out.println("Job opportunity '" + jobTitle + "' has been successfully deleted.");
				} else {
					System.out.println("Deletion of job opportunity '" + jobTitle + "' cancelled.");
				}
				break;
			}
		}
	}
	
	
	public static void ManageAddedJob(ArrayList<Job_Opportunity> JobList) {
		while (true) {
			String jobTitle = Helper.readString("Enter the job title to manage (or type 'exit' to quit): ");
			if (jobTitle.equalsIgnoreCase("exit")) {
				System.out.println("Exiting job management.");
				break;
				}
			boolean found = false;
			for (Job_Opportunity job : JobList) {
				if (job.getJobTitle().equalsIgnoreCase(jobTitle)) {
					found = true;
					deleteJob(JobList, jobTitle); // Call the deleteJob method
					break;
				}
			}

			if (!found) {
				System.out.println("Job opportunity '" + jobTitle + "' not found.");
			}
		}
	}

	
	public static void ResumeMenu() 
	{
		System.out.println("1. Add resume");
		System.out.println("2. View resume");
		System.out.println("3. Delete resume");
		Helper.line(50, "=");
	}
	
	//Refactoring (Xaviera Ong Ke Ning)
	public static void ResumeTemplateMenu()
	{
		Helper.line(50, "=");
		System.out.println("CHOOSE TEMPLATE");
		Helper.line(50, "=");
		System.out.println("1. Chronological resume");
		System.out.println("2. Functional resume");
		System.out.println("3. Combination resume");
		Helper.line(50, "=");
	}

		
	public static boolean AddResume(int userID,ArrayList<ResumeTemplate> resumeList,ArrayList<EducationBackground> EBlist)
	{	
		//Refactoring (Xaviera Ong Ke Ning)
		ResumeTemplateMenu();
		
		int templateOption=Helper.readInt("Choose a template> ");
		userID=Helper.readInt("Enter your user ID> ");
				
		if (templateOption == TEMPLATE1)
		{
			Helper.line(50, "=");
			System.out.println("Building resume...");
			Helper.line(50, "=");

			int resumeID = resumeList.size()+1;
			String title=Helper.readString("Resume Title> ");
			String name=Helper.readString("Your full name>");
			int phoneNum=Helper.readInt("Your contact number> ");
			String email=Helper.readString("Your email address> ");
			String description=Helper.readString("Short introduction about yourself> ");
			
			//employment 
			Helper.line(50, "=");
			System.out.println("Employment History");
			Helper.line(50, "=");
			
			String company=Helper.readString("Company name> ");
			String position=Helper.readString("Position> ");
			String period=Helper.readString("Employement period> ");
			String achievements=Helper.readString("Achievements> ");
			
			ArrayList<JobExperience> jbl = new ArrayList<JobExperience>();
			JobExperience jbe = new JobExperience(company, position, period, achievements);
			
			jbl.add(jbe);
	
			
			//createEducationBackground(,EBlist,userList);
			Helper.line(50, "=");
			System.out.println("Education History");
			Helper.line(50, "=");
			
			String degree = Helper.readString("Degree given > ");
			String institution = Helper.readString("Education institution > ");
			int year_graduated = Helper.readInt("Year graduated > ");

			
			ResumeTemplate rs=new ResumeTemplate(userID,resumeID,templateOption,jbl,title,name,phoneNum,email,description);
			EducationBackground eb=new EducationBackground(degree,institution,year_graduated);
			
			resumeList.add(rs);

			EBlist.add(eb);
						
			rs.display1();
			
			String output = String.format("\n%-20s %-15s %-15s %-10s\n", "Company", "Position", "Emplyement Period", "Achievements");
			output += String.format("%-20s %-15s %-15s %-10s\n",company,position,period,achievements);
			
			output += String.format("\n%-20s %-12s %-10s\n", "Degree", "Institution", "Year Graduated");
			output += String.format("%-20s %-12s %-10d\n", eb.getDegree(), eb.getInstitution(), eb.getYear_graduated());
			System.out.println(output);	

			//return true;

		}
		else if (templateOption == TEMPLATE2)
		{

			Helper.line(50, "=");
			System.out.println("Building resume...");
			Helper.line(50, "=");
			
			int resumeID= resumeList.size()+1;
			String title=Helper.readString("Resume Title> ");
			String name=Helper.readString("Your full name>");
			int phoneNum=Helper.readInt("Your contact number> ");
			String email=Helper.readString("Your email address> ");
			String description=Helper.readString("Brief summary of your skills> ");
			
			//employment 
			Helper.line(50, "=");
			System.out.println("Employment History");
			Helper.line(50, "=");
			String company=Helper.readString("Company name> ");
			String position=Helper.readString("Position> ");
			String period=Helper.readString("Employement period> ");
			String achievements=Helper.readString("Achievements> ");
			
			ArrayList<JobExperience> jbl = new ArrayList<JobExperience>();
			JobExperience jbe = new JobExperience(company, position, period, achievements);
			
			jbl.add(jbe);
			
			//createEducationBackground(,EBlist,userList);
			Helper.line(50, "=");
			System.out.println("Education History");
			Helper.line(50, "=");
			String degree = Helper.readString("Degree given > ");
			String institution = Helper.readString("Education institution > ");
			int year_graduated = Helper.readInt("Year graduated > ");

			
			ResumeTemplate rs=new ResumeTemplate(userID,resumeID,templateOption,jbl,title,name,phoneNum,email,description);
			EducationBackground eb=new EducationBackground(degree,institution,year_graduated);
			
		
			resumeList.add(rs);

			EBlist.add(eb);

			rs.display2();
						
			String output = String.format("\n%-20s %-15s %-15s %-10s\n", "Company", "Position", "Emplyement Period", "Achievements");
			output += String.format("%-20s %-15s %-15s %-10s\n",company,position,period,achievements);
			
			output += String.format("\n%-20s %-12s %-10s\n", "Degree", "Institution", "Year Graduated");
			output += String.format("%-20s %-12s %-10d\n", eb.getDegree(), eb.getInstitution(), eb.getYear_graduated());
			System.out.println(output);	

			//return true;
			
		}
		
		else if(templateOption == TEMPLATE3)
		{			
			Helper.line(50, "=");
			System.out.println("Building resume...");
			Helper.line(50, "=");
			
			int resumeID= resumeList.size()+1;
			String title=Helper.readString("Resume Title> ");
			String name=Helper.readString("Your full name>");
			int phoneNum=Helper.readInt("Your contact number> ");
			String email=Helper.readString("Your email address> ");
			String description=Helper.readString("Brief summary of your skills> ");
			
			//employment 
			Helper.line(50, "=");
			System.out.println("Employment History");
			Helper.line(50, "=");
			String company=Helper.readString("Company name> ");
			String position=Helper.readString("Position> ");
			String period=Helper.readString("Employement period> ");
			String achievements=Helper.readString("Achievements> ");
			
			
			ArrayList<JobExperience> jbl = new ArrayList<JobExperience>();
			JobExperience jbe = new JobExperience(company, position, period, achievements);
			
			jbl.add(jbe);
			
			//createEducationBackground(,EBlist,userList);
			Helper.line(50, "=");
			System.out.println("Education History");
			Helper.line(50, "=");
			String degree = Helper.readString("Degree given > ");
			String institution = Helper.readString("Education institution > ");
			int year_graduated = Helper.readInt("Year graduated > ");
			
			ResumeTemplate rs=new ResumeTemplate(userID,resumeID,templateOption,jbl,title,name,phoneNum,email,description);
			EducationBackground eb=new EducationBackground(degree,institution,year_graduated);
			
			resumeList.add(rs);

			EBlist.add(eb);
						
			rs.display3();
			
			String output = String.format("\n%-20s %-15s %-15s %-10s\n", "Company", "Position", "Emplyement Period", "Achievements");
			output += String.format("%-20s %-15s %-15s %-10s\n",company,position,period,achievements);
			
			output += String.format("\n%-20s %-12s %-10s\n", "Degree", "Institution", "Year Graduated");
			output += String.format("%-20s %-12s %-10d\n", eb.getDegree(), eb.getInstitution(), eb.getYear_graduated());
			System.out.println(output);	
											
		}
		System.out.println("Added successfully!");
		return true;
	}
		
	
	public static boolean ViewResume(int user_id, ArrayList<ResumeTemplate> resumeList,ArrayList<EducationBackground> EBlist)
	{		
		boolean isFound=false;
		
		int resume_id = Helper.readInt("Enter resume ID > ");
		
		if ((resumeList!=null) && (EBlist!=null))
		{
			for(ResumeTemplate rs : resumeList) 
			{
				if(rs.getUserID() == user_id) 
				{
					//Refactoring (Xaviera Ong Ke Ning)
					int rs_ResumeID = rs.getResumeID();

					if(rs_ResumeID == resume_id) 
					{
						//Refactoring (Xaviera Ong Ke Ning)
						int rs_TemplateID = rs.getTemplateID();
						
						if(rs_TemplateID == 1)
						{
							rs.display1();
						}
						else if (rs_TemplateID == 2)
						{
							rs.display2();
						}
						else if (rs_TemplateID == 3)
						{
							rs.display3();
						}
						
						EducationBackground EB = EBlist.get(user_id - 1);
						
						
						String output = String.format("\n%-20s %-12s %-10s\n", "Degree", "Institution", "Year Graduated");
						output += String.format("%-20s %-12s %-10d\n", EB.getDegree(), EB.getInstitution(), EB.getYear_graduated());
						System.out.println(output);
						
						ArrayList<JobExperience> we = rs.getWorkExperience();
						for (JobExperience experience:we)
						{
							experience.displayWorkExperience();
						}
						return true;
					}
				}
				
			}
			
		}
		
		if (!isFound)
		{
			System.out.println("Resume does not exist!");	
		}
		return false;
		
	}
	
	
	public static boolean DeleteResume(int userID, ArrayList<ResumeTemplate> resumeList,ArrayList<EducationBackground> EBlist)
	{
		Helper.line(50, "=");
		System.out.println("Delete Resume");
		Helper.line(50, "=");
						
		int resumeID=Helper.readInt("Enter resume ID> ");
		
		for (int i=0;i<resumeList.size();i++)
		{
			//Refactoring(Xaviera Ong Ke Ning)
			int ResumeList_ResumeID = resumeList.get(i).getResumeID();
			if (ResumeList_ResumeID == resumeID)
			{
				//Refactoring(Xaviera Ong Ke Ning)

				int ResumeList_TemplateID = resumeList.get(i).getTemplateID();
				if(ResumeList_TemplateID == 1)
				{
					resumeList.get(i).display1();

				}
				else if (ResumeList_TemplateID == 2)
				{
					resumeList.get(i).display2();
				}
				else if (ResumeList_TemplateID == 3)
				{
					resumeList.get(i).display3();
				}
				resumeList.remove(i);
				EBlist.remove(i);
				System.out.println("\nDelete successfully!");
			
			}
		}
		return true;
						
	}
	
	public static void CareerPathManagement(User currentUser, ArrayList<CareerPath> cpList) {
		System.out.println("1. View Career Path");
		System.out.println("2. Add New Career Path");
		System.out.println("3. Delete Career Path");

		int op = Helper.readInt("CareerPath Management > "); // You should have a Helper class with this method

		if (op == CAREERPATH_VIEW) {
			viewCareerPath(currentUser, cpList);
		} else if (op == CAREERPATH_ADD) {
			addNewCareerPath(currentUser, cpList);
		} else if (op == CAREERPATH_DELETE ) {
			deleteCareerPath(cpList);
		}
	}
	
	public static String viewCareerPath(User currentUser, ArrayList<CareerPath> cpList) {
		// CareerPath selectedCareerPath = getCareerPathById(cpList, careerPathId);

		for (CareerPath career : cpList) {
			int user_id = career.getUser_id();
			int currentuser_id = currentUser.getUser_id();
			if (currentuser_id == user_id) {
				Helper.line(50, "=");
				System.out.println("Selected Career Path for :" + career.getCareerPathId());
				System.out.println("Title: " + career.getCareerTitle());
				System.out.println("Description: " + career.getJobDescription());
				System.out.println("Growth Prospects: " + career.getGrowthProspects());
				System.out.println("Required Skills: " + career.getRequiredSkills());
				
			}
		}
		return null;
	}
	
	public static CareerPath addNewCareerPath(User currentUser, ArrayList<CareerPath> cpList) {

		int newId = cpList.size() + 1;
		Helper.line(50, "=");
		String newTitle = Helper.readString("Career Title: ");
		String newDescription = Helper.readString("A description of the new career path: ");
		String newGrowthProspects = Helper.readString("Growth Prospects: ");
		String newRequiredSkills = Helper.readString("Required skills for this path: ");

		CareerPath cp = getCareerPathById(cpList, newId);

		if (cp == null) {

			// Create a new CareerPath instance
			CareerPath newCareerPath = new CareerPath(currentUser.getUser_id(), newId, newTitle, newDescription,
					newGrowthProspects, newRequiredSkills);
			cpList.add(newCareerPath);

			// Inform the user about the successful addition
			Helper.line(50, "=");
			System.out.println("New career path added !");
			Helper.line(50, "=");

			return newCareerPath;

		}

		return null;
	}
	
	public static CareerPath getCareerPathById(ArrayList<CareerPath> cpList, int id) {
	
		for (CareerPath cp : cpList) {
			if (cp.getCareerPathId() == id) {
				return cp;
			}
		}
		return null;
	}
	
	public static void deleteCareerPath(ArrayList<CareerPath> cpList) {
		int idToDelete = Helper.readInt("Enter the ID of the career path to delete:"); // Assuming the user enters the
																						// ID to delete
		CareerPath pathToDelete = getCareerPathById(cpList, idToDelete);

		if (pathToDelete != null) {
			cpList.remove(pathToDelete);
			System.out.println("Career Path with ID " + idToDelete + " has been deleted.");
		} else {
			System.out.println("Career Path with ID " + idToDelete + " not found.");
		}
	}
	
}