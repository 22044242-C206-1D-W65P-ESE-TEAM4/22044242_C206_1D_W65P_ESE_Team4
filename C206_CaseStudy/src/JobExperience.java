/**
 * 
 */

/**
 * @author KN
 *
 */

//22002464 Xaviera Ong Ke Ning

public class JobExperience {
	private String companyName;
	private String position;
	private String period;
	private String achievement;
	
	public JobExperience(String companyName, String position, String period, String achievement) 
	{
		//super();
		this.companyName = companyName;
		this.position = position;
		this.period = period;
		this.achievement = achievement;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public void displayWorkExperience()
	{
			System.out.println(String.format("%-20s %-10s", "Company: ", getCompanyName()));
			System.out.println(String.format("%-20s %-10s", "Achivement: ",  getAchievement()));
			System.out.println(String.format("%-20s %-10s","Position: ", getPosition()));
			System.out.println(String.format("%-20s %-10s", "Period: ", getPeriod()));

	}
	
}


