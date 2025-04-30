<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="../LoginServlet" method="post">
        <label>Email:</label><br/>
        <input type="email" name="email" required /><br/>
        
        <label>Password:</label><br/>
        <input type="password" name="password" required /><br/><br/>
        
        <input type="submit" value="Login" />
    </form>
    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
    
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>
