package Database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import JavaBean.Account;
import JavaBean.User;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AccountDB {

    // Insert into the database
    public static void insert(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // Update the database  
    public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // Select the Checking account of a user
    public static Account selectChecking(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Account u "
                + "WHERE u.user.username = :username AND u.accountType = :account";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("username", user.getUsername());
        q.setParameter("account", Account.Type.CHECKING);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    // Select the Saving acount
    public static Account selectSavings(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Account u "
                + "WHERE u.user.username = :username AND u.accountType = :account";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("username", user.getUsername());
        q.setParameter("account", Account.Type.SAVING);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
