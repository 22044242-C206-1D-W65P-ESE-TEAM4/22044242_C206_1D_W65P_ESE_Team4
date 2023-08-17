import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Assessment {

	// 22003477- Zay Yar Lin Naing
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
		System.out.println("\nAssessment\n");
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

	//Refactoring
	public String toString() {

		String output = String.format("%-5d %-25s %-25s %-25s %-30s %-30s", getAssessment_id(), getAssessmentType(),
				getTopic(), getIndustry(), getCareer_path(), getAssessment());
		return output;

	}

	public static void setHeader(String header) {
		Helper.line(150, "-");
		System.out.println(header);
		Helper.line(150, "-");
	}
	// Refactoring
	public static void AssessmentMenu() {
		Assessment.setHeader("-Management Of Assessment-");
		System.out.println("1. Add Assessment");
		System.out.println("2. View Assessment");
		System.out.println("3. Delete Assessment");
		System.out.println("0. Quit");
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


}
