package JavaBean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account implements Serializable {

    public enum Type {
        CHECKING, SAVING
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountNumber;
    private double balance;
    private Type accountType;

    @ManyToOne
    private User user;

    public Account() {
        this.user = new User();
        this.balance = 0.0;
        this.accountType = null;
    }

    public Account(User user, double balance, Type accountType) {
        this.user = user;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void credit(double credit) {
        this.balance += credit;
    }

    public void debit(double debit) {
        this.balance -= debit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Type getAccountType() {
        return accountType;
    }

    public void setAccountType(Type accountType) {
        this.accountType = accountType;
    }
}
