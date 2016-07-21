package com.voole.cdcenter.service.system.function;

import java.util.List;

import com.voole.cdcenter.entry.sytem.function.FunctionEntry;
import com.voole.cdcenter.vo.system.function.FunctionVo;

/**
 * @ClassName: IFunctionMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:31:46
 * 
 */
public interface IFunctionService {

	/**
	 * @Title: queryFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午10:54:13
	 * @param functionquerycase
	 * @return
	 */
	List<FunctionVo> queryMenuFunction(FunctionVo functionquerycase);

	/**
	 * @Title: queryFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月13日 下午1:51:24
	 * @param functionquerycase
	 * @return
	 */
	List<FunctionVo> queryFunction(FunctionVo functionquerycase);

	/**
	 * @Title: insertFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月13日 下午4:59:13
	 * @param entry
	 * @return
	 */
	Integer insertFunction(FunctionEntry entry);

	/**
	 * @Title: deleteFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 上午10:03:51
	 * @param entry
	 * @return
	 */
	boolean deleteFunction(FunctionEntry entry);

	/**
	 * @Title: updateFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 上午10:29:19
	 * @param entry
	 * @return
	 */
	boolean updateFunction(FunctionEntry entry);

}
