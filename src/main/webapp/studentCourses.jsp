<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Studentens Kurser</title>
      <%@ page import="java.util.List" %>
        <%@ page import="org.example.model.CourseBean" %>
<%@ page import="org.example.model.CourseparticipantsBeans" %>


</head>
<body>
<h2>My Courses</h2>
<table border="1">
<tr>
    <th>Course name</th>
    <th>YHP</th>
    <th>Description</th>
</tr>
    <%
    List<CourseBean> courses = (List<CourseBean>) request.getAttribute("courses");
    for (CourseBean course : courses) {
    %>
        <tr>
            <td><%= course.getName() %></td>
            <td><%= course.getYHP() %></td>
            <td><%= course.getDescription() %></td>
        </tr>
    <% } %>
    </table>
<table border="1">
<tr>
    <th>Student Name</th>
    <th>Username</th>
    <th>Role</th>
</tr>
<%
    List<CourseparticipantsBeans> sameStudents = (List<CourseparticipantsBeans>) request.getAttribute("sameStudents");
    if (sameStudents != null) {
        for (CourseparticipantsBeans student : sameStudents) {
%>
<tr>
    <td><%= student.getId() %> </td>
    <td><%= student.getUser_id() %></td>
        <td><%= student.getUser_id() %></td>
    <td><%= student.getRole() %></td>
</tr>
<%
        }
    }
%>
</table>

    </body>
</html>