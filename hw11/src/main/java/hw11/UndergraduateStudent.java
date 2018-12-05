package hw11;

public class UndergraduateStudent {
    private Student student;
    private String grade;
    private String classes;

    public UndergraduateStudent(String name, String id, String major, String grade, String classes) {
        this.student = new Student(name, id, major);
        this.grade = grade;
        this.classes = classes;
    }

    public Student getStudent() {
        return student;
    }

    public String getGrade() {
        return grade;
    }

    public String getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return student.toString() +
                "Grade: " + grade + '\n' +
                "Class: " + classes + '\n';
    }
}
