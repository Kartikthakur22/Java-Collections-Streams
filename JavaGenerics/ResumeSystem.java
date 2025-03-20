import java.util.List;
import java.util.ArrayList;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void evaluateResume(String resumeContent);
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void evaluateResume(String resumeContent) {
        System.out.println("Evaluating resume for " + getRoleName() + ": " + resumeContent);
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void evaluateResume(String resumeContent) {
        System.out.println("Evaluating resume for " + getRoleName() + ": " + resumeContent);
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void evaluateResume(String resumeContent) {
        System.out.println("Evaluating resume for " + getRoleName() + ": " + resumeContent);
    }
}

class Resume<T extends JobRole> {
    private T jobRole;
    private String resumeContent;

    public Resume(T jobRole, String resumeContent) {
        this.jobRole = jobRole;
        this.resumeContent = resumeContent;
    }

    public void processResume() {
        jobRole.evaluateResume(resumeContent);
    }

    public T getJobRole() {
        return jobRole;
    }
}

class ResumeScreeningSystem {
    public static <T extends JobRole> void screenResumes(List<? extends JobRole> jobRoles, String resumeContent) {
        for (JobRole role : jobRoles) {
            role.evaluateResume(resumeContent);
        }
    }
}
public class ResumeSystem {
    public static void main(String[] args) {
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        DataScientist dataScientist = new DataScientist();
        ProductManager productManager = new ProductManager();

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(softwareEngineer);
        jobRoles.add(dataScientist);
        jobRoles.add(productManager);

        String resumeContent = "Experienced developer with expertise in Java and Python.";

        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>(softwareEngineer, resumeContent);
        Resume<DataScientist> dataScientistResume = new Resume<>(dataScientist, resumeContent);
        Resume<ProductManager> productManagerResume = new Resume<>(productManager, resumeContent);

        softwareEngineerResume.processResume();
        dataScientistResume.processResume();
        productManagerResume.processResume();

        System.out.println("\nScreening resumes for multiple job roles:");
        ResumeScreeningSystem.screenResumes(jobRoles, resumeContent);
    }
}
