package willow.dao.hibernate.code;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;

import willow.dao.hibernate.AbstractHibernateDao;
import willow.entity.code.Code;

/**
 * Filename: CodeDao.java
 */
public class CodeDao extends AbstractHibernateDao{
	private static final Log log = LogFactory.getLog(CodeDao.class);
	
	protected void initDao(){ }

	public List<Code> findByQuery(String query) {
		log.debug("query string: " + query);
		List<Code> list = new ArrayList<Code>();
		try {
			Session session = sessionFactory.openSession(); 
			log.info(query);
			session.beginTransaction();
			list = session.createQuery(query).list();
			session.close();
		} catch (RuntimeException re) {
			log.error("find by query failed", re);
			throw re;
		}
		return list;
	}

	public static CodeDao getFromApplicationContext(ApplicationContext ctx) {
		return (CodeDao) ctx.getBean("codedao");
	}
}