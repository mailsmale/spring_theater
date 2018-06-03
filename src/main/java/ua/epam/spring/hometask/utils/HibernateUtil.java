package ua.epam.spring.hometask.utils;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession(); Transaction
     * txn = currentSession.getTransaction();
     * currentSession.beginTransaction();
     *
     * Auditorium auditorium = new Auditorium();
     *
     * auditorium.setNumberOfSeats(50);
     * final String auditoriumName = "testAuditorium1";
     * auditorium.setName(auditoriumName);
     * currentSession.save(auditorium);
     * currentSession.getTransaction().commit();
     *
     *
     * Query query = session.createQuery("select distinct a.authorName from Article s where s.author
     * like "Joe%" and title = 'Spring boot');
     * List<Article> articles = query.list();
     *
     *
     * 
     */

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            SessionFactory f = new Configuration().configure().buildSessionFactory();
            return f;
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static List<Object> executeQuery(final String queryString) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.close();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createSQLQuery(
                    queryString).list();
        } catch (Exception e) {
            tx.rollback();
        }
        return new ArrayList();
    }

}
