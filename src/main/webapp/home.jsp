<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
        <link rel="stylesheet" href="src/main/webapp/style.css">

</head>
<body>
<form action="loginServlet" method="POST">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Logga in">
    <input type="hidden" name="csrfToken" value="${csrfToken}">;

</form>

<br>
<br>
<br>

<form action="register" method="POST">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    Name: <input type="name" name="name"><br>
    Phone: <input type="phone" name="phone"><br>
    Email: <input type="email" name="email"><br>
    <input type="submit" value="Registrera">
    <!--vänd sida tillbaka till inlog med confirmation ovanpå, ajax? -->
</form>

</body>
</html>