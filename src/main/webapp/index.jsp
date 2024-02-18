<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Suggestion" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Resultat</title>
</head>
<body>
    <h1>Förslag</h1>
    <p>Query Term: ${param.queryTerm}</p> <!-- Visar den ursprungliga queryTerm som skickades -->
    <div>
        <p>Förslag:</p>
        <ul>
            <% List<Suggestion> suggestions = (List<Suggestion>) request.getAttribute("suggestions");
               if (suggestions != null) {
                   for (Suggestion suggestion : suggestions) {
            %>
            <li><%= suggestion.getTerm() %></li>
            <%
                   }
               }
            %>
        </ul>
    </div>
</body>
</html>
