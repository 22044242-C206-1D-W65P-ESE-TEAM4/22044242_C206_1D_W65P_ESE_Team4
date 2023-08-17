/**
 * 
 */

/**
 * @author 22044242
 *
 */
public class User {
	private int user_id;
	private String name;
	private String email;
	private String role;
	// encrypted
	private String password;
	
	public User(int user_id, String name, String email, String role, String password) {
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String displayUserInfo() {
		String output = String.format("%-10s %-20s %-20s %-15s %-5s\n", "ID", "Name", "Email", "Role", "Contact Number");
		output += String.format("%-10d %-20s %-20s %-15s", user_id, name, email, role);
		
		return output;	
	}

}
