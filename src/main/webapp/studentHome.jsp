<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">

    <%@ page import="java.util.List" %>
    <%@ page import="org.example.model.CourseBean" %>

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
</body>

</html>