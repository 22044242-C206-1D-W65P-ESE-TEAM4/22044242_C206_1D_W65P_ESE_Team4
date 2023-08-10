import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Assessment {

	private int assessment_id;
	private String assessment_type;
	private String topic;
	private String industry;
	private String career_path;
	private File assessment;

	public Assessment(int assessment_id, String assessment_type, String topic, String industry, String career_path,
			File assessment) {

		this.assessment_id = assessment_id;
		this.assessment_type = assessment_type;
		this.topic = topic;
		this.industry = industry;
		this.career_path = career_path;
		this.assessment = assessment;
	}

	public int getAssessment_id() {
		return assessment_id;
	}

	public void setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
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

	public String getAssessmentType() {
		return assessment_type;
	}

	public void setAssessmentType(String type) {
		this.assessment_type = type;
	}

	public File getAssessment() {
		return assessment;
	}

	public void display() {
		// need to display the content of the file also using FILE READER
		Helper.line(150, "=");
		System.out.println("-Assessment Preview-");
		Helper.line(150, "=");
		System.out.println("Assessment Type : " + getAssessmentType());
		System.out.println("Topic           : " + getTopic());
		System.out.println("Industry        : " + getIndustry());
		System.out.println("Career Path     : " + getCareer_path());
		System.out.println("\ntAssessment\n");
		Helper.line(150, "-");

		try {
			FileReader fr = new FileReader(assessment);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);

				line = br.readLine();
			}
			br.close();

		} catch (IOException io) {
			System.out.println("Message : " + io.getMessage());

		}

		Helper.line(150, "=");
	}

}
