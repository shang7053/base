package scc.util.array.service;

import java.util.List;
import java.util.Map;

public interface IArray<T> {
	/**
	 * 
	 * @Title: getList 
	 * @Description: 根据属性名及值从list里获取子集合
	 * @param fieldName 属性名
	 * @param value 要取出的值依据,其类型必须跟实体或vo的对应字段类型相同
	 * @return 所有属性名为fieldName的且值为value的集合
	 */
	List<T> getList(String fieldName,Object value);
	/**
	 * 
	 * @Title: getList 
	 * @Description: 根据属性名将原始list按属性名的不同值进行分类
	 * @param fieldName 属性名
	 * @return 按属性名的不同值进行分类后的list
	 */
	Map<String, List<T>> getList(String fieldName);
	/**
	 * 根据属性名称，获取该值集合
	 * @param fieldName 属性名
	 * @return 值集合
	 */
	List<String> getValueByFieldName(String fieldName);
}
