package willow.dao.hibernate;

import org.hibernate.internal.SessionFactoryImpl;

/**
 * Filename:  AbstractHibernateDao.java
 */
public abstract class AbstractHibernateDao {
	protected SessionFactoryImpl sessionFactory = null;
	
	public SessionFactoryImpl getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactoryImpl sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
