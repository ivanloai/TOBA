package Servlets;

import Database.AccountDB;
import Database.TransactionDB;
import JavaBean.Account;
import JavaBean.Transactions;
import JavaBean.User;
import java.io.*;
import java.text.NumberFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String action = request.getParameter("action");
        String url = "";
        String message = "";

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Account checkingAccount = AccountDB.selectChecking(user);
        Account savingAccount = AccountDB.selectSavings(user);
        double checkingBalance = checkingAccount.getBalance();
        double savingBalance = savingAccount.getBalance();

        if (action == null) {
            url = "/index.jsp";
        } else if (action.equals("refresh")) {
            url = "/transaction.jsp";
        } else if (action.equals("transfer")) {
            url = "/transaction.jsp";
            String selectedAccount = request.getParameter("selectedAccount");
            String transferAmount = request.getParameter("transferAmount");
            try {
                // Check if the amount is positive
                double amount = Double.parseDouble(transferAmount);
                if (amount < 0) {
                    message = "Please enter a positive amount";
                } else {
                    // Transfer the amount to another account
                    switch (selectedAccount) {
                        case "selectedChecking":
                            if (checkingBalance < amount) {
                                message = "Do not have enough money in the Checking account to transfer";
                            } else {
                                // Transfer money
                                checkingAccount.debit(amount);
                                savingAccount.credit(amount);

                                // Update the database
                                AccountDB.update(checkingAccount);
                                AccountDB.update(savingAccount);

                                // Update the new balance
                                checkingBalance = checkingAccount.getBalance();
                                savingBalance = savingAccount.getBalance();

                                // Create a transaction
                                Transactions transaction = new Transactions(checkingAccount, new Date(), amount, checkingBalance, savingBalance);

                                // insert into the database
                                TransactionDB.insert(transaction);
                                message = "Transfered " + formatter.format(amount) + " from Checking to Saving";
                            }
                            break;
                        case "selectedSaving":
                            if (savingBalance < amount) {
                                message = "Do not have enough money in the Saving account to transfer";
                            } else {
                                // Transfer money from Saving to Checking
                                savingAccount.debit(amount);
                                checkingAccount.credit(amount);

                                // Update the database
                                AccountDB.update(savingAccount);
                                AccountDB.update(checkingAccount);

                                // Update the new balance
                                checkingBalance = checkingAccount.getBalance();
                                savingBalance = savingAccount.getBalance();

                                // Create a transaction
                                Transactions transaction = new Transactions(savingAccount, new Date(), amount, checkingBalance, savingBalance);

                                // insert into the database
                                TransactionDB.insert(transaction);

                                message = "Transfered " + formatter.format(amount) + " from Saving to Checking";
                            }
                            break;
                        default:
                            message = "Please select an account type to transfer";
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                message = "Please enter a valid amount";
            }
        }

        request.setAttribute("message", message);
        request.setAttribute("checkingBalance", formatter.format(checkingBalance));
        request.setAttribute("savingBalance", formatter.format(savingBalance));
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
