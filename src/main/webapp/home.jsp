<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
        <link rel="stylesheet" href="src/main/webapp/style.css">

</head>
<body>
<h2>Logga in</h2>


<form action="loginServlet" method="POST">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Logga in">

</form>

<h2>Register</h2>

<form action="register" method="POST">
    First name: <input type="text" name="fName" required><br><br>
    Last name  : <input type="text" name="lName" required><br><br>
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    Roll:
    <select name="role">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
    </select><br><br>
    <input type="submit" value="Registrera">
</form>

</body>
</html>