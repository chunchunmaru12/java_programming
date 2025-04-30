<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="../RegisterServlet" method="post">
        <label>Name:</label><br/>
        <input type="text" name="name" required /><br/>
        
        <label>Email:</label><br/>
        <input type="email" name="email" required /><br/>
        
        <label>Password:</label><br/>
        <input type="password" name="password" required /><br/><br/>
        
        <input type="submit" value="Register" />
    </form>
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
    
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>
