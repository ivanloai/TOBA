<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />
<c:if test="${sessionScope.user != null}">
    <section>
        <h1>Transaction</h1>

        <table>
            <tr>
                <th>Balance</th>
            </tr>
            <tr>
                <th>Checking</th>
                <th>Savings</th>
            </tr>
            <tr>
                <td>${checkingBalance}</td>
                <td>${savingBalance}</td>
            </tr>
            <tr>
                <td>
                    <form action="TransactionServlet" method="POST">
                        <input type="hidden" name="action" value="refresh">
                        <input type="submit" value="Refresh">
                    </form>
                </td>
            </tr>
        </table>
        <br>

        <h3>Transfer Funds</h3>
        <p>Transfer money between Checking account and Saving account:</p>
        <p>From:</p>

        <form action="TransactionServlet" method="POST">

            <input type="hidden" name="action" value="transfer">

            <select name="selectedAccount">
                <option></option>
                <option value="selectedChecking">Checking</option>
                <option value="selectedSaving">Saving</option>
            </select>
            <br>

            <p>Amount: <input type="text" name="transferAmount"></p>

            <input type="submit" value="Transfer">
        </form>

        <p><i>${message}</i></p>
    </section>

</c:if>
<c:if test="${sessionScope.user == null}">
    <h4>Not Logged In</h4>
</c:if>

<c:import url="includes/footer.jsp" />