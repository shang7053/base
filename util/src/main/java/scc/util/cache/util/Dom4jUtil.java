package scc.util.cache.util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j工具类
 * 
 * @author scc
 * 
 */
public class Dom4jUtil {
	private static Document document;
	static {
		try {
			SAXReader reader = new SAXReader();
			reader.setValidation(false);
			reader.setEntityResolver(new IgnoreDTDEntityResolver());
			document = reader.read(Dom4jUtil.class.getClassLoader().getResourceAsStream("sccCacheConfig.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取属性
	 * 
	 * @param nodeId
	 *            节点id
	 * @param attributeName
	 *            属性名称
	 * @return 属性值(无则返回null)
	 */
	public static String getAttribute(String nodeId, String attributeName) {
		Element root = document.getRootElement();// 获取根节点
		Element target = getTargetElement(nodeId, root);
		if (target != null)
			return target.attributeValue(attributeName);
		return null;
	}

	/**
	 * 获取目标节点
	 * 
	 * @param nodeId
	 *            节点id
	 * @param item
	 *            节点对象
	 * @return 节点对象(无则返回null)
	 */
	private static Element getTargetElement(String nodeId, Element item) {
		String value = item.attributeValue("id");
		if (value != null && value.equals(nodeId)) {
			return item;
		} else {
			@SuppressWarnings("unchecked")
			List<Element> childs = item.elements();
			Element target = null;
			for (Element e : childs) {
				target = getTargetElement(nodeId, e);
				if (target != null)
					return target;
			}
			return null;
		}
	}

	/**
	 * 获取text文本
	 * 
	 * @param nodeId
	 *            节点id
	 * @return text文本(无则返回null)
	 */
	public static String getText(String nodeId) {
		Element root = document.getRootElement();// 获取根节点
		Element target = getTargetElement(nodeId, root);
		if (target != null)
			return target.getTextTrim();
		return null;
	}

	/**
	 * 获取节点
	 * 
	 * @param nodeId
	 *            节点id
	 * @return 要获取的节点(无则返回null)
	 */
	public static Element getElement(String nodeId) {
		Element root = document.getRootElement();// 获取根节点
		return getTargetElement(nodeId, root);
	}
}
