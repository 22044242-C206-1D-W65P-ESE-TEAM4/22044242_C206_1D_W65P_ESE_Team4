// Job_Opportunity 
// 22008468 shihan


public class Job_Opportunity {
	
	private String JobTitle ;
	private String Location ;
	private double Min_Salary ;
	private double Max_Salary ; 
	private String skills ;
	private String JobDetails ; 
	private String CompanyDetails ;
	private String qualifications ;
	private String deadline ;
	
	public Job_Opportunity(String JobTitle , String Location , 
							double Min_Salary,double Max_Salary,String skills ,
							String JobDetails , String CompanyDetails ,
							String qualifications , String deadline) { 
		
		this.JobTitle = JobTitle ;
		this.Location = Location ; 
		this.Min_Salary = Min_Salary ;
		this.Max_Salary = Max_Salary ; 
		this.skills = skills ; 
		this.JobDetails = JobDetails ;
		this.CompanyDetails = CompanyDetails ;
		this.qualifications = qualifications ;
		this.deadline = deadline ;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.JobTitle = jobTitle;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		this.Location = location;
	}

	public double getMax_Salary() {
		return Max_Salary;
	}

	public void setMax_Salary(double max_Salary) {
		this.Max_Salary = max_Salary;
	}

	public double getMin_Salary() {
		return Min_Salary;
	}

	public void setMin_Salary(double min_Salary) {
		this.Min_Salary = min_Salary;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJobDetails() {
		return JobDetails;
	}

	public void setJobDetails(String jobDetails) {
		this.JobDetails = jobDetails;
	}

	public String getCompanyDetails() {
		return CompanyDetails;
	}

	public void setCompanyDetails(String companyDetails) {
		this.CompanyDetails = companyDetails;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
		
	}
	