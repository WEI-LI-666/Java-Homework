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
