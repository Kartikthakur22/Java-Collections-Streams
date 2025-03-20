import java.util.List;
import java.util.ArrayList;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract void evaluate();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Exam-based course: " + getCourseName());
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Assignment-based course: " + getCourseName());
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Research-based course: " + getCourseName());
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public void startCourse() {
        System.out.println("Starting course: " + courseType.getCourseName());
        courseType.evaluate();
    }

    public T getCourseType() {
        return courseType;
    }
}

class CourseManager {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course Name: " + course.getCourseName());
            course.evaluate();
        }
    }
}

public class University {
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>(new ExamCourse("Java Programming Exam"));
        Course<AssignmentCourse> assignmentCourse = new Course<>(new AssignmentCourse("Data Structures Assignment"));
        Course<ResearchCourse> researchCourse = new Course<>(new ResearchCourse("AI Research Paper"));

        examCourse.startCourse();
        assignmentCourse.startCourse();
        researchCourse.startCourse();

        List<CourseType> courseList = new ArrayList<>();
        courseList.add(new ExamCourse("Java Programming Exam"));
        courseList.add(new AssignmentCourse("Data Structures Assignment"));
        courseList.add(new ResearchCourse("AI Research Paper"));

        System.out.println("\nDisplaying all courses:");
        CourseManager.displayCourses(courseList);
    }
}
