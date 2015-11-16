package willow.data.hibernate.code;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;

import willow.business.CodeForm;
import willow.dao.hibernate.code.CodeDao;
import willow.data.AbstractBean;
import willow.data.code.ICodeData;
import willow.entity.code.Code;

/**
 * Filename:  CodeData.java
 */
public class CodeData extends AbstractBean implements ICodeData{
	
	static Logger logger = Logger.getLogger(CodeData.class);
	
	public List<Code> getCodes(BeanFactory bf,Statement stmt,CodeForm cf){
		CodeDao code = (CodeDao)bf.getBean("codedao");

		String strsql = "from " + cf.getCode();
		
		if(!"".equals(cf.getUpid()))
			strsql = strsql + " where upid = '" + cf.getUpid() + "'";
		strsql = strsql + " order by id";
		logger.info(strsql);
//		return new ArrayList();
		return code.findByQuery(strsql);
	}

}
