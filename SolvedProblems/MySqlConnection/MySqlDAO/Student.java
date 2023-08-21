package MySqlDAO;

public class Student {
    int regno;
    String name;

    Student() {

    }

    public Student(int regno) {
        this.regno = regno;
    }

    Student(int regno, String name) {
        this.regno = regno;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [regno=" + regno + ", name=" + name + "]";
    }
}
