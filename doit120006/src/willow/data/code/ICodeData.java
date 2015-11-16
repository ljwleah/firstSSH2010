package willow.data.code;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;

import willow.business.CodeForm;
import willow.data.IBeanFactory;
import willow.entity.code.Code;

/**
 * Filename: ICodeData.java
 */
public interface ICodeData extends IBeanFactory{
	public List<Code> getCodes(BeanFactory bf,Statement stmt,CodeForm cf) throws SQLException ;

}
