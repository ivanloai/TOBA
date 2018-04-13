<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="includes/header.html" />

<c:if test="${sessionScope.user != null}">
    <h4>Welcome ${user.firstName} ${user.lastName}!</h4>

    <p><b>Account Activity</b></p>
    <table border="1" cellpadding="2">
        <tr>
            <th>Transaction ID</th>
            <th>Date</th>
            <th>Account</th>
            <th>Amount Transfered</th>
            <th>Checking Balance</th>
            <th>Saving Balance</th>
        </tr>
        <c:forEach var="transactions" items="${transactionList}">
            <tr>
                <td>${transactions.transactionID}</td>
                <td>
                    <fmt:formatDate type = "date" value = "${transactions.transactionDate}" />
                </td>
                <td>${transactions.account.accountType}</td>
                <td>
                    <fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${transactions.amountTransfered}" type = "currency"/>
                </td>
                <td>
                    <fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${transactions.checkingBalance}" type = "currency"/>
                </td>
                <td>
                    <fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${transactions.savingBalance}" type = "currency"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action="AccountActivityServlet" method="POST">
        <input type="hidden" name="action" value="refresh">
        <input type="submit" value="Refresh">
    </form>
</c:if>
<c:if test="${sessionScope.user == null}">
    <h4>Not Logged In</h4>
</c:if>

<c:import url="includes/footer.jsp" />