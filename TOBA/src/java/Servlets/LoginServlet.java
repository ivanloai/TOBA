package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            url = "/index.jsp";
        } else if (action.equals("signin")) {
            // Get parameters
            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            // Check if the username is equal to jsmith@toba.com and the password is equal to letmein
            if (userName.equals("jsmith@toba.com") && password.equals("letmein")) {
                url = "/account_activity.jsp";
            } else {
                url = "/login_failure.jsp";
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
