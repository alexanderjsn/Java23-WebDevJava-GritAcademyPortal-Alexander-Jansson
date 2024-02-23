<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Studentens Kurser</title>
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
</body>
</html>