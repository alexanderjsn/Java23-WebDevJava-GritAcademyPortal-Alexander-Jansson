<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>alla kurser</title>
</head>
<body>
<h2>All Courses</h2>
<table border="1">
<tr>
    <th>Course name</th>
    <th>YHP</th>
    <th>Description</th>
</tr>
    <%
        List<CourseBean> allCourses = (List<CourseBean>) request.getAttribute("allCourses");
        for (CourseBean course : allCourses) {
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