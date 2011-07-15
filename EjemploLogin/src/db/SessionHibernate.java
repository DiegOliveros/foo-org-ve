package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Anna Lezama
 */
//DONE
public class SessionHibernate {

  // singleton
  private static SessionHibernate instance = new SessionHibernate();

  private SessionFactory sessionFactory;

  // --------------------------------------------------------------------------------

  private SessionHibernate() {
    Configuration configuration = new Configuration();
    configuration.configure("/db/hibernate.cfg.xml");
    sessionFactory = configuration.buildSessionFactory();
  }

  // --------------------------------------------------------------------------------

  public static SessionHibernate getInstance() {
    return instance;
  }

  // --------------------------------------------------------------------------------

  public Session getSession() {
    return sessionFactory.openSession();
  }
}
