<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Task</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
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

        <div class="d-flex justify-content-between">
            <a href="ToDoListServlet" class="btn btn-secondary">← Back</a>
            <button type="submit" class="btn btn-success">Create Task</button>
        </div>
    </form>
</div>
</body>
</html>
