package scc.util.array.center;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import scc.util.array.service.IArray;

public class ArrayImpl<T> implements IArray<T> {
	private static Logger logger = Logger.getLogger(ArrayImpl.class);
	private List<T> datasource;
	private Field[] fields;

	public ArrayImpl(List<T> datasource, Class<T> baseClass) {
		this.datasource = datasource;
		this.fields=baseClass.getDeclaredFields();
	}

	@Override
	public List<T> getList(String fieldName, Object value) {
		List<T> result = new ArrayList<>();
		// 验证参数类型
			try {
				if (!validatefieldtype(fieldName, value))
					return result;
				// 遍历list获取值集合
				for (T t : datasource) {
					if (getFieldValue(t, fieldName).equals(value))
						result.add(t);
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				logger.error(e);
				return result;
			}
		return result;
	}
	@Override
	public Map<String, List<T>> getList(String fieldName) {
		Map<String, List<T>> result = new LinkedHashMap<>();
		try {
			for (T t : datasource) {
				String value=String.valueOf(getFieldValue(t, fieldName));
				if (result.containsKey(value)) {
					result.get(value).add(t);
				}else{
					List<T> temp=new ArrayList<>();
					temp.add(t);
					result.put(value, temp);
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			logger.error(e);
			return result;
		}
		return result;
	}

	private Object getFieldValue(T t, String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		return getField(fieldName).get(t);
	}

	private boolean validatefieldtype(String fieldName, Object value) throws NoSuchFieldException, SecurityException {
		return getField(fieldName).getType().isAssignableFrom(value.getClass());
	}
	private Field getField(String fieldName){
		for (Field field : fields) {
			field.setAccessible(true);
			if(field.getName().equals(fieldName)){
				return field;
			}
		}
		return null;
	}

	@Override
	public List<String> getValueByFieldName(String fieldName) {
		List<String> result=new ArrayList<>();
			for (T t : datasource) {
				String value;
				try {
					value = String.valueOf(getFieldValue(t, fieldName));
					if (!result.contains(value)) 
						result.add(value);
				} catch (IllegalArgumentException | IllegalAccessException
						| NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
			}
		return result;
	}
}
