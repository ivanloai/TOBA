<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />
<section>
    <h4>Welcome new customer!</h4>
    <p>Please fill out all field below to join us!</p>
    <form action="NewCustomerServlet" method="post">
        <input type="hidden" name="action" value="register">
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName" ></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" ></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" name="city"></td>
            </tr>
            <tr>
                <td>State</td>
                <td><input type="text" name="state"></td>
            </tr>
            <tr>
                <td>Zip Code</td>
                <td><input type="text" name="zipCode"></td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Sign up"></td>
            </tr>
        </table>
        <p><i>${message}</i></p>
    </form>
</section>
<c:import url="includes/footer.jsp" />