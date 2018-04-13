<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />

<session>
    <h4>Reset Password</h4>
    <p>Fill out the form below to reset the password</p>
    <form action="ResetPasswordServlet" method="post">
        <input type="hidden" name="action" value="resetPassword">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" value="${user.username}" required></td>
            </tr>
            <tr>
                <td>New Password:</td>
                <td><input type="password" name="newPassword" required></td>
            </tr>
            <tr>
                <td>Confirm New Password:</td>
                <td><input type="password" name="confirmPassword" required></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Reset Password"></td>
            </tr>
        </table>
    </form>
    <p><i>${message}</i></p>
</session>

<c:import url="includes/footer.jsp" />
