/**
 * 
 */

/**
 * @author 22044242
 *
 */
public class EducationBackground {
	private int educationBackground_id;
	private int user_id;
	private String degree;
	private String institution;
	private int year_graduated;
	
	public EducationBackground
		(int educationBackground_id, int user_id, String degree, String institution,int year_graduated) {
			this.educationBackground_id = educationBackground_id;
			this.user_id = user_id;
			this.degree = degree;
			this.institution = institution;
			this.year_graduated = year_graduated;
		}
	
	public EducationBackground(String degree, String institution, int year_graduated) 
	{
		this.degree = degree;
		this.institution = institution;
		this.year_graduated = year_graduated;
	}

	public int getEducationBackground_id() {
		return educationBackground_id;
	}
	public void setEducationBackground_id(int educationBackground_id) {
		this.educationBackground_id = educationBackground_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setProfile_id(int profile_id) {
		this.user_id = profile_id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public int getYear_graduated() {
		return year_graduated;
	}
	public void setYear_graduated(int year_graduated) {
		this.year_graduated = year_graduated;
	}
}
