<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kurslista</title>
        <link rel="stylesheet" href="css/style.css">

</head>
<body>
<h2>Kurslista</h2>

<table border="1">
    <tr>
        <th>Kurs-ID</th>
        <th>Namn</th>
        <th>YHP</th>
        <th>Beskrivning</th>
    </tr>
    <% List<Course> listCourse = (List<Course>) request.getAttribute("listCourse");
    for (Course course : listCourse) { %>
    <tr>
        <td><%= course.getCourseId() %></td>
        <td><%= course.getName() %></td>
        <td><%= course.getYhp() %></td>
        <td><%= course.getDescription() %></td>
    </tr>
    <% } %>
</table>

</body>
</html>