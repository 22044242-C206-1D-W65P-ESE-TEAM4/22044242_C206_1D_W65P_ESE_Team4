import java.util.ArrayList;
import java.util.Arrays;

public class TestJobSkill {
    private static ArrayList<Skill> skillList = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User admin = new User(1, "Admin", "admin@gmail.com", "admin", "lol123");
		User user1 = new User(2, "john doe1", "john1@sgmail.com", "user", "lol123");
		User user2 = new User(3, "john doe2", "john2@gmail.com", "user", "lol123");
		User HR1 = new User(4, "Hr1", "Hr1@gmail.com", "HR", "lol123");
		ArrayList<User> usersList = new ArrayList<User>(Arrays.asList(admin, user1, user2, HR1));
		
		skillList.add(new Skill(2));
		skillList.add(new Skill(3));

		skillList.get(0).addSkill("Applications Development");
		skillList.get(0).addSkill("Applications Integration");
		skillList.get(1).addSkill("Business innovation");
		skillList.get(1).addSkill("Software Design");
		
		int option = 0;
		
		while(option != 100) {
			menu();
		option = Helper.readInt("Enter option > ");
		if (option == 1) {
			viewSkills(usersList, skillList);

		}else if(option == 2) {
			addSkill(usersList, skillList);
				
		}else if(option == 3){
			deleteSkill(usersList, skillList);
		}
	}
	}
	public static void menu() { 
		Helper.line(70,"=");
		System.out.println("1. View all Skills");
		System.out.println("2. Add Skill");
		System.out.println("3. Delete Skill");
		System.out.println("4. Exit");
		Helper.line(70, "=");
	}
		public static String viewSkills(ArrayList<User>usersList, ArrayList<Skill>skillList) {
			
	        for (User user : usersList) {
	            while(user.getUser_id() != 1 && user.getUser_id() != 4) {
	        	System.out.println("User: " + user.getName());
	        	break;
	            }
	            for (Skill skill : skillList) {
	                if (skill.getUser_id() == user.getUser_id()) {
	                    System.out.println("Skills:");
	                    for (String s : skill.getSkills()) {
	                        System.out.println("- " + s);
	                    }
	                }
	            }
	        }
	        return null;
		}
		
		public static Skill addSkill(ArrayList<User>usersList, ArrayList<Skill>skillList) {
			int userID = Helper.readInt("Enter User ID > ");
			String addSkill = Helper.readString("Enter skill to add > ");
			
			for(User user: usersList) {
				if(user.getUser_id() == userID) {
					for(Skill skill:skillList) {
						if(skill.getUser_id() == userID) {
							skill.addSkill(addSkill);
						}
					}
					
				}
			}
			return null;
		}
		public static void deleteSkill(ArrayList<User>usersList, ArrayList<Skill>skillList) {
			int userID = Helper.readInt("Enter User ID > ");
			String deleteSkill = Helper.readString("Enter skill to delete > ");
			
			for(User user: usersList) {
				if(user.getUser_id() == userID) {
					for(Skill skill:skillList) {
						if(skill.getUser_id() == userID) {
							skill.deleteSkill(deleteSkill);
						}
					}
					
				}
			}
		}
}

	
		

