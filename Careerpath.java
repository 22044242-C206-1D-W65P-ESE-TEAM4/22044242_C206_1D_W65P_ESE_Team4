//22018950 Lee Han Lin

import java.util.List;

class CareerPath {
    private String careerTitle;
    private String jobDescription;
    private String growthProspects;
    private List<String> requiredSkills;

    public CareerPath(String careerTitle, String jobDescription, String growthProspects,
                      List<String> requiredSkills) {
        this.careerTitle = careerTitle;
        this.jobDescription = jobDescription;
        this.growthProspects = growthProspects;
        this.requiredSkills = requiredSkills;
    }

    // Getters and setters for career path fields
    public String getCareerTitle() {
        return careerTitle;
    }

    public void setCareerTitle(String careerTitle) {
        this.careerTitle = careerTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getGrowthProspects() {
        return growthProspects;
    }

    public void setGrowthProspects(String growthProspects) {
        this.growthProspects = growthProspects;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
