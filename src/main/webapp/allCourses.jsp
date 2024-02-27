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
            <h1 id="logo">Grit Academy (Student)</h1>

        </a>
        <nav>
            <ul id="menu">
                <li>
                    <a href="studentHome.jsp" class="active">Home</a>
                </li>

                <li>
                    <a href="studentCourse">Students in your classes</a>
                </li>
 <li>
                    <a href="allCourses">Your classes</a>
                </li>
                 <li>
                     <a href="logout">Log out</a>
                 </li>
            </ul>
        </nav>
    </div>
</header>
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