
import java.util.HashMap;

public class GradExams {

    private String name;
    private String surname;
    private String className;
    private HashMap<String, Integer> grades;

    public GradExams(String name, String surname, String className) {
        this.name = name;
        this.surname = surname;
        this.className = className;
    }

    public GradExams(String name, String surname, String className, HashMap<String, Integer> grades) {
        this.name = name;
        this.surname = surname;
        this.className = className;
        this.grades = setGrades(grades);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClassName() {
        return className;
    }

    public void setSubject(String subject) {
        this.className = subject;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public HashMap<String, Integer> setGrades(HashMap<String, Integer> grades) {
        this.grades = grades;
        return grades;
    }
}
