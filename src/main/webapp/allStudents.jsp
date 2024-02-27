<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.UserBean" %>

<html>
<head>
    <title>Studenter</title>
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


<h2>Students</h2>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Town</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Role</th>
    </tr>
    <%
    List<UserBean> allStudentCourses = (List<UserBean>) request.getAttribute("allStudents");
    for (UserBean user : allStudentCourses) {
    %>
        <tr>
            <td><%= user.getfName() %></td>
            <td><%= user.getlName() %></td>
            <td><%= user.getTown() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getPhone() %></td>
            <td><%= user.getRole() %></td>
        </tr>
    <% } %>
</table>

</body>
</html>