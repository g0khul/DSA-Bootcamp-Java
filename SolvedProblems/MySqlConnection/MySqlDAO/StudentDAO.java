package MySqlConnection.MySqlDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    Connection con;
    String query;
    PreparedStatement ps;

    public void establishConnection(String url, String username, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
    }

    public Student getStudent(int regno) throws SQLException {
        Student student = new Student(regno);
        query = "select * from student where regno=" + regno;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        student.name = rs.getString(2);
        System.out.println(student.name);
        return student;
    }

    public Student putStudent(int regno, String name) throws SQLException {
        Student student = new Student(regno, name);
        query = "insert into student values (?, ?)";
        ps = con.prepareStatement(query);
        ps.setInt(1, regno);
        ps.setString(2, name);
        ps.executeUpdate();
        return student;
    }
}
