package MySqlDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();
        dao.establishConnection("jdbc:mysql://localhost:3306/record", "root", "pB6Q2!2tFT!Ms!5NMad@4%");
        Student s = dao.putStudent(2, "Aakash");
        s = dao.getStudent(2);
        System.out.println(s.toString());
    }
}
