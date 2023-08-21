import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "pB6Q2!2tFT!Ms!5NMad@4%";
        String query = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, username, password);
        // query = "select * from StudentMarks";
        // Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery(query);

        int regno = 4;
        String name = "Preethi";
        int mark1 = 70;
        int mark2 = 48;
        int mark3 = 67;

        query = "insert into StudentMarks values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, regno);
        ps.setString(2, name);
        ps.setInt(3, mark1);
        ps.setInt(4, mark2);
        ps.setInt(5, mark3);
        int count = ps.executeUpdate();
        System.out.println(count);
        query = "select * from StudentMarks";
        ResultSet rs = ps.executeQuery(query);
        // rs.next();
        // System.out.println(rs.getString("name"));

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "
                    + rs.getInt(5));
        }
    }
}
