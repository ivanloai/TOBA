package Servlets;

import Database.AccountDB;
import Database.UserDB;
import JavaBean.User;
import JavaBean.Account;
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
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Create the jsmith user if not exists
            if (!UserDB.emailExists("jsmith@toba.com")) {
                // Create an user
                User jSmith = new User("J", "Smith", "7277777777", "11 Drew St", "Clearwater", "FL", "33761", "jsmith@toba.com", "jsmith@toba.com", "letmein");
                // Create an account 
                Account savingAccount = new Account(jSmith, 25.00, Account.Type.SAVING);
                Account checkingAccount = new Account(jSmith, 0, Account.Type.CHECKING);

                // Insert into the database
                UserDB.insert(jSmith);
                AccountDB.insert(savingAccount);
                AccountDB.insert(checkingAccount);
            }
            
            // Check if it can login
            User user = UserDB.login(username, password);
            if (user != null) {
                url = "/account_activity.jsp";
            } else {
                url = "/login_failure.jsp";
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
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
