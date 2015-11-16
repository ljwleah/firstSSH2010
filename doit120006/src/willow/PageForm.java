package willow;

/**
 * Filename: PageForm.java
 */
public class PageForm extends BaseAbstractAction {
    private static final long serialVersionUID = 4990956865140902953L;

    private int pageCount = 0;
    private int pageSizes = 15;
    private int pagePoint = 0;
    private String func = "";
    private String cond = "";
  
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSizes() {
		return pageSizes;
	}
	public void setPageSizes(int pageSizes) {
		this.pageSizes = pageSizes;
	}
	public int getPagePoint() {
		return pagePoint;
	}
	public void setPagePoint(int pagePoint) {
		this.pagePoint = pagePoint;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public String getCond() {
		return cond;
	}
	public void setCond(String cond) {
		this.cond = cond;
	}
}

