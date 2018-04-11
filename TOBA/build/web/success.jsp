<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />

<section>
    <h4>Congratulation!</h4>
    <p>You have successfully registered!</p>
    <p>Here is your registered information</p>
    <table>
        <tr>
            <td>First Name:</td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td>${user.phone}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${user.address}</td>
        </tr>
        <tr>
            <td>City:</td>
            <td>${user.city}</td>
        </tr>
        <tr>
            <td>State:</td>
            <td>${user.state}</td>
        </tr>
        <tr>
            <td>Zip Code:</td>
            <td>${user.zipCode}</td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td colspan="2"><br><b>Here is your Username and Password</b></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>${user.password}</td>
        </tr>
    </table>
    <p> Click the login button to sign in.</p>
    <p>${message}</p>
    <form action="login.jsp" method="get">
        <input type="submit" value="Login">
    </form>
</section>

<c:import url="includes/footer.jsp" />