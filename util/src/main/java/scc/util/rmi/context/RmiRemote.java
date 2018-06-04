package scc.util.rmi.context;

import java.io.Serializable;
import java.util.Arrays;

class RmiRemote implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5312864823233505698L;
	private String managerClass;
	private String method;
	private Object[] args;
	public String getManagerClass() {
		return managerClass;
	}
	public void setManagerClass(String managerClass) {
		this.managerClass = managerClass;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object... args) {
		this.args = args;
	}
	@Override
	public String toString() {
		return "RmiRemote [managerClass=" + managerClass + ", method=" + method + ", args=" + Arrays.toString(args) + "]";
	}
}
