package Servlets;

import Database.TransactionDB;
import JavaBean.Transactions;
import JavaBean.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountActivityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action");
        String url = "";

        if (action == null) {
            url = "/index.jsp";
        } else if (action.equals("refresh")) {
            url = "/account_activity.jsp";

            List<Transactions> transactionList = TransactionDB.selectTransaction(user);
            request.setAttribute("transactionList", transactionList);
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
