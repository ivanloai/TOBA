package Database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TOBAPU");
            
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
