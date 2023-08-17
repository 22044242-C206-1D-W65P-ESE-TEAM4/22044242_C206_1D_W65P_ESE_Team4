import java.util.ArrayList;

class Skill {
    private int user_id;
    private ArrayList<String> skills;

    public Skill(int user_id) {
        this.user_id = user_id;
        this.skills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }
    public void deleteSkill(String skill) {
    	skills.remove(skill);
    }
    public int getUser_id() {
        return user_id;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
}

