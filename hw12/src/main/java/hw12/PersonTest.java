package hw12;

public class PersonTest {

    public static void main(String[] args) {
        Person Alice = new Staff("Alice", "BA", 22000);
        Person Bob = new Student("Bob", "CS", "Master");
        Person Alex = new TeachingAssistant("Alex", "MI", "PhD", "MI", 30000);

        System.out.println(Alice.toString());
        System.out.println(Bob.toString());
        System.out.printf(Alex.toString());
    }
}
