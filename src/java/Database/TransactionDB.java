package Database;

import JavaBean.Transactions;
import JavaBean.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class TransactionDB {

    // Insert transaction into the databasse
    public static void insert(Transactions transactions) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(transactions);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // Select the transactions from the user
    public static List<Transactions> selectTransaction(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT t FROM Transactions t "
                + "WHERE t.account.user = :user "
                + "ORDER by t.transactionID";
        TypedQuery<Transactions> q = em.createQuery(qString, Transactions.class);
        q.setParameter("user", user);
        List<Transactions> transactions;
        try {
            transactions = q.getResultList();
            if (transactions == null || transactions.isEmpty()) {
                transactions = null;
            }
        } finally {
            em.close();
        }
        return transactions;
    }
}
