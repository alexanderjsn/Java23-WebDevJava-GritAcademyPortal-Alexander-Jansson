<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.CourseParticipant" %>
<%@ page import="org.example.model.CourseBean" %>

<html>
<head>
    <title></title>
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
    <h2></h2>
    <table border="1">
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Course ID</th>
                <th>Role</th>
            </tr>
            <%
            List<CourseParticipant> allStudentCourses = (List<CourseParticipant>) request.getAttribute("allStudentCourses");
            for (CourseParticipant courseParticipant : allStudentCourses) {
            %>
                <tr>
                    <td><%= courseParticipant.getId() %></td>
                    <td><%= courseParticipant.getUserId() %></td>
                    <td><%= courseParticipant.getCourseId() %></td>
                    <td><%= courseParticipant.getRole() %></td>
                </tr>
            <% } %>
    </table>


</body>
</html>
