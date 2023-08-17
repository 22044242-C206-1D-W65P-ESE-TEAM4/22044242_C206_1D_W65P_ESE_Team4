//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class testing {
//
//	public static void main(String[] args) {
//		CareerPath c1 = new CareerPath(1, "Software Engineer", "Develops software applications",
//				"High growth potential", "Programming skills");
//		CareerPath c2 = new CareerPath(2, "UI Designer", "Design user interface", "Understanding user behaviour",
//				"communication skills");
//
//		ArrayList<CareerPath> cpList = new ArrayList<>(Arrays.asList(c1, c2));
//		int choice = 1; // Set the choice to 1 or 2 based on your intention
//
//		if (choice == 1) {
//			CareerPathManagement(cpList);
//		}
//	}
//
//	public static void CareerPathManagement(ArrayList<CareerPath> cpList) {
//		System.out.println("1. View Career Path");
//		System.out.println("2. Add New Career Path");
//		System.out.println("3. Delete Career Path");
//
//		int op = Helper.readInt("CareerPath Management > "); // You should have a Helper class with this method
//
//		if (op == 1) {
//			int id = Helper.readInt("Enter Career Path ID: "); // Get the ID from the user
//			viewCareerPath(id, cpList);
//		} else if (op == 2) {
//			addNewCareerPath(cpList);
//		} else if (op == 3) {
//			deleteCareerPath(cpList);
//		}
//	}
//
//	public static void viewCareerPath(int careerPathId, ArrayList<CareerPath> cpList) {
//		CareerPath selectedCareerPath = getCareerPathById(cpList, careerPathId);
//
//		if (selectedCareerPath != null) {
//			System.out.println("Selected Career Path:");
//			System.out.println("===============================================");
//			System.out.println("Title: " + selectedCareerPath.getCareerTitle());
//			System.out.println("Description: " + selectedCareerPath.getJobDescription());
//			System.out.println("Growth Prospects: " + selectedCareerPath.getGrowthProspects());
//			System.out.println("Required Skills: " + selectedCareerPath.getRequiredSkills());
//		} else {
//			System.out.println("Invalid selection.");
//		}
//	}
//
//	public static CareerPath getCareerPathById(ArrayList<CareerPath> cpList, int id) {
//		for (CareerPath cp : cpList) {
//			if (cp.getCareerPathId() == id) {
//				return cp;
//			}
//		}
//		return null;
//	}
//
//	public static void addNewCareerPath(ArrayList<CareerPath> cpList) {
//		int newId = cpList.size() + 1;
//		String newTitle = Helper.readString("Career Title: ");
//		String newDescription = Helper.readString("A description of the new career path: ");
//		;
//		String newGrowthProspects = Helper.readString("Growth Prospects: ");
//		String newRequiredSkills = Helper.readString("Required skills for this path: ");
//
//		// Create a new CareerPath instance
//		CareerPath newCareerPath = new CareerPath(newId, newTitle, newDescription, newGrowthProspects,
//				newRequiredSkills);
//
//		// Add the new CareerPath to the list
//		cpList.add(newCareerPath);
//
//		System.out.println("New Career Path added:");
//		System.out.println("Title: " + newTitle);
//	}
//
//	public static void deleteCareerPath(ArrayList<CareerPath> cpList) {
//		int idToDelete = Helper.readInt("Enter the ID of the career path to delete:"); // Assuming the user enters the
//																						// ID to delete
//		CareerPath pathToDelete = getCareerPathById(cpList, idToDelete);
//
//		if (pathToDelete != null) {
//			cpList.remove(pathToDelete);
//			System.out.println("Career Path with ID " + idToDelete + " has been deleted.");
//		} else {
//			System.out.println("Career Path with ID " + idToDelete + " not found.");
//		}
//	}
//
//	public static void CareerpathMenu() {
//		// Similar implementation as before
//	}
//}
	