<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<h2>Student List</h2>


<table border="1">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>City</th>
        <th>Hobby</th>
    </tr>
    <% List<Student> listStudent = (List<Student>) request.getAttribute("listStudent");
    for (Student student : listStudent) { %>
    <tr>
        <td><%= student.getStudentId() %></td>
        <td><%= student.getFirstName() %></td>
        <td><%= student.getLastName() %></td>
        <td><%= student.getCity() %></td>
        <td><%= student.getHobby() %></td>
    </tr>
    <% } %>
    <form action="AddStudentServlet" method="post">
        Namn: <input type="text" name="Fname" id="nameInput"><br>
        Efternamn: <input type="text" name="Lname" id="lnameInput"><br>
        Hobby: <input type="text" name="hobby" id="hobby"><br>
        Stad: <input type="text" name="city"id="city"><br>

        <input type="submit" value="Lägg till student">
    </form>

</table>


</body>
</html>
