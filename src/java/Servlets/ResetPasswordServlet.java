package Servlets;

import JavaBean.User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the default url
        String url = "/index.jsp";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "home";
            url = "/index.jsp";
        }

        // perform actions to reset the password
        if (action.equals("resetPassword")) {
            String username = request.getParameter("username");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            String message;

            // Check if the passwords match
            if (newPassword.equals(confirmPassword)) {

                // Check the username (TODO)

                // Retrieve the user from the session
                // It may cause a NullPointerException now
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                
                // Set the password to the new password
                message = "";
                user.setPassword(newPassword);

                // Redirect to the account activity page
                url = "/account_activity.jsp";
                session.setAttribute("user", user);
            } else {
                // Display a message and redirect back to the reset password page
                message = "*The passwords did not match, please try again.";
                url = "/password_reset.jsp";
            }
            request.setAttribute("message", message);
        }

        // Forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
