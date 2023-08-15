import java.util.ArrayList;

//22002464 Xaviera Ong Ke Ning

public class ResumeTemplate {
	private int userID;
	private int resumeID;
	private String resumeTitle;
	private String fullName;
	private int contactInfo;
	private String emailAddress;
	private String description;
	private String education;
	
	private ArrayList<JobExperience> workExperience;
	
	private String skills;
	private String achievements;
	private int templateID;


	public ResumeTemplate(int userID,int resumeID,int templateID, ArrayList<JobExperience> workExperience, String resumeTitle, String fullName, int contactInfo, String emailAddress, String description)
	{
		this.userID = userID;
		this.resumeID = resumeID;
		this.templateID=templateID;
		this.workExperience = workExperience;
		this.resumeTitle = resumeTitle;
		this.fullName = fullName;
		this.contactInfo = contactInfo;
		this.emailAddress = emailAddress;
		this.description = description;
		
	} 
	
	public ResumeTemplate
	(int userID, int resumeID, String resumeTitle, String fullName, int contactInfo, String emailAddress,
			String description, String education, ArrayList<JobExperience> workExperience, String skills, String achievements,int templateID) 
	{
		//super();
		this.userID = userID;
		this.resumeID = resumeID;
		this.resumeTitle = resumeTitle;
		this.fullName = fullName;
		this.contactInfo = contactInfo;
		this.emailAddress = emailAddress;
		this.description = description;
		this.education = education;
		this.workExperience = workExperience;
		this.skills = skills;
		this.achievements = achievements;
		this.templateID=templateID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getResumeID()
	{
		return resumeID;
	}
	
	public String getResumeTitle()
	{
		return resumeTitle;
	}

	public void setResumeTitle(String resumeTitle)
	{
		this.resumeTitle = resumeTitle;
	}

	public String getFullName() 
	{
		return fullName;
	}

	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}

	public int getContactInfo()
	{
		return contactInfo;
	}

	public void setContactInfo(int contactInfo) 
	{
		this.contactInfo = contactInfo;
	}

	public String getEmailAddress() 
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) 
	{
		this.emailAddress = emailAddress;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getEducation()
	{
		return education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	public ArrayList<JobExperience> getWorkExperience()
	{
		return workExperience;
	}

	public void setWorkExperience(ArrayList<JobExperience> workExperience)
	{
		this.workExperience = workExperience;
	}

	
	
	
	public String getSkills() 
	{
		return skills;
	}

	public void setSkills(String skills) 
	{
		this.skills = skills;
	}

	public String getAchievements() 
	{
		return achievements;
	}

	public void setAchievements(String achievements) 
	{
		this.achievements = achievements;
	}	

	public int getTemplateID() {
		return templateID;
	}

	public void display1() //chronological
	{
		templateID=1;
		Helper.line(50, "-");
		System.out.println("Display Resume: "+resumeTitle );
		Helper.line(50, "-");
		String output="";
		output+=String.format("%-20s %-10s\n", "Resume ID: ",getResumeID());
		output+=String.format("%-20s %-10s\n", "Full Name: ",getFullName());
		output+=String.format("%-20s %-10d\n", "Contact Number: ",getContactInfo());
		output+=String.format("%-20s %-10s\n\n", "Email Address: ",getEmailAddress());
		output+=String.format("%s\n%s", "Short introduction about yourself: ",getDescription());
		System.out.println(output);
	}
	
	public void display2() //functional
	{
		templateID=2;
		Helper.line(50, "-");
		System.out.println("Display Resume: "+resumeTitle );
		Helper.line(50, "-");
		System.out.println("");
		String output="";
		output+=String.format("%-20s %-10s\n", "Resume ID: ",getResumeID());
		output+=String.format("%-20s %-10s\n", "Full Name: ",fullName);
		output+=String.format("%-20s %-10d\n", "Contact Number: ",contactInfo);
		output+=String.format("%-20s %-10s\n\n", "Email Address: ",getEmailAddress());
		output+=String.format("%s\n%s", "Short summary about your qualifications: ",description);
		System.out.println(output);
	}
	
	public void display3() //combination
	{
		templateID=3;
		Helper.line(50, "-");
		System.out.println("Display Resume: "+resumeTitle );
		Helper.line(50, "-");
		System.out.println("");
		String output="";
		output+=String.format("%-20s %-10s\n", "Resume ID: ",getResumeID());
		output+=String.format("%-20s %-10s\n", "Full Name: ",getFullName());
		output+=String.format("%-20s %-10d\n", "Contact Number: ",getContactInfo());
		output+=String.format("%-20s %-10s\n\n", "Email Address: ",getEmailAddress());
		output+=String.format("%s\n%s", "Brief summary of your skills: ",getDescription());
		System.out.println(output);
	}
	
	
}
