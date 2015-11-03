/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午8:09:57
*/
package test.orm;

import test.controller.TestVO;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午8:09:57
 */
public interface ITestDao {
	public int add();

	/**
	 * <p>Description: </p>
	 * @author scc
	 * @since 创建时间：2015年11月3日 上午11:16:30
	 **********************************
	 * @param testVo 
	*/
	public void add(TestVO testVo);
}
