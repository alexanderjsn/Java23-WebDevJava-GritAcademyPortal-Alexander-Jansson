<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.CourseBean" %>
<%@ page import="org.example.model.CourseParticipant" %>
<html>
<head>
    <title>Studentens Kurser</title>
            <link rel="stylesheet" href="css/style.css">

</head>

<body>

<header>
    <div class="header">
        <a href="index.html">
            <h1 id="logo">Grit Academy</h1>
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