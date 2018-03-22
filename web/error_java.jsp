<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA - Java Error</title>
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
                    <li><a href="index">Home</a></li>
                    <li><a href="login.html">Login</a></li>
                    <li><a href="new_customer.jsp">Register</a></li>
                </ul>
            </nav>
        </section>
        <section>
            <h4>Java Error</h4>
            <p>Sorry, Java has thrown an exception.</p>
            <p>To continue, click the back button.</p>

            <h4>Details</h4>
            <p>Type: {pageContext.exception["class"]}</p>
            <p>Message: {pageContext.exception.message}</p>
        </section>
        <footer>
            <p>TOBA Online Banking Application<br>
                @Ivan Loai</p>
        </footer>
    </body>
</html>