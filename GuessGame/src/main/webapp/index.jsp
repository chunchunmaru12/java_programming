<%@ page language="java" session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Guess the Number</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow rounded">
                <div class="card-body text-center">
                    <h2 class="card-title mb-4"> Guess a Number Between 1 and 100</h2>

                    <form method="post" action="GuessingGame" class="mb-3">
                        <div class="input-group">
                            <input type="number" name="guess" class="form-control" placeholder="Enter your guess" required />
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
				
                    <%
                        String message = (String) session.getAttribute("message");
                        Integer attempts = (Integer) session.getAttribute("attempts");

                        if (message != null) {
                            String alertClass = message.contains("win") ? "success" :
                                                message.contains("lose") ? "danger" : "warning";
                    %>
                            <div class="alert alert-<%= alertClass %> mt-3" role="alert">
                                <%= message %>
                            </div>
                    <%
                        }

                        if (attempts != null && attempts > 0) {
                    %>
                            <p class="text-muted">Remaining Attempts: <strong><%= attempts %></strong></p>
                    <%
                        }
                    %>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
