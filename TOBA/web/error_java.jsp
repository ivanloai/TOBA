<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />
<section>
    <h4>Java Error</h4>
    <p>Sorry, Java has thrown an exception.</p>
    <p>To continue, click the back button.</p>

    <h4>Details</h4>
    <p>Type: ${pageContext.exception["class"]}</p>
    <p>Message: ${pageContext.exception.message}</p>
</section>
<c:import url="includes/footer.jsp" />