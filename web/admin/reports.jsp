<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../includes/header.html" />

<h4>User registered:</h4>
<table border="1" cellpadding="2">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
    </tr>
    <c:forEach var="reports" items="${reportList}">
        <tr>
            <td>${reports.firstName}</td>
            <td>${reports.lastName}</td>
            <td>${reports.email}</td>
        </tr>
    </c:forEach>
</table>
<form action="ReportsServlet" method="POST">
    <input type="hidden" name="action" value="refresh">
    <input type="submit" value="Refresh">
</form>

<c:import url="../includes/footer.jsp" />