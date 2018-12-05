package hw11;

public class MasterStudent extends GraduateStudent{
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
