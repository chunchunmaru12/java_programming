
package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/obrs";
        String username = "root";
        String password = "noorkhan786";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database!");

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("c_name"));
                System.out.println("Email: " + resultSet.getString("c_email"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
