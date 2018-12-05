package hw11;

public class Student {
    private String name;
    private String id;
    private String major;

    public Student(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + '\n' +
                "Student ID: " + getId() + '\n' +
                "Major: " + getMajor() + '\n';
    }
}

class GraduateStudent extends Student{
    private String lab;
    private String advisor;

    public GraduateStudent(String name, String id, String major, String lab, String advisor) {
        super(name, id, major);
        this.lab = lab;
        this.advisor = advisor;
    }

    public String getLab() {
        return lab;
    }

    public String getAdvisor() {
        return advisor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lab: '" + lab + '\n' +
                "Advisor: '" + advisor + '\n';
    }
}

class UndergraduateStudent extends Student{
    private String grade;
    private String classes;

    public UndergraduateStudent(String name, String id, String major, String grade, String classes) {
        super(name, id, major);
        this.grade = grade;
        this.classes = classes;
    }

    public String getGrade() {
        return grade;
    }

    public String getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Grade: " + grade + '\n' +
                "Class: " + classes + '\n';
    }
}

class MasterStudent extends GraduateStudent{
    private String system;
    private String thesis;

    public MasterStudent(String name, String id, String major, String lab, String advisor, String system, String thesis) {
        super(name, id, major, lab, advisor);
        this.system = system;
        this.thesis = thesis;
    }

    public String getSystem() {
        return system;
    }

    public String getThesis() {
        return thesis;
    }

    @Override
    public String toString() {
        return "***** " + this.getClass().getSimpleName() + " *****"  + '\n' +
                super.toString() +
                "System: " + system + '\n' +
                "Thesis: " + thesis + '\n' ;
    }
}

class PhDStudent extends GraduateStudent{
    private String qualify;
    private String dissertation;

    public PhDStudent(String name, String id, String major, String lab, String advisor, String qualify, String dissertation) {
        super(name, id, major, lab, advisor);
        this.qualify = qualify;
        this.dissertation = dissertation;
    }

    public String getQualify() {
        return qualify;
    }

    public String getDissertation() {
        return dissertation;
    }

    @Override
    public String toString() {
        return "***** " + this.getClass().getSimpleName() + " *****"  + '\n' +
                super.toString() +
                "Qualify: " + qualify + '\n' +
                "Dissertation: " + dissertation + '\n' ;
    }
}

class FullTimeStudent extends UndergraduateStudent{
    private String club;
    private String role;

    public FullTimeStudent(String name, String id, String major, String grade, String classes, String club, String role) {
        super(name, id, major, grade, classes);
        this.club = club;
        this.role = role;
    }

    public String getClub() {
        return club;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "***** " + this.getClass().getSimpleName() + " *****"  + '\n' +
                super.toString() +
                "Club: " + club + '\n' +
                "Role: " + role + '\n' ;
    }
}

class PartTimeStudent extends UndergraduateStudent {
    private String company;
    private String position;

    public PartTimeStudent(String name, String id, String major, String grade, String classes, String company, String position) {
        super(name, id, major, grade, classes);
        this.company = company;
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "***** " + this.getClass().getSimpleName() + " *****"  + '\n' +
                super.toString() +
                "Company: " + company + '\n' +
                "Position: " + position + '\n' ;
    }
}
