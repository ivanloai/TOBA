package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Ivan Loai
 */
public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/new_customer.html";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            url = "/new_customer.html";
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

            String message;
            if (firstName == null || lastName == null || phone == null || address == null || city == null
                    || state == null || zipCode == null || email == null || firstName.isEmpty() || lastName.isEmpty()
                    || phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty()
                    || email.isEmpty()) {
                message = "*Please fill out all form fields";
                url = "/new_customer.jsp";
            } else {
                message = "";
                url = "/success.html";
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
