<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a note</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/Style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body style="background: #ffff177a">
    <%@include file="navbar.jsp"%>
    <br>
    <div class="container">
        <h3>Add a note...</h3>
        <br>
        <div class="form-container">
            <form action="SaveNoteServlet" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" id="title" name="title" placeholder="Title" required>
                </div>
                <div class="mb-3">
                    <textarea id="content" placeholder="Note" name="content" class="form-control" style="height: 200px"></textarea>
                </div>
                <div class="container text-center">
                    <button type="submit" class="button">Add</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
