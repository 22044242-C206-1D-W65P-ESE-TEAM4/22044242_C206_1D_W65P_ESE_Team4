import java.io.File;

public class Assessment {

	private String assessment_type;
	private String topic;
	private String industry;
	private String career_path;
	private File assessment;

	public Assessment(String assessment_type, String topic, String industry, String career_path, File assessment) {

		this.assessment_type = assessment_type;
		this.topic = topic;
		this.industry = industry;
		this.career_path = career_path;
		this.assessment = assessment;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getCareer_path() {
		return career_path;
	}

	public void setCareer_path(String career_path) {
		this.career_path = career_path;
	}

	public String getAssessmentType(String type) {
		return type;
	}

	public void setAssessmentType(String type) {
		this.assessment_type = type;
	}

	public File getAssessment() {
		return assessment;
	}

}
