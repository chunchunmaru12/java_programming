<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.Object" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="ToDoListServlet">📝 TodoApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navMenu">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="create.jsp">Add Task</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<h2 class="mb-4 text-center">➕ Add New Task</h2>
<form action="AddTaskServlet" method="post" class="bg-white p-4 rounded shadow-sm">
        <div class="mb-3">
            <label for="title" class="form-label">Task Title</label>
            <input type="text" class="form-control" name="title" id="title" required>
        </div>

        <div class="mb-3">
            <label for="descriptions" class="form-label">Description</label>
            <textarea class="form-control" name="descriptions" id="descriptions" required></textarea>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="start_date" class="form-label">Start Date</label>
                <input type="date" class="form-control" name="start_date" id="start_date" required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="due_date" class="form-label">Due Date</label>
                <input type="date" class="form-control" name="due_date" id="due_date" required>
            </div>
        </div>

        <div class="d-flex justify-content-between ">
           
            <button type="submit" class="btn btn-success ">Create Task</button>
        </div>
    </form>


        <div class="table-responsive">
        
            <table class="table table-bordered table-striped align-middle">
                <thead class="table-dark">
                    <tr>
              			<th>S.No.</th>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Start Date</th>
                        <th>Due Date</th>
                        <th>Status</th>
                        <th>Created At</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Object[]> tasks = (ArrayList<Object[]>) request.getAttribute("tasks");
                    if (tasks != null && !tasks.isEmpty()) {
                    	int counter=1;
                        for (Object[] task : tasks) {
                %>
                    <tr>
                    	<td><%= counter %></td>
                        <td><%= task[0] %></td>
                        <td><%= task[1] %></td>
                        <td><%= task[2] %></td>
                        <td><%= task[3] %></td>
                        <td><%= task[4] %></td>
                        <td>
                            <span class="badge bg-<%= "completed".equals(task[5]) ? "success" : "warning" %>">
                                <%= task[5] %>
                            </span>
                        </td>
                        <td><%= task[6] %></td>
                        <td>
                            <a href="EditTaskServlet?id=<%= task[0] %>" class="btn btn-sm btn-primary">Edit</a>
                            <a href="DeleteTaskServlet?id=<%= task[0] %>" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this task?');">Delete</a>
                        </td>
                    </tr>
                <% counter=counter+1;
                        
                        }
                        
                    } else {
                %>
                    <tr>
                        <td colspan="8" class="text-center">No tasks available.</td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <%
    String successMessage = (String) session.getAttribute("successMessage");
    if (successMessage != null) {
%>
<div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
    <div id="successToast" class="toast align-items-center text-bg-success border-0 show" role="alert">
        <div class="d-flex">
            <div class="toast-body"><%= successMessage %></div>
            <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast"></button>
        </div>
    </div>
</div>
<script>
    setTimeout(() => {
        const toast = document.getElementById('successToast');
        if (toast) {
            const bsToast = new bootstrap.Toast(toast);
            bsToast.hide();
        }
    }, 3000);
</script>
<%
    session.removeAttribute("successMessage");
    }
%>
    
</script>
    
</body>
</html>
