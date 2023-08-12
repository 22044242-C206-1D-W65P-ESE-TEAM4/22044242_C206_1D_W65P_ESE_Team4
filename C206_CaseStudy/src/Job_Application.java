// 22008468 shihan


public class Job_Application {
	private int JobID ;
	private String JobName ;
	private double salary ;
	private String skill; 
	private String description ;

	public Job_Application (int JobID , String JobName , double salary, String skill , String description ) {
		this.setJobID(JobID) ;
		this.JobName =JobName ;
		this.setSalary(salary) ;
		this.setSkill(skill);
		this.setDescription(description) ;

	} 

public int getJobID() {
	return JobID;
}

public void setJobID(int jobID) {
	JobID = jobID;
}

public String JobName () {
	return JobName ; 
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}
