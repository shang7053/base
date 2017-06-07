package com.voole.datasync.util.validate;

/**
 * @ClassName: IAccountValidate
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年9月23日 下午4:47:08
 * 
 */
public interface IAccountValidate {
	/**
	 * 
	 * @Title: validateMysql
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年9月23日 下午4:51:37
	 * @param ip
	 * @param port
	 * @param dbname
	 * @param uname
	 * @param password
	 * @return
	 */
	boolean validateMysql(String ip, Integer port, String dbname, String uname, String password);

	/**
	 * 
	 * @Title: validateMycat
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年9月23日 下午4:51:46
	 * @param ip
	 * @param port
	 * @param dbname
	 * @param uname
	 * @param password
	 * @return
	 */
	boolean validateMycat(String ip, Integer port, String dbname, String uname, String password);

	/**
	 * 
	 * @Title: validateRedis
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年9月23日 下午4:51:51
	 * @param ip
	 * @param port
	 * @param uname
	 * @param password
	 * @param deployType
	 * @return
	 */
	boolean validateRedis(String ip, Integer port, String uname, String password, DeployType deployType);

	/**
	 * 
	 * @Title: validateKafka
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年9月23日 下午4:51:51
	 * @param ip
	 * @param port
	 * @param uname
	 * @param password
	 * @param deployType
	 * @return
	 */
	boolean validateKafka(String ip, Integer port);
}
