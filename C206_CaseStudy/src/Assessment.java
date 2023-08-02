import java.io.File;

public class Assessment {

	private String assessment_name;
	private String topic;
	private String industry;
	private String career_path;
	private File assessment;

	public Assessment(String assessment_name, String topic, String industry, String career_path, File assessment) {
		this.assessment_name = assessment_name;
		this.topic = topic;
		this.industry = industry;
		this.career_path = career_path;
		this.assessment = assessment;
	}

	public String getAssessment_name() {
		return assessment_name;
	}

	public void setAssessment_name(String assessment_name) {
		this.assessment_name = assessment_name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCareer_path() {
		return career_path;
	}

	public void setCareer_path(String career_path) {
		this.career_path = career_path;
	}

	public File getAssessment() {
		return assessment;
	}

}
