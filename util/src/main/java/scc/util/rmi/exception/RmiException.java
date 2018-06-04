package scc.util.rmi.exception;

import java.rmi.RemoteException;
/**
 * 
 * @ClassName: RmiException 
 * @Description: rmi异常
 * @author scc
 * @date 2014年12月25日 上午10:19:44 
 *
 */
public class RmiException extends RemoteException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4254873040086855781L;
	//
	/**
	 * 请求ip受限
	 */
	public static final int RMI_RequestIP_Error = 1;//请求ip受限
	/**
	 * 超过最大连接数
	 */
	public static final int RMI_AboveMaxConn_Error=4;//超过最大连接数
	//
	private int code;
	public RmiException() {
		super();
	}

	public RmiException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

	public RmiException(String paramString) {
		super(paramString);
	}
	public RmiException(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
