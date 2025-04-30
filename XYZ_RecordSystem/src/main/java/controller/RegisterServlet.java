package controller;

import dao.UserDAO;
import model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("staff"); // Default

        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.registerUser(user);

        if (result) {
            response.sendRedirect("common/login.jsp");
        } else {
            request.setAttribute("error", "Registration failed. Try again.");
            RequestDispatcher rd = request.getRequestDispatcher("common/register.jsp");
            rd.forward(request, response);
        }
    }
}
