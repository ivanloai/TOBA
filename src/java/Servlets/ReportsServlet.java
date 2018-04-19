package Servlets;

import Database.UserDB;
import JavaBean.User;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReportsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";

        if (action == null) {
            url = "/index.jsp";
        } else if (action.equals("refresh")) {
            url = "/admin/reports.jsp";
            List<User> reportList = UserDB.userList();
            request.setAttribute("reportList", reportList);
        }
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
