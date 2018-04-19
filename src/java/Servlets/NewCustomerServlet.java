package Servlets;

import Database.AccountDB;
import Database.PasswordUtil;
import Database.UserDB;
import JavaBean.Account;
import JavaBean.User;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;

public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/new_customer.jsp";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
            url = "/new_customer.jsp";
        } else if (action.equals("register")) {
            // Get parameters
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");
            String email = request.getParameter("email");

            // Create the username with the lastname combine with the zip code
            String username = lastName + zipCode;

            // Create a temporary password "welcome1"
            String password = "welcome1";
            
            // Hash and salt password
            try {
                password = PasswordUtil.hashAndSaltPassword(password);
            } catch (NoSuchAlgorithmException e){
                e.getMessage();
            }
            

            // Check if it's empty or not
            String message;
            if (firstName == null || lastName == null || phone == null || address == null || city == null
                    || state == null || zipCode == null || email == null || firstName.isEmpty() || lastName.isEmpty()
                    || phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty()
                    || email.isEmpty()) {
                // Display the message and redirect back to the register page
                message = "*Please fill out all form fields";
                url = "/new_customer.jsp";
            } else {
                // Check if email or username exists
                if (UserDB.emailExists(email)) {
                    message = "*This E-mail is already a registered account. Please try another.";
                    url = "/new_customer.jsp";
                } else if (UserDB.usernameExists(username)) {
                    // Check if username exists
                    message = "*This Username is already registered. Please try to log in with another email, or contact us if this is your first time register.";
                    url = "/new_customer.jsp";
                } else {
                    // Create a javaBean to store the user's information
                    User user = new User(firstName, lastName, phone, address, city, state, zipCode, email, username, password);

                    // Create a Saving account with an initial balance of $25.00
                    Account savingAccount = new Account(user, 25.00, Account.Type.SAVING);

                    // Create a Checking account with an initial balance of $0.00
                    Account checkingAccount = new Account(user, 0, Account.Type.CHECKING);

                    // Insert into the database
                    UserDB.insert(user);
                    AccountDB.insert(savingAccount);
                    AccountDB.insert(checkingAccount);

                    // Add the new create user object to the session scope
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);

                    // Reddirect to the success page
                    message = "";
                    url = "/success.jsp";
                }
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
