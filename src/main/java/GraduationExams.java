
import java.util.HashMap;

public class GraduationExams {

    private String name;
    private String surname;
    private String subject;
    private int[] grades;

        public GraduationExams(String name, String surname, String subject) {
        this.name = name;
        this.surname = surname;
        this.subject = subject;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int[] getGrades() {
        return grades;
    }

    public int[] setGrades(int[] grades) {
        this.grades = grades;
    return grades;
    }
}
