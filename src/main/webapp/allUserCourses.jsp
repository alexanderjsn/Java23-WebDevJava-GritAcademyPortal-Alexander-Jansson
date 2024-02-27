<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>alla kurser</title>
      <%@ page import="java.util.List" %>
        <%@ page import="org.example.model.CourseBean" %>
                <link rel="stylesheet" href="css/style.css">

</head>
<body>

<header>
    <div class="header">
        <a href="index.html">
            <h1 id="logo">Grit Academy (Teacher)</h1>

        </a>
        <nav>
            <ul id="menu">
                <li>
                    <a href="teacherHome.jsp" class="active">Home</a>
                </li>

                    <li>
                     <a href="all">All classes</a>
                  </li>
                  <li>
                     <a href="listStudents">All students</a>
                   </li>

                   <li>
                    <a href="courses">All courses</a>
                   </li>
                   <li>
                    <a href="logout">Log out</a>
                   </li>
            </ul>
        </nav>
    </div>
</header>
<h2>Courses</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>YHP</th>
        <th>Description</th>

    </tr>
    <%
    List<CourseBean> allCoursesList = (List<CourseBean>) request.getAttribute("allCoursesList");
    for (CourseBean course : allCoursesList) {
    %>
        <tr>
            <td><%= course.getId() %></td>
            <td><%= course.getName() %></td>
            <td><%= course.getYHP() %></td>
            <td><%= course.getDescription() %></td>
        </tr>
    <% } %>
</table>

</body>
</html>