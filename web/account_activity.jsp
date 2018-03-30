<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />

<c:if test="${sessionScope.user != null}">
    <h4>Welcome ${user.firstName} ${user.lastName}!</h4>
</c:if>
<c:if test="${sessionScope.user == null}">
    <h4>Not Logged In</h4>
</c:if>

<c:import url="includes/footer.jsp" />