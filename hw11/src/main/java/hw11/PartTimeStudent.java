package hw11;

public class PartTimeStudent extends UndergraduateStudent {
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
