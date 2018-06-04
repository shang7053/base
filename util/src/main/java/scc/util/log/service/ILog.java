package scc.util.log.service;

public interface ILog {
	/**
	 * 自动处理异常信息
	 * @param e 异常信息
	 */
	void autoDealException(Exception e);
	/**
	 * 将信息记录到日志里
	 * @param log 要记录的值
	 */
	void autoWritelog(String log);

}