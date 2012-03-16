package util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //==========================================================================
    public static void closeSession(Session session) {

        if (session != null) {

            if (session.isOpen()) {
                //session.close();
            }
        }

    }

    //==========================================================================
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
} // end class