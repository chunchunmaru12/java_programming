<%
    if (request.getAttribute("id") != null) {
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
    <h2 class="mb-4 text-center">✏️ Edit Task</h2>
    <form action="UpdateTaskServlet" method="post" class="bg-white p-4 rounded shadow-sm">
        <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">

        <div class="mb-3">
            <label for="title" class="form-label">Task Title</label>
            <input type="text" class="form-control" name="title" id="title" value="<%= request.getAttribute("title") %>" required>
        </div>

        <div class="mb-3">
            <label for="descriptions" class="form-label">Description</label>
            <textarea class="form-control" name="descriptions" id="descriptions" required><%= request.getAttribute("descriptions") %></textarea>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="start_date" class="form-label">Start Date</label>
                <input type="date" class="form-control" name="start_date" id="start_date" value="<%= request.getAttribute("start_date") %>" required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="due_date" class="form-label">Due Date</label>
                <input type="date" class="form-control" name="due_date" id="due_date" value="<%= request.getAttribute("due_date") %>" required>
            </div>
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <select class="form-select" name="status" id="status" required>
                <option value="in progress" <%= "in progress".equals(request.getAttribute("status")) ? "selected" : "" %>>In Progress</option>
                <option value="completed" <%= "completed".equals(request.getAttribute("status")) ? "selected" : "" %>>Completed</option>
                <option value="pending" <%= "pending".equals(request.getAttribute("status")) ? "selected" : "" %>>Pending</option>
            </select>
        </div>

        <div class="d-flex justify-content-between">
            <a href="ToDoListServlet" class="btn btn-secondary">← Back</a>
            <button type="submit" class="btn btn-primary">Update Task</button>
        </div>
    </form>
</div>
</body>
</html>
<%
    } else {
%>
<h3 class="text-center text-danger mt-5">Task not found.</h3>
<%
    }
%>
