package hw11;

public class PhDStudent extends GraduateStudent{
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
