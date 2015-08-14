package scc.util.cache.util;

import java.io.Serializable;
import java.util.List;

public class RedisConfigVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3729932381240044793L;
	private int maxActive;
	private int maxIdle;
	private int minIdle;
	private int maxWait;
	private boolean testOnBorrow=false;
	private boolean testOnReturn=false;
	private boolean testWhileIdle=false;
	private int keepAliveTime;
	private boolean isCacheOn;
	private List<Shared> shareds;
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public int getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public int getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public boolean isTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}
	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	public int getKeepAliveTime() {
		return keepAliveTime;
	}
	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}
	public boolean isCacheOn() {
		return isCacheOn;
	}
	public void setCacheOn(boolean isCacheOn) {
		this.isCacheOn = isCacheOn;
	}
	public List<Shared> getShareds() {
		return shareds;
	}
	public void setShareds(List<Shared> shareds) {
		this.shareds = shareds;
	}
	@Override
	public String toString() {
		return "RedisConfigVo [maxActive=" + maxActive + ", maxIdle=" + maxIdle
				+ ", minIdle=" + minIdle + ", maxWait=" + maxWait
				+ ", testOnBorrow=" + testOnBorrow + ", testOnReturn="
				+ testOnReturn + ", testWhileIdle=" + testWhileIdle
				+ ", keepAliveTime=" + keepAliveTime + ", isCacheOn="
				+ isCacheOn + ", shareds=" + shareds + "]";
	}
}
