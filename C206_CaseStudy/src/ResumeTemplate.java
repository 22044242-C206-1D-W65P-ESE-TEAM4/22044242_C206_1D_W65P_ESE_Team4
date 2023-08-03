import java.util.List;
//22002464 Xaviera Ong Ke Ning

public class ResumeTemplate {
	private int workExperience;
	private String education;
	private List skillSets;
	private String achievements;
	
	public ResumeTemplate(int workExperience, String education, List skillSets, String achievements) {
		this.workExperience = workExperience;
		this.education = education;
		this.skillSets = skillSets;
		this.achievements = achievements;
	}

	public int getWorkExperience() 
	{
		return workExperience;
	}

	public void setWorkExperience(int workExperience) 
	{
		this.workExperience = workExperience;
	}

	public String getEducation() 
	{
		return education;
	}

	public void setEducation(String education) 
	{
		this.education = education;
	}

	public List getSkillSets() 
	{
		return skillSets;
	}

	public void setSkillSets(List skillSets)
	{
		this.skillSets = skillSets;
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
