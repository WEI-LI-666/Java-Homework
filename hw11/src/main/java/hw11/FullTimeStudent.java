package hw11;

public class FullTimeStudent extends UndergraduateStudent{
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
