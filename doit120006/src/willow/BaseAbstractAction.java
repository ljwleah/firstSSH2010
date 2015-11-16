package willow;

/**
 * Filename:  BaseAbstractAction.java
 */
public abstract class BaseAbstractAction extends BaseActionSupport{
	private static final long serialVersionUID = 7303215330427799864L;

	public String replaceSQL(String inStr) {
		if(inStr!=null) return inStr.replaceAll("'"," ");
		return inStr;
	}
}
