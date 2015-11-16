package willow.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.BeanFactory;

/**
 * Filename: AbstractBean.java
 */
public abstract class AbstractBean{

	protected DateFormat ldf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected DateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

	private int recordCount = 0;
		
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public String deleteBlank(String inStr) {
		if(inStr!=null) return inStr.replaceAll("[\\f\\n\\r\\t\\v]"," ");
		return inStr;
	}
}
