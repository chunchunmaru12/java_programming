<%@ page import="model.User" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session = request.getSession(false);
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h2>Welcome, <%= user.getName() %>!</h2>
    <p>Role: <%= user.getRole() %></p>
    <a href="logout.jsp">Logout</a>
</body>
</html>
