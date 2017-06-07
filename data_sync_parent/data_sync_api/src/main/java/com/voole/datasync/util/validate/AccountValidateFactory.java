package com.voole.datasync.util.validate;

/**
 * @ClassName: AccountValidateFactory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年9月23日 下午4:46:54
 * 
 */
public class AccountValidateFactory {
	/**
	 * 
	 * @Title: instance
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年9月23日 下午4:48:03
	 * @return
	 */
	public static IAccountValidate instance() {
		return new AccountValidate();
	}
}
