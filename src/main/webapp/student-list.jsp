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
        Namn: <input type="text" name="Fname"><br>
        Efternamn: <input type="text" name="Lname"><br>
        Hobby: <input type="text" name="hobby"><br>
        Stad: <input type="text" name="city"><br>

        <input type="submit" value="Lägg till student">
    </form>

    <h2>Sök Studenter</h2>
    <form action="studentServlet" method="post">
        <label for="searchName">Sök efter studentnamn:</label>
        <input type="text" id="searchName" name="searchName">
        <input type="submit" value="Sök">
    </form>


</table>
</body>
</html>
