package Database;

import JavaBean.Transactions;
import JavaBean.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDB {

    // Insert User into the Database
    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // Update User
    public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    // Select a user
    public static User selectUsername(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.username = :username";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("username", username);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean usernameExists(String username) {
        User u = selectUsername(username);
        return u != null;
    }
    
    // Select a user
    public static User selectEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        User u = selectEmail(email);
        return u != null;
    }
    
    public static User login(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.username = :username AND u.password = :password";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
        public static List<User> userList() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        List<User> user;
        try {
            user = q.getResultList();
            if (user == null || user.isEmpty()) {
                user = null;
            }
        } finally {
            em.close();
        }
        return user;
    }
}
