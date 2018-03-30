<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />
<section>
    <h4>Login Failed</h4>
    <p>The username or password you have entered did not match any account.</p>
    <p>Please try again or register if you are a new customer!</p>
    <form class="formButton" action="login.jsp" method="get">
        <input type="submit" value="Login">
    </form>
    <form class="formButton" action="new_customer.jsp" method="get">
        <input type="submit" value="Register">
    </form>
</section>
<c:import url="includes/footer.jsp" />