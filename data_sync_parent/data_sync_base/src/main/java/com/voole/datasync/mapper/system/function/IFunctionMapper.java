package com.voole.datasync.mapper.system.function;

import java.util.List;

import com.voole.datasync.entry.sytem.function.FunctionEntry;
import com.voole.datasync.vo.system.function.FunctionVo;

/**
 * @ClassName: IFunctionMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:31:46
 * 
 */
public interface IFunctionMapper {

	/**
	 * @Title: queryFunctions
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午10:55:38
	 * @param functionquerycase
	 * @return
	 */
	List<FunctionVo> queryFunctions(FunctionVo functionquerycase);

	/**
	 * @Title: insertFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月13日 下午4:59:40
	 * @param entry
	 * @return
	 */
	Integer insertFunction(FunctionEntry entry);

	/**
	 * @Title: deleteFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 上午10:04:46
	 * @param entry
	 * @return
	 */
	Integer deleteFunction(FunctionEntry entry);

	/**
	 * @Title: updateFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月14日 上午10:29:50
	 * @param entry
	 * @return
	 */
	Integer updateFunction(FunctionEntry entry);
}
