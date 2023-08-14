
import java.util.ArrayList;

public class CareerPath {

	private int careerPathId;
	private String careerTitle;
	private String jobDescription;
	private String growthProspects;
	private String requiredSkills;

	
	public CareerPath(int careerPathId, String careerTitle, String jobDescription, String growthProspects, String requiredSkills) {
		this.careerPathId = careerPathId;
		this.careerTitle = careerTitle;
		this.jobDescription = jobDescription;
		this.growthProspects = growthProspects;
		this.requiredSkills = requiredSkills;
	}

	// Getters and setters for career path fields
	
	public int getCareerPathId() {
		return careerPathId;
	}
	
	public String getCareerTitle() {
		return careerTitle;
	}

	public void setCareerTitle(String careerTitle) {
		this.careerTitle = careerTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getGrowthProspects() {
		return growthProspects;
	}

	public void setGrowthProspects(String growthProspects) {
		this.growthProspects = growthProspects;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public static CareerPath getCareerPathById(ArrayList<CareerPath> cpList, int id) {
		// TODO Auto-generated method stub
		return null;
	} 
}