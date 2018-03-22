<%-- 
    Document   : new_customer
    Created on : Mar 21, 2018, 12:08:44 PM
    Author     : Ivan Loai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA - Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css">
    </head>
    <body>
        <section>
            <h1>TOBA</h1>
            <h3>The Titan Online Banking Application</h3>
            <nav>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="login.html">Login</a></li>
                    <li><a href="#">Register</a></li>
                </ul>
            </nav>
        </section>
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
        <footer>
            <p>TOBA Online Banking Application<br>
                @Ivan Loai</p>
        </footer>
    </body>
</html>