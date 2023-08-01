import java.sql.Date;

/**
 * 
 */

/**
 * @author 22044242
 *
 */
public class Profile {
	private int profile_id;
	private int user_id;
	private int contact_info;
	private String dob;
//	private int educationBackground_id;  - for educationbackground class
	
	public Profile(int profile_id, int user_id, int contact_info, String dob) {
		this.profile_id = profile_id;
		this.user_id = user_id;
		this.contact_info = contact_info;
		this.dob = dob;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getContact_info() {
		return contact_info;
	}

	public void setContact_info(int contact_info) {
		this.contact_info = contact_info;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
