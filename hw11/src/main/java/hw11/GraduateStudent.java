package hw11;

public class GraduateStudent {
    private Student student;
    private String lab;
    private String advisor;

    public GraduateStudent(String name, String id, String major, String lab, String advisor) {
        this.student = new Student(name, id, major);
        this.lab = lab;
        this.advisor = advisor;
    }

    public Student getStudent() {
        return student;
    }

    public String getLab() {
        return lab;
    }

    public String getAdvisor() {
        return advisor;
    }

    @Override
    public String toString() {
        return student.toString() +
                "Lab: '" + lab + '\n' +
                "Advisor: '" + advisor + '\n';
    }
}
