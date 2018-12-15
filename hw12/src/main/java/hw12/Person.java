package hw12;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name = " + getName();
    }
}

class Staff extends Person implements Work{
    private String department;
    private double salary;

    public Staff(String name, String department, double salary) {
        super(name);
        this.department = department;
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString() + ",\n" +
                "who works in " + getDepartment() + ",\n" +
                "whose salary is " + (int) getSalary() + ".\n";
    }
}

class Student extends Person implements Study {
    private String major;
    private String degree;

    public Student(String name, String major, String degree) {
        super(name);
        this.major = major;
        this.degree = degree;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return this.major;
    }

    public String getDegree() {
        return this.degree;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString() + ",\n" +
                "who studies in " + getMajor() + ",\n" +
                "whose degree is " + getDegree() + ".\n";
    }
}

class TeachingAssistant extends Student implements Work{
    private String department;
    private double salary;
    private String course;

    public TeachingAssistant(String name, String major, String degree, String department, double salary) {
        super(name, major, degree);
        this.department = department;
        this.salary = salary;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "TA name = " + getName() + ",\n" +
                "who studies in " + getMajor() + ",\n" +
                "whose degree is " + getDegree() + ",\n" +
                "who works in " + getDepartment() + ",\n" +
                "whose salary is " + (int) getSalary() + ".\n";
    }
}
