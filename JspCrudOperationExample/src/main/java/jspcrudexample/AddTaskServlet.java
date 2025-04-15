package jspcrudexample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String descriptions = request.getParameter("descriptions");
        String startDate = request.getParameter("start_date");
        String dueDate = request.getParameter("due_date");
        String status = "in progress"; // default value

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "noorkhan786");
            String insertQuery = "INSERT INTO task(title, descriptions, start_date, due_date, status) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, title);
            ps.setString(2, descriptions);
            ps.setString(3, startDate);
            ps.setString(4, dueDate);
            ps.setString(5, status);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        // Redirect back to the main list page
        response.sendRedirect("ToDoListServlet");
    }
}
