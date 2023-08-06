import java.util.List;
//22002464 Xaviera Ong Ke Ning

public class ResumeTemplate {
	private int resumeID;
	private String resumeTitle;
	private String fullName;
	private int contactInfo;
	private String emailAddress;
	private String careerObjective;
	private String education;
	private String workExperience;
	private String skills;
	private String achievements;
	
	public ResumeTemplate
	(int resumeID, String resumeTitle, String fullName, int contactInfo, String emailAddress,
			String careerObjective, String education, String workExperience, String skills, String achievements) 
	{
		//super();
		this.resumeID = resumeID;
		this.resumeTitle = resumeTitle;
		this.fullName = fullName;
		this.contactInfo = contactInfo;
		this.emailAddress = emailAddress;
		this.careerObjective = careerObjective;
		this.education = education;
		this.workExperience = workExperience;
		this.skills = skills;
		this.achievements = achievements;
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

	public String getCareerObjective() 
	{
		return careerObjective;
	}

	public void setCareerObjective(String careerObjective)
	{
		this.careerObjective = careerObjective;
	}

	public String getEducation()
	{
		return education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	public String getWorkExperience()
	{
		return workExperience;
	}

	public void setWorkExperience(String workExperience)
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

	
	
}
