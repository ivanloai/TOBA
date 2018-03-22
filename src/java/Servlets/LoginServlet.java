package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Ivan Loai
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            url = "/index.html";
        } else if (action.equals("signin")) {
            // Get parameters
            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            // Check if the username is equal to jsmith@toba.com and the password is equal to letmein
            if (userName.equals("jsmith@toba.com") && password.equals("letmein")) {
                url = "/account_activity.html";
            } else {
                url = "/login_failure.html";
            }

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
