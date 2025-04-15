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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/EditTaskServlet")
public class EditTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String taskId = request.getParameter("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "noorkhan786");
            String selectQuery = "SELECT * FROM task WHERE id=?";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ps.setInt(1, Integer.parseInt(taskId));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Pass data as individual attributes
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("title", rs.getString("title"));
                request.setAttribute("descriptions", rs.getString("descriptions"));
                request.setAttribute("start_date", rs.getString("start_date"));
                request.setAttribute("due_date", rs.getString("due_date"));
                request.setAttribute("status", rs.getString("status"));

                RequestDispatcher dispatch = request.getRequestDispatcher("edit.jsp");
                dispatch.forward(request, response);
            } else {
                response.getWriter().println("<h3 class='text-center text-danger'>Task not found.</h3>");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

