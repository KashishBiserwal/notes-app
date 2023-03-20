<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="com.entities.Notes" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.query.NativeQuery" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View notes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="stylesheet" href="CSS/Style.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body style="background: #ffff177a">
<%@include file="navbar.jsp"%>
<br>
<div class="container">
  <h1>My Notes...</h1>
  <div class="plus-btn" style="top: 5rem">
    <a href="add_notes.jsp"><img src="images/add-icon.png" alt="..."></a>
  </div>
  <br>
    <div class="notes-list">
      <%
        Session s = FactoryProvider.getFactory().openSession();
        NativeQuery query = s.createNativeQuery("SELECT * FROM Notes", Notes.class);
        List<Notes> list = query.list();
        for(Notes note: list){
        %>
      <div class="card mt-3">
        <div class="note-title">
          <img src="images/note-icon.png" class="card-img-top" style="max-width: 50px" alt="...">
          <h5 class="card-title"><%=note.getTitle()%></h5>
        </div>
        <div class="card-body">
          <p class="card-text"><%=note.getContent()%></p>
          <p><%=note.getAddedDate()%></p>
          <div class="container text-center">
            <a href="edit_note.jsp?note_id=<%=note.getId()%>" class="update-delete-icon"><img src="images/update-icon.png" alt="..." style="width: 70px"></a>
            <a href="DeleteServlet?note_id=<%=note.getId()%>" class="update-delete-icon"><img src="images/delete-icon.png" alt="..." style="width: 45px"></a>
          </div>
        </div>
      </div>
      <%
        }
        s.close();
      %>
    </div>
</div>
</body>
</html>