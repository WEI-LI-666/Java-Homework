package hw11;

public class StudentTest {
    public static void main(String[] args) {

        Student masterStudent = new MasterStudent("David Tsai", "M10009001", "Information Management", "Integrated Digital Services Lab",
                "Professor Lo", "EMBA", "Unfinished");
        Student phDStudent = new PhDStudent("Peter Yang", "D10015001", "Computer Science", "Software Engineering Lab",
                "Professor Lee", "Passed", "Unfinished");
        Student fullTimeStudent = new FullTimeStudent("Jack Chen", "B10005001", "Construction Engineering", "Sophomore",
                "Class A", "Baseball Club", "Leader");
        Student partTimeStudent = new PartTimeStudent("Michelle Lin", "B10008001", "Business Administration", "Freshman",
                "Class B", "7-ELEVEN", "Clerk");

        System.out.println(masterStudent.toString());
        System.out.println(phDStudent.toString());
        System.out.println(fullTimeStudent.toString());
        System.out.println(partTimeStudent.toString());

    }
}
