package JavaBean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transactions implements Serializable {

    @ManyToOne
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionID;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date transactionDate;
    private double amountTransfered;
    private double checkingBalance;
    private double savingBalance;

    public Transactions() {
        this.account = new Account();
        this.transactionDate = new java.util.Date();
        this.amountTransfered = 0.0;
        this.checkingBalance = 0.0;
        this.savingBalance = 0.0;
    }

    public Transactions(Account account, java.util.Date transactionDate, double amountTransfered, double checkingBalance, double savingBalance) {
        this.account = account;
        this.transactionDate = transactionDate;
        this.amountTransfered = amountTransfered;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmountTransfered() {
        return amountTransfered;
    }

    public void setAmountTransfered(double amountTransfered) {
        this.amountTransfered = amountTransfered;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
}
