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
		return email;
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
	
	public void displayUserInfo() {
		String output = String.format("%d %-10s %-15s %-20s", "ID", "Name", "Email", "Role");
		output += String.format("%d %-10s %-15s %-20s", user_id, name, email, role);
		
		System.out.println(output);
		
	}
}
