<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Studentens Kurser</title>
      <%@ page import="java.util.List" %>
        <%@ page import="org.example.model.CourseBean" %>
<%@ page import="org.example.model.UserBean" %>


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
    List<UserBean> sameStudents = (List<UserBean>) request.getAttribute("sameStudents");
    if (sameStudents != null) {
        for (UserBean student : sameStudents) {
%>
<tr>
    <td><%= student.getfName() %> <%= student.getlName() %></td>
    <td><%= student.getUsername() %></td>
    <td><%= student.getRole() %></td>
</tr>
<%
        }
    }
%>
</table>

    </body>
</html>