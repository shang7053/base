package scc.common.vo;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2231551546328033972L;
	private Integer id;
	private String uname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + "]";
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String uname) {
		super();
		this.id = id;
		this.uname = uname;
	}
}
