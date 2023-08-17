import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class C206_CaseStudyTestShihan {

	private ArrayList<Job_Opportunity> jobList = new ArrayList<>();
    private ArrayList<User> usersList = new ArrayList<>();
    private Job_Opportunity existingJob;

    @BeforeEach
    void setup() { 
        usersList = new ArrayList<>();
        usersList.add(new User(1, "John Doe", "john@example.com", "user", "password"));
        usersList.add(new User(2, "HR1", "hr@example.com", "HR", "hrpassword"));

        existingJob = new Job_Opportunity("Software Engineer", "Singapore", 5000.0, 8000.0, "Java, Python",
                "Develop software applications", "XYZ Tech Solutions", "Bachelor's degree in Computer Science",
                "2023-08-31");

        jobList = new ArrayList<>(); 
        jobList.add(existingJob);
    }

    @Test
    void testLoginAsHR() {
        User loggedInUser = C206_CaseStudy.login(usersList, "hr@example.com", "hrpassword");

        assertNotNull(loggedInUser);
        assertEquals("HR", loggedInUser.getRole());
    }

    @Test
    void testLoginAsHRFail() {
        User loggedInUser = C206_CaseStudy.login(usersList, "hr@example.com", "wrongpassword");

        assertNull(loggedInUser);
    }

    @Test
    void testCreateNewJob() {
        Job_Opportunity newJob = new Job_Opportunity(
                "Software Developer", "Singapore", 5000.0, 8000.0, "Java, Python",
                "Develop software applications", "XYZ Tech Solutions",
                "Bachelor's degree in Computer Science", "2023-08-31"
        );

        jobList.add(newJob); 

        assertNotNull(newJob);
        assertEquals(2, jobList.size()); 
    }

    @Test
    void testCreateNewJobFail() { 

        int initialSize = jobList.size();

        Job_Opportunity newJob = new Job_Opportunity(
        		"Software Engineer", "Singapore", 5000.0, 8000.0, "Java, Python",
                "Develop software applications", "XYZ Tech Solutions", "Bachelor's degree in Computer Science",
                "2023-08-31"
        );

        jobList.add(newJob); 


        assertNotEquals(initialSize, jobList.size());
    }
    @Test
    void testDeleteExistingJob() {
        int initialSize = jobList.size();

        ByteArrayInputStream in = new ByteArrayInputStream("yes".getBytes());
        System.setIn(in);

        C206_CaseStudy.deleteJob(jobList, "Software Engineer");

        assertEquals(initialSize - 1, jobList.size());
    }

    @Test
    void testDeleteNonExistingJob() {
        int initialSize = jobList.size();

        ByteArrayInputStream in = new ByteArrayInputStream("yes".getBytes());
        System.setIn(in);

        C206_CaseStudy.deleteJob(jobList, "Non Existing Job");

        assertEquals(initialSize, jobList.size());
    }}
  


