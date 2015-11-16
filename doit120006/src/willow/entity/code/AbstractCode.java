package willow.entity.code;

import java.io.Serializable;

import willow.entity.Persistence;

/**
 * Filename: AbstractCode.java
 */
public abstract class AbstractCode extends Persistence implements Serializable {
	private static final long serialVersionUID = 170307824436929065L;

	private String id="";
	private String upid="";
	private String name="";
	private String abb="";
	private String type="";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUpid() {
		return upid;
	}
	public void setUpid(String upid) {
		this.upid = upid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbb() {
		return abb;
	}
	public void setAbb(String abb) {
		this.abb = abb;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}