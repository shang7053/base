package scc.util.cache.util;

import java.io.Serializable;

public class Shared implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5895478997105589621L;
	private String ip;
	private int port;
	private int timeOut;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	public Shared() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Shared [ip=" + ip + ", port=" + port + ", timeOut=" + timeOut
				+ "]";
	}
	public Shared(String ip, int port, int timeOut) {
		super();
		this.ip = ip;
		this.port = port;
		this.timeOut = timeOut;
	}
}
