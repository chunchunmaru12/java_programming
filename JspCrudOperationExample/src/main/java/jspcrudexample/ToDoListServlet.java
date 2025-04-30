package jspcrudexample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/ToDoListServlet")
public class ToDoListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ToDoListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "noorkhan786");
            Statement stmt = con.createStatement();
            
            String query = "SELECT * FROM task";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Object> tasks = new ArrayList<>();
            
            while (rs.next()) {
                // Create an array to hold task details
                Object[] task = {
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("descriptions"),
                        rs.getString("start_date"),
                        rs.getString("due_date"),
                        rs.getString("status"),
                        rs.getString("created_at")
                };
                tasks.add(task);
            }
            request.setAttribute("tasks", tasks);
            RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
            dispatch.forward(request, response);
            
            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        doGet(request, response);
    }
}
