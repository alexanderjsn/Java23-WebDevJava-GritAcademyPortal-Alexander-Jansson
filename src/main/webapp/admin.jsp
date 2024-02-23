<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Student" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
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
                    <a href="index.html" class="active">Home</a>
                </li>
                <li>
                    <a href="studentServlet">Administration</a>
                </li>
                <li>
                    <a href="courseServlet">See courses/students</a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<form action="adminServlet" method="post">
        Student ID: <input type="text" name="student_id" id="studentID"><br>
    </form>

    <form action="adminServlet" method="post">
        Course ID: <input type="text" name="course_id" id="courseID"><br>
    </form>


<input type="text" id="queryTermInput" name="queryTerm" placeholder="Sök..." oninput="fetchData()">
<button>Sök</button>
<a href="inloggning.html">log</a>
<div id="result"></div>

<script>
    function fetchData() {
        const queryTerm = document.getElementById("queryTermInput").value;
        if (queryTerm !== "") {
            fetch('fetchData?queryTerm=' + encodeURIComponent(queryTerm))
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Network response was not ok");
                    }
                    return response.json();
                })
                .then(data => {
                    const resultContainer = document.getElementById("result");
                    resultContainer.innerHTML = '';

                    data.forEach(student => {
                        const studentDiv = document.createElement("div");
                        studentDiv.classList.add("student-entry");

                        const studentIdP = document.createElement("p");
                        studentIdP.textContent = `ID: ${student.student_id}`;
                        studentDiv.appendChild(studentIdP);

                        const fnameP = document.createElement("p");
                        fnameP.textContent = `${student.fname}`;
                        studentDiv.appendChild(fnameP);

                        const lnameP = document.createElement("p");
                        lnameP.textContent = `${student.lname}`;
                        studentDiv.appendChild(lnameP);



                        resultContainer.appendChild(studentDiv);

                        studentDiv.addEventListener("click", function() {
                            const userID = document.getElementById("studentID");
                            userID.value = student.student_id;
                        });
                    });
                })
                .catch(error => console.error('Fetch error:', error));
        }
    }
</script>
</body>
</html>
